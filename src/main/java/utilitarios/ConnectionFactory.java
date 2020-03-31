/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import static java.sql.DriverManager.getConnection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import models.pessoa;

/**
 *
 * @author vinicius
 */
/**criando uma classe de conecxão Conection Factoy */
public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        /**salvando informações necessarias pra conexão */
        String url = "jdbc:postgresql://localhost:5432/SistemaAps";
        String usuario = "postgres";
        String senha = "240816vsb";
        
        Class.forName("org.postgresql.Driver");
        /**retornando o resultado da conexão*/
        return DriverManager.getConnection(url, usuario, senha);
    }
    
    /**testando a conexão */
    public static void main(String[] args) {
        try{
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("DEU CERTO !!!!!!!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("DEU ERRADO"+ ex);
        }catch (SQLException ex) {
            System.out.println("DEU ERRADO "+ ex);
        }
    }
}