package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            stmt.setString(1, user.GetNome());
            stmt.setString(2, user.GetEmail());
            stmt.setString(3, user.GetTelefone());
            stmt.setString(4, user.GetSenha());
            System.out.println("CHEGOU NO INSERT");
            stmt.executeUpdate();

            stmt.close();
    };

/**cria o SQL do select que sera enviado para o Banco */
    public void Select(String user, String senha) throws SQLException{
        String sql = "Select (Nome, Senha) FROM usuario WHERE EMAIL =" + user +  "AND senha =" + senha;
        PreparedStatement stmt = this.conn.prepareStatement(sql);

        System.out.println("CHEGOU NO SELECT!");
        stmt.executeQuery(sql);
    };

    public boolean ValidaExiste(String email) throws SQLException{
        boolean existe = false;
        try{
            String sql = "select 1 from usuario where nome =" + email;
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if (isFilled(rs)){
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
