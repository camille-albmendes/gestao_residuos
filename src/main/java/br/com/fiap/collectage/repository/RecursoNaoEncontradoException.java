package br.com.fiap.collectage.repository;

public class RecursoNaoEncontradoException extends Exception {
    public <T> RecursoNaoEncontradoException(Class<T> clazz) {
        super("O recurso do tipo " + clazz.getName() + " não foi encontrado");
    }
}
