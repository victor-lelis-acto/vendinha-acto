package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaEntity{


    private Connection connection;

    private Connection getConexao() {
        if(connection == null) {
            ConnectionFactory connectionFactory = new MSSqlServerConnection();
            connection = connectionFactory.getConexao();
        }
        return connection;
    }

    public List<PessoaJuridica> buscarTodos() {
        List<PessoaJuridica> resultado = new ArrayList<>(); // lista vazia para o resultado
        try {
            getConexao();
            String sql = "SELECT * FROM pessoa_fisica";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setId(resultSet.getLong("id"));
                pessoaJuridica.setNome(resultSet.getString("nome"));
                pessoaJuridica.setEndereco(resultSet.getString("endereco"));
                pessoaJuridica.setContato(resultSet.getString("contato"));
                pessoaJuridica.setCnpj(resultSet.getString("cpf"));
                pessoaJuridica.setRazaoSocial(resultSet.getString("rg"));
                resultado.add(pessoaJuridica);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public void inserirPessoaJuridica(String nome, String endereco, String contato,
                                        String cnpj, String razaoSocial) throws SQLException {

        String insertQuery = "INSERT INTO pessoa_juridica (nome, endereco," +
                "contato, cnpj, razaoSocial) VALUES (?, ?, ?, ?, ?);";

        getConexao();
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, nome);
        statement.setString(2, endereco);
        statement.setString(3, contato);
        statement.setString(4, cnpj);
        statement.setString(5, razaoSocial);

        int linhasAfetadas = 0;
        try{
            linhasAfetadas = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(linhasAfetadas + " linhas afetadas");
        }



    }

    public void inserirPessoaJuridica(PessoaJuridica pessoaJuridica) throws SQLException {

        String insertQuery = "INSERT INTO pessoa_juridica (nome, endereco," +
                "contato, cnpj, razaoSocial) VALUES (?, ?, ?, ?, ?);";

        getConexao();
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, pessoaJuridica.getNome());
        statement.setString(2, pessoaJuridica.getEndereco());
        statement.setString(3, pessoaJuridica.getContato());
        statement.setString(4, pessoaJuridica.getCnpj());
        statement.setString(5, pessoaJuridica.getRazaoSocial());

        int linhasAfetadas = 0;
        try{
            linhasAfetadas = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(linhasAfetadas + " linhas afetadas");
        }



    }

}
