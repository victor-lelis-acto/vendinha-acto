package br.com.acto.vendinha.db;

import java.sql.*;

public class MSSqlServerConnection implements ConnectionFactory {

    @Override
    public Connection conectarDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://VICTORLELISSUPA\\SQLEXPRESS;databaseName=vendinha;encrypt=false;user=Sup;password=ddtank12;";
        //String connectionUrl = "jdbc:sqlserver://VICTORLELISSUPA\\SQLEXPRESS;encrypt=false;integratedSecurity=true";
        Connection con = DriverManager.getConnection(connectionUrl);

        try (con; Statement stmt = con.createStatement();) {
            String query = "SELECT * FROM dbo.cliente";
            ResultSet re = stmt.executeQuery(query);

            while (re.next()){
                System.out.println("id: " + re.getInt("id"));
                System.out.println("nome: " + re.getString("nome"));
                System.out.println("email: " + re.getString("email"));
                System.out.println("cpf: " + re.getString("cpf"));
                System.out.println("telefone: " + re.getString("telefone"));
                System.out.println();
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}