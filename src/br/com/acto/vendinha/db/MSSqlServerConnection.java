package br.com.acto.vendinha.db;

import java.sql.*;

public class MSSqlServerConnection implements ConnectionFactory {
    private Connection connection;

    public Connection conectarDB() {

        String connectionUrl = "jdbc:sqlserver://VICTORLELISSUPA\\SQLEXPRESS;databaseName=vendinha;encrypt=false;user=Sup;password=ddtank12;";
        try {
            System.out.println("Iniciando conexão com o DB...");
            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Banco de dados conectado com sucesso!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no BD");
            e.printStackTrace();
            return null;
        }
    }

    public Connection getConexao() {
        if(connection == null) {
            return this.conectarDB();
        } else return connection;
    }
}