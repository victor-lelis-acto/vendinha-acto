package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.model.Cliente;
import br.com.acto.vendinha.model.PessoaFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteEntity{

    private Connection connection;

    private Connection getConexao() {
        if(connection == null) {
            ConnectionFactory connectionFactory = new MSSqlServerConnection();
            connection = connectionFactory.getConexao();
        }
        return connection;
    }

    public List<Cliente> buscarTodos() {
        List<Cliente> resultado = new ArrayList<Cliente>(); // lista vazia para o resultado
        try {
            getConexao();
            String sql = "SELECT * FROM cliente";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setCpf(resultSet.getInt("cpf"));
                cliente.setTelefone(resultSet.getString("telefone"));
                resultado.add(cliente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public void inserirCliente(String nome, String email,
                                    Integer cpf, String telefone) throws SQLException {

        String insertQuery = "INSERT INTO cliente (nome, email, cpf," +
                "telefone) VALUES (?, ?, ?, ?);";

        getConexao();
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, nome);
        statement.setString(2, email);
        statement.setInt(3, cpf);
        statement.setString(4, telefone);

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

    public void inserirCliente(Cliente cliente) throws SQLException {

        String insertQuery = "INSERT INTO cliente(nome, email," +
                "cpf, telefone) VALUES (?, ?, ?, ?);";

        getConexao();
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setInt(3, cliente.getCpf());
        statement.setString(4, cliente.getTelefone());

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