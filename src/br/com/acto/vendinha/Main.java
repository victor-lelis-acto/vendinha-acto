package br.com.acto.vendinha;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.PostgreSQLConnection;
import br.com.acto.vendinha.entity.PessoaFisicaEntity;
import br.com.acto.vendinha.entity.PessoaJuridicaEntity;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;

public class Main {

    public static void main(String[] args) {

        ConnectionFactory connection = new PostgreSQLConnection(); // polimorfismo
        connection.conectarDB();

        PessoaFisicaEntity pessoaFisicaEntity = new PessoaFisicaEntity();
        PessoaFisica jao = new PessoaFisica();
        jao.setNome("Jão da Silva");
        jao.setCpf("12345678910");
        jao.setRg("456879213854");
        jao.setSexo("Masculino");
        pessoaFisicaEntity.cadastrar(jao);

        PessoaJuridicaEntity pessoaJuridicaEntity = new PessoaJuridicaEntity();
        PessoaJuridica vendinha = new PessoaJuridica();
        vendinha.setNome("Vendinha ACTO");
        vendinha.setCnpj("1234567899876541");
        vendinha.setRazaoSocial("Vendinha ACTO - LTDA");
        pessoaJuridicaEntity.cadastrar(vendinha);

        System.out.println(pessoaFisicaEntity.buscarTodos());
        System.out.println(pessoaJuridicaEntity.buscarTodos());

    }
}
