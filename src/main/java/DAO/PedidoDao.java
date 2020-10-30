
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utilitarios.ConnectionFactory;
import java.util.Date;
import models.Pedido;

public class PedidoDao {
    private Connection conn;

    public PedidoDao() throws ClassNotFoundException, SQLException{
        this.conn = ConnectionFactory.getConnection();
    };

    /** responsavel por finalizar a conexões antigas para não perder performance*/
    @Override
    protected void finalize() throws SQLException {
        System.out.println("Executando antes de destruir o objeto");
        this.conn.close();
    };

    public ArrayList<Pedido> totalMes(String inicio, String fim) throws SQLException{
        ArrayList<Pedido> lista = new ArrayList<>();
            String sql= "SELECT SUM(A.VALOR) FROM LANCHE A, PEDIDO B "
                      + "WHERE A.PEDIDO = B.ID "
                      + "AND B.DTA_PEDIDO BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD') ";


            System.out.println(sql);
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, inicio);
            stmt.setString(2, fim);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int total = rs.getInt(1);

                Pedido pedido = new Pedido();
                pedido.setTotalRS(total);

                lista.add(pedido);
            }
        stmt.close();   
        return lista; 
    }

    
}