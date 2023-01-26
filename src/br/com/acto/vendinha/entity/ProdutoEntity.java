package br.com.acto.vendinha.entity;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdutoEntity{

    private Connection connection;

    private Connection getConexao() {
        if(connection == null) {
            ConnectionFactory connectionFactory = new MSSqlServerConnection();
            connection = connectionFactory.getConexao();
        }
        return connection;
    }

    public ProdutoEntity() {
        getConexao();
    }

    public List<Produto> buscarTodos() {
        List<Produto> resultado = new ArrayList<Produto>(); // lista vazia para o resultado
        try {

            String sql = "SELECT * FROM produto";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getLong("id"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setValor(resultSet.getDouble("valor"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setModelo(resultSet.getString("modelo"));
                produto.setVencimento(resultSet.getDate("vencimento"));
                resultado.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public void inserirProduto(String descricao, Double valor, String marca,
                               String modelo, Date vencimento) throws SQLException {

        String insertQuery = "INSERT INTO produto (descricao, valor, marca," +
                "modelo, vencimento) VALUES (?, ?, ?, ?, ?);";


        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, descricao);
        statement.setDouble(2, valor);
        statement.setString(3, marca);
        statement.setString(4, modelo);
        statement.setDate(5, (java.sql.Date) vencimento);

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

    public void inserirProduto(Produto produto) throws SQLException {

        String insertQuery = "INSERT INTO produto (descricao, valor, marca," +
                "modelo, vencimento) VALUES (?, ?, ?, ?, ?);";


        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, produto.getDescricao());
        statement.setDouble(2, produto.getValor());
        statement.setString(3, produto.getMarca());
        statement.setString(4, produto.getModelo());
        statement.setDate(5, (java.sql.Date) produto.getVencimento());

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

    public void atualizarProduto(Produto produto) throws SQLException {

        String insertQuery = "UPDATE produto SET descricao=?, valor=?, marca=?," +
                "modelo=?, vencimento=? WHERE id = ?;";


        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, produto.getDescricao());
        statement.setDouble(2, produto.getValor());
        statement.setString(3, produto.getMarca());
        statement.setString(4, produto.getModelo());
        statement.setDate(5, (java.sql.Date) produto.getVencimento());
        statement.setLong(6, produto.getId());

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

    public void excluirProduto(Produto produto) throws SQLException {

        String deletetQuery = "DELETE produto WHERE id = ?;";


        PreparedStatement statement = connection.prepareStatement(deletetQuery);
        statement.setLong(1, produto.getId());

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
