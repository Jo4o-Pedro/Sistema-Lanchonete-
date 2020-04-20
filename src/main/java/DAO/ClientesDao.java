package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Usuario;
import utilitarios.ConnectionFactory;

/** puxando conexão com do Banco*/
public class ClientesDao {
    private Connection conn;

    public ClientesDao() throws ClassNotFoundException, SQLException{
        this.conn = ConnectionFactory.getConnection();
    };

/** responsavel por finalizar a conexões antigas para não perder performance*/
    @Override
    protected void finalize() throws SQLException {
        System.out.println("Executando antes de destruir o objeto");
        this.conn.close();
    };

/**cria o SQL do insert q sera enviado para o Banco */
    public void Insert(Usuario user) throws SQLException {
        String sql = "INSERT INTO usuario(nome, email, telefone, senha) VALUES(?,?,?,?)";

        /**pegando os gets de pessoa q deverão der preenchidos */
        PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getTelefone());
            stmt.setString(4, user.getSenha());
            System.out.println("CHEGOU NO INSERT");
            stmt.executeUpdate();

            stmt.close();
    };

/**cria o SQL do select que sera enviado para o Banco */

    public boolean ValidaExiste(Usuario user){
        boolean existe = false;
        try{
            String sql = "select * from pessoa where email ='" + user.getEmail()+"' AND senha='"+ user.getSenha()+"'";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (isFilled(rs)){
                System.out.println("ENTROU AQUI NO IF");
                existe = true;
            }
        } catch(SQLException e){
        e.printStackTrace();
        }
        return existe;

    }

    public static boolean isFilled(ResultSet rs){
        boolean isEmpty = true;
        try {
            while(rs.next()){
                isEmpty = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !isEmpty;
    }   
    
}
