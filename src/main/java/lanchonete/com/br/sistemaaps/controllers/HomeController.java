package lanchonete.com.br.sistemaaps.controllers;

import DAO.ClientesDao;
import models.Usuario;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    // Metodo para redirecinar a URL
    // Toda vez que acessar a URL passada na @RequestMapping, no caso é o root, vai retornar um /index
    //Esse /index vai ser tratado conforme foi passado os padrões no AppWebConfig
    @RequestMapping("/")
    public String index(){
        return "index"; 
    }

    @RequestMapping("/cadastro")
    public String Cadastro(){
        return "cadastro"; 
    }


    @ModelAttribute("usuario")
    public Usuario setCadastroUser() {
        return new Usuario();
    }
       
    @RequestMapping(value = "/novoUsuario", method = RequestMethod.POST)
    public String NovoUsu(@ModelAttribute("usuario")Usuario usuario, Model model ){        
        System.out.println(usuario.getNome());
        try {
            System.out.println("ENTROU NO TRY DO CONTROLLER");
            ClientesDao daoUser = new ClientesDao();
            daoUser.Insert(usuario);
            System.out.println(usuario.getNome());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "index";   
    }
}
