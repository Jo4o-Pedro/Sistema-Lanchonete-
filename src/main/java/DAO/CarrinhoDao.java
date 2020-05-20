
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Carrinho;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import models.Produto;
import models.Usuario;
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
       
        String sql= "select max(a.id), max(a.id_pedido), max(a.id_produto), sum(a.qntd), max(b.nome)\n" +
                    "from carrinho a, produto b                            \n" +
                    "where a.id_produto = b.id_produto                     \n" +
                    "and a.id_pedido = (select id from pedido              \n" +
                    "			where id_usuario = '"+ id +"'      \n" +
                    "			and status = 'A')                  \n" +
                    "group by a.id_produto";
        
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
    
    
    public void insertcar(int quantidade,long id_produto,String usuario) throws SQLException{
        int id_usuario = Integer.parseInt(usuario);
        String sqls="Select a.id_pedido                       \n" +
                    "from carrinho a, produto b                                    \n" +
                    "where a.id_produto = b.id_produto                             \n" +
                    "and a.id_pedido = (select id from pedido                      \n" +
                    "			where id_usuario = "+id_usuario+"      \n" +
                    "			and status = 'A')";
        
        PreparedStatement stmts = this.conn.prepareStatement(sqls, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        
        ResultSet rs1 = stmts.executeQuery();      
        Long id_pedido = null;
        if(ValidacaoDao.isFilled(rs1)){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!AQUI!!!!!!!!!!!!!!!!!");
            rs1.previous();
            id_pedido = rs1.getLong(1);
        }
        else{
            rs1.next();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!AQUI2222!!!!!!!!!!!!!!!!!!!");
            String sql = ("INSERT INTO pedido (id_usuario, dta_pedido, status) VALUES (?,current_date,'A')"); 
            PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id_usuario);
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id_pedido = rs.getLong(1);
            
            stmt.close();
            
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!AQUI33333333!!!!!!!!!!!!!!!!!!!");
        String sqlc = ("INSERT INTO carrinho (id_pedido, id_produto, qntd) VALUES (?, ?, ?)");
        PreparedStatement stmc = this.conn.prepareStatement(sqlc);
        stmc.setLong(1, id_pedido);
        stmc.setLong(2, id_produto);
        stmc.setInt(3, quantidade);
        
        stmc.executeUpdate();
        
        stmc.close();
    }

    public ArrayList<Produto> findProdutoCarrinho(String idUsuario) throws SQLException{
        ArrayList<Produto> lista = new ArrayList<>();
        String sql= "select distinct(x.nome), preco         \n" +
                    "from produto x, carrinho y, pedido z   \n" +
                    "where x.id_produto = y.id_produto      \n" +
                    "and   y.id_pedido = z.id               \n" +
                    "and   y.status = 'A'                   \n" +
                    "and   z.id_usuario = " + idUsuario;
     
        PreparedStatement stmt = this.conn.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
           String nome = rs.getString(1);
           float preco = rs.getFloat(2);
           
           Produto produtos = new Produto();
           produtos.setNome(nome);
           produtos.setPreco(preco);
           System.out.println("CARRINHO !!!");
           lista.add(produtos);
       }
    stmt.close();   
    return lista;
    }
    
    public void desativaPedido(String idUsuario) throws SQLException{
        String sql = "Update pedido set status = 'I' where id_usuario = "+ idUsuario;
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
    }
}
