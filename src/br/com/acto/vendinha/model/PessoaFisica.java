package br.com.acto.vendinha.model;

import java.util.Objects;

public class PessoaFisica extends Pessoa{

    private Integer idade;
    private String cpf;
    private String rg;
    private String sexo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(cpf, that.cpf) && Objects.equals(rg, that.rg) && Objects.equals(sexo, that.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf, rg, sexo);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", sexo='" + sexo + '\'' +
                ", " + super.toString() + '\'' +
                '}';
    }
}
