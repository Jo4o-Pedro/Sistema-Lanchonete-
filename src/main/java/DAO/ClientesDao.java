package DAO;

import DAO.ValidacaoDao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Usuario> findUser(String email, String senha) throws SQLException{
        ArrayList<Usuario> lista = new ArrayList<>();
       
        String sql = "Select * from usuario where email = '"+ email +"' and senha = '"+ senha +"'";
       
        PreparedStatement stmt = this.conn.prepareCall(sql);
       
        // O resultSet (retorno da função stmt abaixo) é uma tupla-array com todos os registros pegos
        //no banco, sendo que cada registro é salvo em um indice do array e o primeiro indice é o 
        //cabecalho (colunas) da tabela, por isso se usa .next para pular de indice
        ResultSet rs = stmt.executeQuery();
        rs.next();
        System.out.println(rs.getString(2));
        Long id = rs.getLong(1);
        String nome = rs.getString(2);
        String telefone = rs.getString(3);  

        Usuario user = new Usuario();
        user.setId(id);
        user.setNome(nome);
        user.setTelefone(telefone);
        user.setEmail(email);
        user.setSenha(senha);

        lista.add(user);
        
    stmt.close();   
    return lista;
    }
    
}
