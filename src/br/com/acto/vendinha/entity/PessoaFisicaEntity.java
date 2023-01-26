package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.model.Cliente;
import br.com.acto.vendinha.model.Pessoa;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaEntity{

    private Connection connection;

    private Connection getConexao() {
        if(connection == null) {
            ConnectionFactory connectionFactory = new MSSqlServerConnection();
            connection = connectionFactory.getConexao();
        }
        return connection;
    }

    public PessoaFisicaEntity() {
        getConexao();
    }

    public List<PessoaFisica> buscarTodos() {
        List<PessoaFisica> resultado = new ArrayList<>(); // lista vazia para o resultado
        try {

            String sql = "SELECT * FROM pessoa_fisica";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setId(resultSet.getLong("id"));
                pessoaFisica.setNome(resultSet.getString("nome"));
                pessoaFisica.setIdade(resultSet.getInt("idade"));
                pessoaFisica.setEndereco(resultSet.getString("endereco"));
                pessoaFisica.setContato(resultSet.getString("contato"));
                pessoaFisica.setCpf(resultSet.getString("cpf"));
                pessoaFisica.setRg(resultSet.getString("rg"));
                pessoaFisica.setSexo(resultSet.getString("sexo"));
                resultado.add(pessoaFisica);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public void inserirPessoaFisica(String nome, Integer idade, String endereco, String contato,
                                      String cpf, String rg, String sexo) throws SQLException {

        String insertQuery = "INSERT INTO pessoa_fisica (nome, idade, endereco," +
                "contato, cpf, rg, sexo) VALUES (?, ?, ?, ?, ?, ?, ?);";


        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, nome);
        statement.setInt(2, idade);
        statement.setString(3, endereco);
        statement.setString(4, contato);
        statement.setString(5, cpf);
        statement.setString(6, rg);
        statement.setString(7, sexo);

        int linhasAfetadas = 0;
        try{
            linhasAfetadas = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(linhasAfetadas + " linhas inseridas");
        }

    }

    public void inserirPessoaFisica(PessoaFisica pessoaFisica) throws SQLException {

        String insertQuery = "INSERT INTO pessoa_fisica (nome, idade, endereco," +
                "contato, cpf, rg, sexo) VALUES (?, ?, ?, ?, ?, ?, ?);";


        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, pessoaFisica.getNome());
        statement.setInt(2, pessoaFisica.getIdade());
        statement.setString(3, pessoaFisica.getEndereco());
        statement.setString(4, pessoaFisica.getContato());
        statement.setString(5, pessoaFisica.getCpf());
        statement.setString(6, pessoaFisica.getRg());
        statement.setString(7, pessoaFisica.getSexo());

        int linhasAfetadas = 0;
        try{
            linhasAfetadas = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(linhasAfetadas + " linhas inseridas");
        }

    }

    public void atualizarPessoaFisica(PessoaFisica pessoaFisica) throws SQLException {
        String atualizarQuery = "UPDATE pessoa_fisica SET nome=?, idade=?, endereco=?, contato=?, cpf=?, rg=?, sexo=? where id = ?;";


        PreparedStatement statement = connection.prepareStatement(atualizarQuery);
        statement.setString(1, pessoaFisica.getNome());
        statement.setInt(   2, pessoaFisica.getIdade());
        statement.setString(3, pessoaFisica.getEndereco());
        statement.setString(4, pessoaFisica.getContato());
        statement.setString(5, pessoaFisica.getCpf());
        statement.setString(6, pessoaFisica.getRg());
        statement.setString(7, pessoaFisica.getSexo());
        statement.setLong(  8, pessoaFisica.getId());

        int linhasAfetadas = 0;
        try{
            linhasAfetadas = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(linhasAfetadas + " linhas atualizadas");
        }
    }

    public void excluirPessoaFisica(PessoaFisica pessoaFisica) throws SQLException{
        String excluirQuery = "DELETE pessoa_fisica where id=?;";


        PreparedStatement statement = connection.prepareStatement(excluirQuery);
        statement.setLong(1, pessoaFisica.getId());

        int linhasAfetadas = 0;
        try{
            linhasAfetadas = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println(linhasAfetadas + " linhas deletadas");
        }
    }

}
