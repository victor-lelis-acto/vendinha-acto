package br.com.acto.vendinha.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {

    Connection conectarDB() throws SQLException, ClassNotFoundException; // método abstrato
}
