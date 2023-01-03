package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoEntity extends GenericEntity<Produto>{

    public List<Produto> Produtos;

    public ProdutoEntity() {
        Produtos = new ArrayList<>();
    }

    @Override
    public List<Produto> buscarTodos() {
        return Produtos;
    }

    @Override
    public void cadastrar(Produto obj) {
       Produtos.add(obj);
    }

//    @Override
//    public void atualizar(Produto obj) {
//        super.atualizar(obj);
//    }
//
//    @Override
//    public void remover(Produto obj) {
//        super.remover(obj);
//    }

    @Override
    public String toString() {
        return "ProdutoEntity{" +
                "Produtos=" + Produtos +
                '}';
    }
}
