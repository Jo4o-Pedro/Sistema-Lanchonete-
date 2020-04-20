package lanchonete.com.br.sistemaaps.controllers;

import DAO.ClientesDao;
import DAO.ProdutoDao;
import models.Usuario;
import models.Filtro;
import models.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    // Metodo para redirecinar a URL
    // Toda vez que acessar a URL passada na @RequestMapping, no caso é o root, vai retornar um /index
    //Esse /index vai ser tratado conforme foi passado os padrões no AppWebConfig
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) 
    throws ClassNotFoundException, SQLException {
      ProdutoDao dao = new ProdutoDao();
      ArrayList<Produto> lista = dao.findAllProduto();
      model.addAttribute("lista", lista);
      return "index";
    }
    
    @ModelAttribute("pesquisa")
    public Filtro setFiltro() {
        return new Filtro();
    }
    
    @ModelAttribute("usuario")
    public Usuario setCadastroUser() {
        return new Usuario();
    }    

    @ModelAttribute("produto")
        public Produto setCadastroProd() {
            return new Produto();
        }    

    //Aqui estão os controllers para pesquisa de prodtuo
    //
    @RequestMapping(value = "/burger", method = RequestMethod.POST)
    public String Burger(Model model) 
    throws ClassNotFoundException, SQLException {
      ProdutoDao dao = new ProdutoDao();
      ArrayList<Produto> lista = dao.findProdutoCategoria("burger");
      model.addAttribute("lista", lista);
      return "index";
    }

    @RequestMapping(value = "/frango", method = RequestMethod.POST)
    public String Frango(Model model) 
    throws ClassNotFoundException, SQLException {
      ProdutoDao dao = new ProdutoDao();
      ArrayList<Produto> lista = dao.findProdutoCategoria("frango");
      model.addAttribute("lista", lista);
      return "index";
    }

    @RequestMapping(value = "/porcao", method = RequestMethod.POST)
    public String Porcao(Model model) 
    throws ClassNotFoundException, SQLException {
      ProdutoDao dao = new ProdutoDao();
      ArrayList<Produto> lista = dao.findProdutoCategoria("porcao");
      model.addAttribute("lista", lista);
      return "index";
    }

    @RequestMapping(value = "/bebida", method = RequestMethod.POST)
    public String Bebida(Model model) 
    throws ClassNotFoundException, SQLException {
      ProdutoDao dao = new ProdutoDao();
      ArrayList<Produto> lista = dao.findProdutoCategoria("bebida");
      model.addAttribute("lista", lista);
      return "index";
    }
    
    @RequestMapping(value = "/filtro", method = RequestMethod.POST)
    public String FiltrarProd(@ModelAttribute("pesquisa")Filtro filtro, Model model ){        
       
        try {
            ProdutoDao dao = new ProdutoDao();
            ArrayList<Produto> lista = dao.findProdutoFiltro(filtro);;
            model.addAttribute("lista", lista);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "index";   
    }
    //
    //Fim dos controllers que pesquisam produto
    
    @RequestMapping("cadastro")
    public String Cadastro(){
        return "cadastro"; 
    }

    @RequestMapping("cadprod")
    public String CadastroProduto(){
        return "CadastroProduto"; 
    }
    
    @ModelAttribute("pesquisa")
    public Filtro setFiltro() {
        return new Filtro();
    }
     @ModelAttribute("loginUsuario")
    public Usuario setLogin() {
        return new Usuario();
    }
       
    @RequestMapping(value = "/novoUsuario", method = RequestMethod.POST)
    public String NovoUsu(@ModelAttribute("usuario")Usuario usuario, Model model ){
        try {
            ClientesDao daoUser = new ClientesDao();
            daoUser.Insert(usuario);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "redirect:/index";   
    }
    
    @RequestMapping(value = "cadastraProd", method = RequestMethod.POST)
    public String NovoProd(@ModelAttribute("produto")Produto produto, Model model ){
    try {
            System.out.println("VEIIOOOOOO");
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Insert(produto);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro aqui" + ex);;
        }
    return "/cadastroSucesso";   
    }
    
    @RequestMapping(value = "deletaProd", method = RequestMethod.POST)
    public String DeletaProd(@ModelAttribute("produto")Produto produto, Model model ){
    try {
            System.out.println("VEIIOOOOOO");
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Insert(produto);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro aqui" + ex);;
        }
    return "/cadastroSucesso";   
    }
    @RequestMapping(value = "LoginUsuario", method = RequestMethod.POST)
    public String ValidarUser(@ModelAttribute("loginUsuario")Usuario usuario, Model model){
        try {
            ClientesDao daoUser = new ClientesDao();
            if(daoUser.ValidaExiste(usuario)){
                System.out.println(">>>Sucesso NO IF!!!<<<");
                return "/index";
            } else {
                System.out.println(">>>Fracasso NO IF!!!<<<");
                return null;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

}