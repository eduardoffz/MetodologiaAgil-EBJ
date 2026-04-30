package com.senai.patrimonio.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {

  
    private static final String URL      = "jdbc:mysql://localhost:3337/patrimonio_senai";
    private static final String USUARIO  = "root";
    private static final String SENHA    = "root";
    // =====================================================

 
    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado. Adicione mysql-connector-java ao projeto.", e);
        }
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
