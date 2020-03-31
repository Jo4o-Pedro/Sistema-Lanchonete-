package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.pessoa;
import utilitarios.ConnectionFactory;

/** puxando conexão com do Banco*/
public class clientesDao {
    private Connection conn;
    
    public clientesDao() throws ClassNotFoundException, SQLException{
        this.conn = ConnectionFactory.getConnection();
    }

/** responsavel por finalizar a conexões antigas para não perder performance*/
    @Override
    protected void finalize() throws SQLException {
        System.out.println("Executando antes de destruir o objeto");
        this.conn.close();
    }
    
/**cria o SQL do insert q sera enviado para o Banco */
    public void insert(pessoa p) throws SQLException {
        String sql = "INSERT INTO pessoa(nome, email, telefone, senha) VALUES(?,?,?,?)";
        
        /**pegando os gets de pessoa q deverão der preenchidos */
        PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, p.GetNome());
            stmt.setString(2, p.GetEmail());
            stmt.setInt(3, p.GetTelefone());
            stmt.setString(4, p.GetSenha());
            
            stmt.executeUpdate();
            
            stmt.close();
    }
}
