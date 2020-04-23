package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilitarios.ConnectionFactory;

public class ValidacaoDao{
    
    private Connection conn;
    
    public ValidacaoDao() throws ClassNotFoundException, SQLException{
        this.conn = ConnectionFactory.getConnection();
    };
    
    /** responsavel por finalizar a conexões antigas para não perder performance*/
    @Override
    protected void finalize() throws SQLException {
        System.out.println("Executando antes de destruir o objeto");
        this.conn.close();
    };
    
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
    };   
    
    public boolean ValidaExiste(String tabela, String filtro){
        boolean existe = false;
        try{
            String sql = "select * from " + tabela + " where " + filtro;
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
}
