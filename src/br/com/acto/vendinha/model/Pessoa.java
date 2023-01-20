package br.com.acto.vendinha.model;

import java.util.Objects;

public class Pessoa extends BaseModel {

    private String nome;
    private String endereco;
    private String contato;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(contato, pessoa.contato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome,  endereco, contato);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }
}
