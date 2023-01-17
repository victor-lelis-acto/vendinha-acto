package br.com.acto.vendinha;

import br.com.acto.vendinha.db.ConnectionFactory;
import br.com.acto.vendinha.db.MSSqlServerConnection;
import br.com.acto.vendinha.entity.PessoaFisicaEntity;
import br.com.acto.vendinha.entity.PessoaJuridicaEntity;
import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ConnectionFactory connection = new MSSqlServerConnection(); // polimorfismo
        Connection con = connection.conectarDB();
        con.close();

    }
}
