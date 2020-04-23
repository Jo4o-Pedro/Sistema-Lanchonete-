package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Filtro;
import models.Produto;
import DAO.ValidacaoDao;
import utilitarios.ConnectionFactory;

public class ProdutoDao {
    private Connection conn;
    
    public ProdutoDao() throws ClassNotFoundException, SQLException{
        this.conn = ConnectionFactory.getConnection();
    };
    
    /** responsavel por finalizar a conexões antigas para não perder performance*/
    @Override
    protected void finalize() throws SQLException {
        System.out.println("Executando antes de destruir o objeto");
        this.conn.close();
    };
    
    /**cria o SQL do insert q sera enviado para o Banco */
    public void Insert(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto(nome, descricao, categoria, preco, informacao) VALUES(?,?,?,?,?)";

        /**pegando os gets de pessoa q deverão der preenchidos */
        PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setString(3, produto.getCategoria());
            stmt.setFloat(4, produto.getPreco());
            stmt.setString(5, produto.getInformacao());
            System.out.println("CHEGOU NO INSERT");
            stmt.executeUpdate();

            stmt.close();
    };
    
    public void Delete(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "Delete from produto where id_produto = ?";
        String filtroWhere = " id_produto =" +  produto.getId();
        
        ValidacaoDao validacao = new ValidacaoDao();
        if(validacao.ValidaExiste("produto", filtroWhere)){
            try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
                stmt.setLong(1, produto.getId());
                System.out.println("CHEGOU NO delete");
                stmt.executeUpdate();
            }
        }
        else{
            System.out.println("NAO ExISTE PRODUTO COM O CODIGO" + produto.getId());
        }
    };
    
    public void Update(Produto produto) throws SQLException, ClassNotFoundException {
        String sql = "Update produto set nome = ?, descricao = ?, categoria = ?, preco = ?, informacao = ? where id_produto = ?";
        String filtroWhere = "id_produto =" +  produto.getId();
        ValidacaoDao validacao = new ValidacaoDao();
        if(validacao.ValidaExiste("produto", filtroWhere)){
            try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getDescricao());
                stmt.setString(3, produto.getCategoria());
                stmt.setFloat(4, produto.getPreco());
                stmt.setString(5, produto.getInformacao());
                stmt.setLong(6, produto.getId());
                System.out.println("CHEGOU NO delete");
                stmt.executeUpdate();
            }
        }
        else{
            System.out.println("ERRO NO PRODUTODAO.UPDATE -> NAO EXISTE O PRODUTO");
        }
    };
    
    public ArrayList<Produto> findAllProduto() throws SQLException{
       ArrayList<Produto> lista = new ArrayList<>();
       
       String sql = "Select * from produto";
       
       PreparedStatement stmt = this.conn.prepareCall(sql);
       
       // O resultSet (retorno da função stmt abaixo) é uma tupla-array com todos os registros pegos
       //no banco, sendo que cada registro é salvo em um indice do array e o primeiro indice é o 
       //cabecalho (colunas) da tabela, por isso se usa .next para pular de indice
       ResultSet rs = stmt.executeQuery();
       
       while(rs.next()){
           Long id = rs.getLong(1);
           String nome = rs.getString(2);
           String descricao = rs.getString(3);
           String categoria = rs.getString(4);  
           float preco = rs.getFloat(5);
           String informacao = rs.getString(6);
           
           Produto prod = new Produto();
           prod.setCategoria(categoria);
           prod.setDescricao(descricao);
           prod.setId(id);
           prod.setInformacao(informacao);
           prod.setNome(nome);
           prod.setPreco(preco);
           
           lista.add(prod);
       }
       
    return lista;
    }


    public ArrayList<Produto> findProdutoCategoria(String categoria) throws SQLException{
       ArrayList<Produto> lista = new ArrayList<>();
       
       String sql = "Select * from produto where upper(categoria) like upper('%" + categoria + "%')";
       
       PreparedStatement stmt = this.conn.prepareCall(sql);
       
       // O resultSet (retorno da função stmt abaixo) é uma tupla-array com todos os registros pegos
       //no banco, sendo que cada registro é salvo em um indice do array e o primeiro indice é o 
       //cabecalho (colunas) da tabela, por isso se usa .next para pular de indice
       ResultSet rs = stmt.executeQuery();
       
       while(rs.next()){
           Long id = rs.getLong(1);
           String nome = rs.getString(2);
           String descricao = rs.getString(3);
           categoria = rs.getString(4);  
           float preco = rs.getFloat(5);
           String informacao = rs.getString(6);
           
           Produto prod = new Produto();
           prod.setCategoria(categoria);
           prod.setDescricao(descricao);
           prod.setId(id);
           prod.setInformacao(informacao);
           prod.setNome(nome);
           prod.setPreco(preco);
           
           lista.add(prod);
       }
       
    return lista;
    }
    
    public ArrayList<Produto> findProdutoFiltro(Filtro filtroWhere) throws SQLException{
       ArrayList<Produto> lista = new ArrayList<>();
       
       String sql = "Select * from produto where upper(nome) like upper('%" + filtroWhere.getFiltro() + "%')";
       
       PreparedStatement stmt = this.conn.prepareCall(sql);
       
       // O resultSet (retorno da função stmt abaixo) é uma tupla-array com todos os registros pegos
       //no banco, sendo que cada registro é salvo em um indice do array e o primeiro indice é o 
       //cabecalho (colunas) da tabela, por isso se usa .next para pular de indice
       ResultSet rs = stmt.executeQuery();
       
       while(rs.next()){
           Long id = rs.getLong(1);
           String nome = rs.getString(2);
           String descricao = rs.getString(3);
           String categoria = rs.getString(4);  
           float preco = rs.getFloat(5);
           String informacao = rs.getString(6);
           
           Produto prod = new Produto();
           prod.setCategoria(categoria);
           prod.setDescricao(descricao);
           prod.setId(id);
           prod.setInformacao(informacao);
           prod.setNome(nome);
           prod.setPreco(preco);
           
           lista.add(prod);
       }
       
    return lista;
    }
//            ArrayList<Produto>
    public Produto findProduto(Produto prod) throws SQLException, ClassNotFoundException{
    ArrayList<Produto> produtoBuscado = new ArrayList<>();
    String sql = "Select * from produto where id_produto = " + prod.getId();
    String filtroID ="id_produto = " + prod.getId();
    PreparedStatement stmt = this.conn.prepareCall(sql);
    ValidacaoDao validacao = new ValidacaoDao();
    
    ResultSet rs = stmt.executeQuery();
    if(validacao.ValidaExiste("produto", filtroID)){
        rs.next();
        String nome = rs.getString(2);
        String descricao = rs.getString(3);
        String categoria = rs.getString(4);  
        float preco = rs.getFloat(5);
        String informacao = rs.getString(6);

        prod.setCategoria(categoria);
        prod.setDescricao(descricao);
        prod.setInformacao(informacao);
        prod.setNome(nome);
        prod.setPreco(preco);

        produtoBuscado.add(prod);
    }
    else{
        System.out.println("DEU ERRO NO FindProduto");
    }
    return prod;
    }
}

















