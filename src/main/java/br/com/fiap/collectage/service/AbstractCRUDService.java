package br.com.fiap.collectage.service;

import br.com.fiap.collectage.model.DBEntity;
import br.com.fiap.collectage.repository.RecursoNaoEncontradoException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCRUDService<T extends DBEntity> {
    protected final JpaRepository<T, Long> repository;
    private final Class<T> clazz;
    
    public AbstractCRUDService(Class<T> clazz, JpaRepository<T, Long> repository) {
        this.clazz = clazz;
        this.repository = repository;
    }
    
    public T salvar(T t){
        return repository.save(t);
    }

    public T buscarPorId(Long id) throws RecursoNaoEncontradoException {
        Optional<T> coletaOptional = repository.findById(id);

        if (coletaOptional.isPresent()){
            return coletaOptional.get();
        } else {
            throw new RecursoNaoEncontradoException(clazz);
        }
    }

    public List<T> listarTodos(){
        return repository.findAll();
    }

    public void excluir(Long id) throws RecursoNaoEncontradoException {
        Optional<T> coletaOptional = repository.findById(id);

        if (coletaOptional.isPresent()){
            repository.delete(coletaOptional.get());
        } else {
            throw new RecursoNaoEncontradoException(clazz);
        }
    }

    public T atualizar(T t) throws RecursoNaoEncontradoException {
        Optional<T> coletaOptional = repository.findById(t.getId());

        if (coletaOptional.isPresent()){
            return repository.save(t);
        } else {
            throw new RecursoNaoEncontradoException(clazz);
        }
    }
}
