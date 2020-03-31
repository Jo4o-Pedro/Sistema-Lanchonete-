/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import DAO.clientesDao;
import java.sql.SQLException;
import models.pessoa;

/**
 *
 * @author vinicius
 */
public class InsertUsuario {
    /**preenchendo os campos com os dados que devem ser inseridos  */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        pessoa p = new pessoa();
        p.SetNome("testefinal3");
        p.SetEmail("testfinal3@gmail.com");
        p.SetTelefone(9993);
        p.SetSenha("final3");
        
        /**apos prencher o campo importamos insert do clientesDao e o execultamos*/
        clientesDao dao = new clientesDao();
        dao.insert(p);
    }
    
}
