
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Carrinho;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilitarios.ConnectionFactory;

public class CarrinhoDao {
    private Connection conn;

    public CarrinhoDao() throws ClassNotFoundException, SQLException{
        this.conn = ConnectionFactory.getConnection();
    };

    /** responsavel por finalizar a conexões antigas para não perder performance*/
    @Override
    protected void finalize() throws SQLException {
        System.out.println("Executando antes de destruir o objeto");
        this.conn.close();
    };
    ////////////////////////
    
    public ArrayList<Carrinho> findCarrinho(Long id) throws SQLException{
        ArrayList<Carrinho> lista = new ArrayList<>();
       
        String sql= "select a.id, a.id_pedido, a.id_produto, a.qntd, b.nome\n" +
                    "from carrinho a, produto b                            \n" +
                    "where a.id_produto = b.id_produto                     \n" +
                    "and a.id_pedido = (select id from pedido              \n" +
                    "			where id_usuario = '"+ id +"'      \n" +
                    "			and status = 'A')";
        
        PreparedStatement stmt = this.conn.prepareCall(sql);
       
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
           Long id_carrinho = rs.getLong(1);
           Long id_pedido = rs.getLong(2);
           Long id_produto = rs.getLong(3);
           int qntd = rs.getInt(4);
           String nome_prod = rs.getString(5);
           
           Carrinho produtos = new Carrinho();
           produtos.setId(id_carrinho);
           produtos.setId_pedido(id_pedido);
           produtos.setId_produto(id_produto);
           produtos.setQuantidade(qntd);
           produtos.setNome_prod(nome_prod);
           
           lista.add(produtos);
       }
    stmt.close();   
    return lista;
    }

}
