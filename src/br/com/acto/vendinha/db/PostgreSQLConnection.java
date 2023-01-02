package br.com.acto.vendinha.db;

import br.com.acto.vendinha.model.PessoaFisica;
import br.com.acto.vendinha.model.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class PostgreSQLConnection implements ConnectionFactory{

    @Override
    public void conectarDB() {
        System.out.println("Banco de dados conectado...");
    }
}
