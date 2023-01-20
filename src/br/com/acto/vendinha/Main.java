package br.com.acto.vendinha;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.entity.PessoaFisicaEntity;
import br.com.acto.vendinha.entity.PessoaJuridicaEntity;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection con;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new MSSqlServerConnection();
        con = connectionFactory.getConexao();
        criarTabelas();
    }

    private static void criarTabelas() {
        try {
            Statement statement = con.createStatement();

            String sqlCliente = "if not exists (select * from sysobjects where name='cliente' and xtype='U') \n" +
                    "CREATE TABLE cliente ( \n" +
                    "id INT NOT NULL IDENTITY(1,1), \n" +
                    "nome VARCHAR(255) NOT NULL, \n" +
                    "email VARCHAR(255) NOT NULL, \n" +
                    "cpf INT NOT NULL, \n" +
                    "telefone VARCHAR(255), \n" +
                    "CONSTRAINT pk_cliente PRIMARY KEY (id), \n" +
                    "CONSTRAINT uq_email UNIQUE(email), \n" +
                    "CONSTRAINT uq_cpf UNIQUE(cpf) \n" +
                    ")";
            statement.addBatch(sqlCliente);

            String sqlProduto = "if not exists (select * from sysobjects where name='produto' and xtype='U') \n"+
                    "CREATE TABLE produto ( \n"+
                    "id INT NOT NULL IDENTITY (1,1), \n" +
                    "descricao TEXT NOT NULL, \n"+
                    "valor DECIMAL NOT NULL, \n" +
                    "marca VARCHAR(255) NOT NULL, \n"+
                    "modelo VARCHAR(255) NOT NULL, \n" +
                    "data DATE, \n"+
                    "CONSTRAINT pk_produto PRIMARY KEY (id) \n"+
                    ")";
            statement.addBatch(sqlProduto);

            String sqlPessoFisica = "if not exists (select * from sysobjects where name='pessoa_fisica' and xtype='U') \n"+
                    "CREATE TABLE pessoa_fisica ( \n"+
                    "id INT NOT NULL IDENTITY (1,1), \n" +
                    "nome VARCHAR(255) NOT NULL, \n"+
                    "endereco VARCHAR(255) NOT NULL, \n" +
                    "contato VARCHAR(255) NOT NULL, \n"+
                    "idade INT NOT NULL, \n" +
                    "cpf VARCHAR(255) NOT NULL, \n"+
                    "rg VARCHAR(255) NOT NULL, \n"+
                    "sexo VARCHAR(255) NOT NULL, \n"+
                    "CONSTRAINT pk_pessoa_fisica PRIMARY KEY (id), \n"+
                    "CONSTRAINT uq_cpf_fisico UNIQUE(cpf), \n"+
                    "CONSTRAINT uq_rg UNIQUE(rg) \n"+
                    ")";
            statement.addBatch(sqlPessoFisica);

            String sqlPessoaJuridica = "if not exists (select * from sysobjects where name='pessoa_juridica' and xtype='U') \n"+
                    "CREATE TABLE pessoa_juridica ( \n"+
                    "id INT NOT NULL IDENTITY (1,1), \n" +
                    "nome VARCHAR(255) NOT NULL, \n"+
                    "endereco DECIMAL NOT NULL, \n" +
                    "contato VARCHAR(255) NOT NULL, \n"+
                    "cnpj VARCHAR(255) NOT NULL, \n" +
                    "razaoSocial VARCHAR(255) NOT NULL, \n"+
                    "CONSTRAINT pk_pessoaJuridica PRIMARY KEY (id), \n" +
                    "CONSTRAINT uq_cnpj UNIQUE(cnpj), \n"+
                    "CONSTRAINT uq_razao UNIQUE(razaoSocial) \n"+
                    ")";
            statement.addBatch(sqlPessoaJuridica);

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






