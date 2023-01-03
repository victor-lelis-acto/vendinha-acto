package br.com.acto.vendinha.model;

import java.math.BigInteger;

public class Produto extends BaseModel{

    private String Nome;
    private BigInteger NCM;

    public Produto(String nome, BigInteger NCM) {
        this.Nome = nome;
        this.NCM = NCM;
    }

    public Produto(String nome, BigInteger NCM, Long id) {
        super.setId(id);
        this.Nome = nome;
        this.NCM = NCM;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Nome='" + Nome + '\'' +
                '}';
    }
}
