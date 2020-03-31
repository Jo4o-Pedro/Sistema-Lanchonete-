
package utilitarios;

import DAO.ClientesDao;
import java.sql.SQLException;
import models.Usuario;

public class InsertUsuario {
    /**preenchendo os campos com os dados que devem ser inseridos  */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Usuario p = new Usuario();
        p.SetNome("testefinal3");
        p.SetEmail("testfinal3@gmail.com");
        p.SetTelefone("9993");
        p.SetSenha("final3");
        
        /**apos prencher o campo importamos insert do clientesDao e o execultamos*/
        ClientesDao dao = new ClientesDao();
        dao.Insert(p);
    }
    
}
