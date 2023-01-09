package br.com.acto.vendinha.model;

import java.math.BigInteger;

public class Produto extends BaseModel{

    private String nome;
    private BigInteger ncm;

    public Produto(String nome, BigInteger ncm) {
        this.nome = nome;
        this.ncm = ncm;
    }

    public Produto(Long id,String nome, BigInteger ncm) {
        super.setId(id);
        this.nome = nome;
        this.ncm = ncm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getNcm() {
        return ncm;
    }

    public void setNcm(BigInteger ncm) {
        this.ncm = ncm;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "Nome='" + nome + '\'' +
                '}';
    }
}
