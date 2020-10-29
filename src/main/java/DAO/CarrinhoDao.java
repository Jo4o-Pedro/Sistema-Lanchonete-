
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
import models.Lanche;
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

    public ArrayList<Carrinho> findCarrinho(Long id) throws SQLException{
        ArrayList<Carrinho> lista = new ArrayList<>();
        String sql= "SELECT B.ID, A.PAO, A.CARNE, A.SALADA, A.MOLHO, A.VALOR, A.ID FROM LANCHE A, PEDIDO B "
                  + "WHERE A.PEDIDO = B.ID "
                  + "AND USUARIO =" + id + " AND B.STATUS = 'A'";
        
        PreparedStatement stmt = this.conn.prepareCall(sql);
       
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
           Long id_pedido = rs.getLong(1);
           String pao = rs.getString(2);
           String carne = rs.getString(3);
           String salada = rs.getString(4);
           String molho = rs.getString(5);
           int valor = rs.getInt(6);
           Long id_lanche = rs.getLong(7);
           
           Carrinho produtos = new Carrinho();
           produtos.setId_pedido(id_pedido);
           produtos.setPao(pao);
           produtos.setCarne(carne);
           produtos.setSalada(salada);
           produtos.setMolho(molho);
           produtos.setValor(valor);
           produtos.setId_lanche(id_lanche);
           
           lista.add(produtos);
       }
    stmt.close();   
    return lista;
    }
    
    
    public void insertcar(String usuario, Carrinho objLanche) throws SQLException{
        int id_usuario = Integer.parseInt(usuario);
        String sqls="Select a.pedido                       \n" +
                    "from lanche a, pedido b                          \n" +
                    "where a.pedido = b.id "
                  + "and a.usuario = "+id_usuario+ 
                    " and b.status = 'A'";
        
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
        String sqlc = ("INSERT INTO lanche (status, pedido, usuario, pao, carne, molho, salada, valor ) Select 'A', ?, ?, ?, ? ,?, ?, "
                    + "(select sum(preco) from ingrediente where nome_ingrediente in(?,?,?,?))");

        PreparedStatement stmc = this.conn.prepareStatement(sqlc);
        stmc.setLong(1, id_pedido);
        stmc.setInt(2, id_usuario);
        stmc.setString(3, objLanche.getPao());
        stmc.setString(4, objLanche.getCarne());
        stmc.setString(5, objLanche.getMolho());
        stmc.setString(6, objLanche.getSalada());
        stmc.setString(7, objLanche.getPao());
        stmc.setString(8, objLanche.getCarne());
        stmc.setString(9, objLanche.getMolho());
        stmc.setString(10, objLanche.getSalada());
        
        stmc.executeUpdate();
        
        stmc.close();
    }

    public ArrayList<Produto> findProdutoCarrinho(String idUsuario) throws SQLException{
        ArrayList<Produto> lista = new ArrayList<>();
        String sql= "select distinct(x.nome), preco         \n" +
                    "from produto x, carrinho y, pedido z   \n" +
                    "where x.id_produto = y.id_produto      \n" +
                    "and   y.id_pedido = z.id               \n" +
                    "and   z.status = 'A'                   \n" +
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

    public ArrayList<Carrinho> calculaTotal(Long id) throws SQLException{
        ArrayList<Carrinho> lista = new ArrayList<>();
        String sql= "select sum(a.valor)       \n" +
                    "from lanche a   \n" +
                    "where a.usuario = " + id + "and a.status = 'A'";
     
        PreparedStatement stmt = this.conn.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
           int total = rs.getInt(1);
           
           Carrinho car = new Carrinho();
           car.setTotal(total);
           lista.add(car);
       }
    stmt.close();   
    return lista;
    }
    
    public void desativaPedido(String idUsuario) throws SQLException{
        String sql = "Update pedido set status = 'I' where id_usuario = "+ idUsuario;
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        String sql2 = "Update lanche set status = 'I' where usuario = "+ idUsuario;
        PreparedStatement stmt2 = this.conn.prepareStatement(sql2);
        stmt2.executeUpdate();
        stmt2.close();
    }
}
