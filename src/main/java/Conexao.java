import java.sql.*;

public class Conexao {
    /** Recebendo o endereco,usuario e senha do usuario e repassando para a variavel global */
    String endereco = "jdbc:postgresql://localhost:5432/SistemaAps"; 
    String usuario = "postgres";
    String senha = "714480jp";
    Connection con = null;
    Statement stmt = null;

    public void Conectar() {


           try {
                   /** Pasando o nome do Driver do PostgreSQL */
               Class.forName("org.postgresql.Driver");

               /** Obtendo a conexao com o banco de dados*/
               con = DriverManager.getConnection(endereco, usuario, senha);

               /** Criando o Statement */
               stmt = con.createStatement();

           /** Retorna um erro caso nao encontre o driver, ou alguma informacao sobre o mesmo
            * esteja errada */
           } catch (ClassNotFoundException cnfe) {
               System.out.println("Erro ao conectar o driver");
               cnfe.printStackTrace();

            /** Retorna um erro caso exista erro de query SQL */   
           } catch (SQLException sqlex) {
               System.out.println("erro na query");
               sqlex.printStackTrace();

           }
       }

       /** Esse metodo quando invocado, realiza a desconexao com o banco */
    public void Desconectar() {
       
        try {
            con.close();

        /** Retorna um erro caso nao consiga desconectar */    
        } catch (SQLException onConClose) {
            System.out.println("Erro ao desconectar o banco");
            onConClose.printStackTrace();
        }
    }
}