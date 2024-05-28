-- Criando uma trigger para automatizar a criação de coleta para o dia seguinte ao inserir uma linha em residencias_para_coletar_lixo

CREATE OR REPLACE TRIGGER criar_coleta_automatica
AFTER INSERT ON tbl_residencias_para_coletar_lixo
FOR EACH ROW
DECLARE
    v_coletaId tbl_coleta.cod_id%TYPE;
BEGIN
    -- Verificando se já existe uma coleta para o dia seguinte
    BEGIN
        SELECT cod_id INTO v_coletaId
        FROM tbl_coleta
        WHERE dat_data_coleta = TRUNC(SYSDATE) + 1;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
          v_coletaId := NULL;
    END;

    -- Se não existir, cria uma nova coleta para o dia seguinte
    IF v_coletaId IS NULL THEN
        INSERT INTO tbl_coleta (cod_id, dat_data_coleta, txt_tipo_residuo, idn_concluida)
        VALUES (seq_coleta.NEXTVAL, TRUNC(SYSDATE) + 1, 'ORGANICO', 0);
    END IF;
END;
/


-- Criando uma trigger para automatizar a criação de registros em coleta_logradouros ao inserir uma linha em residencias_para_coletar_lixo

create or replace TRIGGER criar_coleta_logradouros_automatica
AFTER INSERT ON tbl_residencias_para_coletar_lixo
FOR EACH ROW
FOLLOWS criar_coleta_automatica
BEGIN
    INSERT INTO tbl_coleta_logradouros (cod_coleta_id, cod_logradouro_id)
    VALUES (
        (
            SELECT c.cod_id
            FROM tbl_coleta c
            WHERE c.dat_data_coleta = TRUNC(SYSDATE) + 1
        ),
        :NEW.COD_RESIDENCIA_ID
    );
END;
/



-- Automatiza a desmarcação geral de "coleta necessária" em todas as residências localizadas nos logradouros em que uma coleta foi realizada

CREATE OR REPLACE TRIGGER desmarcar_necessidade_coleta
AFTER UPDATE ON tbl_coleta
FOR EACH ROW
WHEN (NEW.idn_concluida = 1)
DECLARE
    marcacao_coleta_id tbl_residencias_para_coletar_lixo.cod_id%TYPE;
    CURSOR cursor_coleta_necessaria IS
        SELECT
            tbl_residencias_para_coletar_lixo.cod_id
        FROM
            tbl_residencias_para_coletar_lixo
            INNER JOIN tbl_residencias
                ON tbl_residencias.cod_id = tbl_residencias_para_coletar_lixo.cod_residencia_id
        WHERE
            tbl_residencias.cod_logradouro_id IN (
                SELECT
                    tbl_coleta_logradouros.cod_logradouro_id
                FROM
                    tbl_coleta_logradouros
                WHERE
                    tbl_coleta_logradouros.cod_coleta_id = :NEW.cod_id
            )
    FOR UPDATE;
BEGIN
    OPEN cursor_coleta_necessaria;
    LOOP
        FETCH cursor_coleta_necessaria INTO marcacao_coleta_id;
        EXIT WHEN cursor_coleta_necessaria%NOTFOUND;
        DELETE FROM tbl_residencias_para_coletar_lixo WHERE cod_id = marcacao_coleta_id;
    END LOOP;
    CLOSE cursor_coleta_necessaria;
END;
/



-- Automatiza o update do dado "dataUltimaColeta" de todas as residências localizadas nos logradouros em que uma coleta foi realizada

CREATE OR REPLACE TRIGGER atualiza_dataUltimaColeta
AFTER UPDATE ON tbl_coleta
FOR EACH ROW
WHEN (NEW.idn_concluida = 1)
DECLARE
    residencia_id tbl_residencias.cod_id%TYPE;
    CURSOR cursor_residencias IS
        SELECT
            tbl_residencias.cod_id
        FROM
            tbl_residencias
        WHERE
            tbl_residencias.cod_logradouro_id IN (
                SELECT
                    tbl_coleta_logradouros.cod_logradouro_id
                FROM
                    tbl_coleta_logradouros
                WHERE
                    tbl_coleta_logradouros.cod_coleta_id = :NEW.cod_id
            )
    FOR UPDATE;
BEGIN
    OPEN cursor_residencias;
    LOOP
        FETCH cursor_residencias INTO residencia_id;
        EXIT WHEN cursor_residencias%NOTFOUND;
        UPDATE tbl_residencias SET dat_data_ultima_coleta = TRUNC(SYSDATE) WHERE cod_id = residencia_id;
    END LOOP;
    CLOSE cursor_residencias;
END;
/



-- Verifica se a capacidade atual está próxima do limite máximo
-- Se estiver próxima do limite, coloca a residência na fila para ter o lixo coletado

CREATE OR REPLACE TRIGGER checa_capacidade_residencia
AFTER UPDATE OF IND_CAPACIDADE ON TBL_RESIDENCIAS
FOR EACH ROW
DECLARE
    limite_ultrapassado BOOLEAN := FALSE;
BEGIN
    IF :NEW.IND_CAPACIDADE >= 70 THEN
        limite_ultrapassado := TRUE;
    END IF;

    IF limite_ultrapassado THEN
        begin
            INSERT INTO TBL_RESIDENCIAS_PARA_COLETAR_LIXO (COD_ID, COD_RESIDENCIA_ID, DAT_HORA)
            VALUES (SEQ_RESIDENCIAS_PARA_COLETAR_LIXO.NEXTVAL, :NEW.cod_id, SYSDATE);
        exception
           when dup_val_on_index then null;
        end;
    END IF;
END;
/

