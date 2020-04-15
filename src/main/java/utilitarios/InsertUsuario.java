
package utilitarios;

import DAO.ClientesDao;
import java.sql.SQLException;
import models.Usuario;

public class InsertUsuario {
    /**preenchendo os campos com os dados que devem ser inseridos  */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Usuario p = new Usuario();
        p.setNome("testefinal3");
        p.setEmail("testfinal3@gmail.com");
        p.setTelefone("9993");
        p.setSenha("final3");
        
        /**apos prencher o campo importamos insert do clientesDao e o execultamos*/
        ClientesDao dao = new ClientesDao();
        dao.Insert(p);
    }
    
}
