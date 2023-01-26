package br.com.acto.vendinha.model;

import java.util.Objects;

public class PessoaJuridica extends Pessoa{

    private String cnpj;
    private String razaoSocial;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long id, String nome, String endereco, String contato,
                          String cnpj, String razaoSocial) {
        super.setId(id);
        super.setNome(nome);
        super.setEndereco(endereco);
        super.setContato(contato);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }
    public PessoaJuridica(String nome, String endereco, String contato,
                          String cnpj, String razaoSocial) {
        super.setNome(nome);
        super.setEndereco(endereco);
        super.setContato(contato);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public PessoaJuridica(String cnpj, String razaoSocial) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public PessoaJuridica(Long id) {
        super.setId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return Objects.equals(cnpj, that.cnpj) && Objects.equals(razaoSocial, that.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cnpj, razaoSocial);
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", " + super.toString() + '\'' +
                '}';
    }
}
