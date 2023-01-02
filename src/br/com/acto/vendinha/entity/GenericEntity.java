package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.BaseModel;
import br.com.acto.vendinha.model.PessoaFisica;

import java.util.List;

public class GenericEntity <T extends BaseModel> {

    public T buscarPorId() {
        return null;
    }

    public List<T> buscarTodos() {
        return null;
    }

    public void cadastrar(T obj) {

    }

    public void atualizar(T obj) {

    }

    public void remover(T obj) {

    }

}
