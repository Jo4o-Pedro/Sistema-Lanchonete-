package lanchonete.com.br.sistemaaps.controllers;

import DAO.CarrinhoDao;
import DAO.ClientesDao;
import DAO.ProdutoDao;
import DAO.ValidacaoDao;
import models.Usuario;
import models.Filtro;
import models.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Carrinho;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public Usuario setFiltro() {
        return new Usuario();
    }
    
    @ModelAttribute("usuario")
    public Usuario setCadastroUser() {
        return new Usuario();
    }    

    @ModelAttribute("produto")
        public Produto setCadastroProd() {
            return new Produto();
        }    
        
    @ModelAttribute("loginUsuario")
    public Usuario setLogin() {
        return new Usuario();
    }
    
    //Aqui estão os controllers para pesquisa de prodtuo
    //
    @RequestMapping(value = "/burger", method = RequestMethod.POST)
    public String Burger(@ModelAttribute("loginUsuario")Usuario usuario, Model model, @RequestParam String action) 
    throws ClassNotFoundException, SQLException {
      String retorno = null;
      if( action.equals("Burger ") ){
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("burger");
        model.addAttribute("lista", lista);
        retorno = "/index";
      }
      else if( action.equals("Burger") ){
        //trecho usado para pegar o ID do usuario e usar para popular carrinho
        ClientesDao userDao = new ClientesDao();
        ArrayList<Usuario> user = userDao.findUser(usuario.getEmail(), usuario.getSenha());
        Long id = user.get(0).getId();
        
        //aqui popula o carrinho
        CarrinhoDao carrinho = new CarrinhoDao();
        ArrayList<Carrinho> listaCarrinho = carrinho.findCarrinho(id);
        model.addAttribute("carrinho", listaCarrinho);
        
        //aqui popula a pagina com os produtos(NO caso com categoria BURGER)
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("burger");
        model.addAttribute("lista", lista);

        model.addAttribute("user", user);

        retorno = "home";
      }
        return retorno;
    }

    @RequestMapping(value = "/frango", method = RequestMethod.POST)
    public String Frango(@ModelAttribute("loginUsuario")Usuario usuario, Model model, @RequestParam String action) 
    throws ClassNotFoundException, SQLException {
      String retorno = null;
      if( action.equals("Frango ") ){
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("frango");
        model.addAttribute("lista", lista);
        retorno = "/index";
      }
      else if( action.equals("Frango") ){
        //trecho usado para pegar o ID do usuario e usar para popular carrinho
        ClientesDao userDao = new ClientesDao();
        ArrayList<Usuario> user = userDao.findUser(usuario.getEmail(), usuario.getSenha());
        Long id = user.get(0).getId();
        
        //aqui popula o carrinho
        CarrinhoDao carrinho = new CarrinhoDao();
        ArrayList<Carrinho> listaCarrinho = carrinho.findCarrinho(id);
        model.addAttribute("carrinho", listaCarrinho);
        
        //aqui popula a pagina com os produtos(NO caso com categoria BURGER)
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("frango");
        model.addAttribute("lista", lista);

        model.addAttribute("user", user);

        retorno = "home";
      }
        return retorno;
    }

    @RequestMapping(value = "/porcao", method = RequestMethod.POST)
    public String Porcao(@ModelAttribute("loginUsuario")Usuario usuario, Model model, @RequestParam String action) 
    throws ClassNotFoundException, SQLException {
      String retorno = null;
      if( action.equals("Porcoes ") ){
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("porcao");
        model.addAttribute("lista", lista);
        retorno = "/index";
      }
      else if( action.equals("Porcoes") ){
        //trecho usado para pegar o ID do usuario e usar para popular carrinho
        ClientesDao userDao = new ClientesDao();
        ArrayList<Usuario> user = userDao.findUser(usuario.getEmail(), usuario.getSenha());
        Long id = user.get(0).getId();
        
        //aqui popula o carrinho
        CarrinhoDao carrinho = new CarrinhoDao();
        ArrayList<Carrinho> listaCarrinho = carrinho.findCarrinho(id);
        model.addAttribute("carrinho", listaCarrinho);
        
        //aqui popula a pagina com os produtos(NO caso com categoria BURGER)
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("porcao");
        model.addAttribute("lista", lista);

        model.addAttribute("user", user);

        retorno = "home";
      }
        return retorno;
    }

    @RequestMapping(value = "/bebida", method = RequestMethod.POST)
    public String Bebida(@ModelAttribute("loginUsuario")Usuario usuario, Model model, @RequestParam String action) 
    throws ClassNotFoundException, SQLException {
      String retorno = null;
      if( action.equals("Bebidas ") ){
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("bebida");
        model.addAttribute("lista", lista);
        retorno = "/index";
      }
      else if( action.equals("Bebidas") ){
        //trecho usado para pegar o ID do usuario e usar para popular carrinho
        ClientesDao userDao = new ClientesDao();
        ArrayList<Usuario> user = userDao.findUser(usuario.getEmail(), usuario.getSenha());
        Long id = user.get(0).getId();
        
        //aqui popula o carrinho
        CarrinhoDao carrinho = new CarrinhoDao();
        ArrayList<Carrinho> listaCarrinho = carrinho.findCarrinho(id);
        model.addAttribute("carrinho", listaCarrinho);
        
        //aqui popula a pagina com os produtos(NO caso com categoria BURGER)
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoCategoria("bebida");
        model.addAttribute("lista", lista);

        model.addAttribute("user", user);

        retorno = "home";
      }
        return retorno;
    }
    
    @RequestMapping(value = "/filtro", method = RequestMethod.POST)
    public String FiltrarProd(@ModelAttribute("loginUsuario")Usuario usuario, Model model, @RequestParam String action )
        throws ClassNotFoundException, SQLException{        
      String retorno = null;
      System.out.println(action);
      if( action.equals("pesquisa ") ){
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoFiltro(usuario);
        model.addAttribute("lista", lista);
        retorno = "/index";
      }
      else if( action.equals("pesquisa") ){
        //trecho usado para pegar o ID do usuario e usar para popular carrinho
        ClientesDao userDao = new ClientesDao();
        ArrayList<Usuario> user = userDao.findUser(usuario.getEmail(), usuario.getSenha());
        Long id = user.get(0).getId();
        
        //aqui popula o carrinho
        CarrinhoDao carrinho = new CarrinhoDao();
        ArrayList<Carrinho> listaCarrinho = carrinho.findCarrinho(id);
        model.addAttribute("carrinho", listaCarrinho);
        
        //aqui popula a pagina com os produtos(NO caso com categoria BURGER)
        ProdutoDao dao = new ProdutoDao();
        ArrayList<Produto> lista = dao.findProdutoFiltro(usuario);
        model.addAttribute("lista", lista);

        model.addAttribute("user", user);

        retorno = "home";
      }
        return retorno;
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

    @RequestMapping(value = "LoginUsuario")
    public String ValidarUser(@ModelAttribute("loginUsuario")Usuario usuario, Model model){
        try {
            ValidacaoDao validacao = new ValidacaoDao();
            String filtroUsuario = "email = '" + usuario.getEmail()+"' AND senha = '"+ usuario.getSenha() +"'";
            if(validacao.ValidaExiste("usuario", filtroUsuario)){
                System.out.println(">>>Sucesso NO IF login!!!<<<");

                ClientesDao userDao = new ClientesDao();
                ArrayList<Usuario> user = userDao.findUser(usuario.getEmail(), usuario.getSenha());
                model.addAttribute("user", user);
                Long id = user.get(0).getId();

                ProdutoDao prodDao = new ProdutoDao();
                ArrayList<Produto> lista = prodDao.findAllProduto();
                model.addAttribute("lista", lista);
                
                CarrinhoDao carrinho = new CarrinhoDao();
                ArrayList<Carrinho> listaCarrinho = carrinho.findCarrinho(id);
                model.addAttribute("carrinho", listaCarrinho);

                return "home";
            } else {
                System.out.println(">>>Fracasso NO IF login!!!<<<");
                return "redirect:index";
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //
    //Controllers do CRUD de produto
    @RequestMapping(value = "CrudProd", method = RequestMethod.POST, params = "adiciona")
    public String NovoProd(@ModelAttribute("produto")Produto produto, Model model ){
    try {
            System.out.println("VEIIOOOOOO cadastra");
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Insert(produto);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro aqui" + ex);
        }
    return "redirect:cadprod";   
    }
    
    @RequestMapping(value = "CrudProd", method = RequestMethod.POST, params = "pesquisa")
    public String SelectProd(@ModelAttribute("produto")Produto produto, Model model ){
        System.out.println("VEIIOOOOOO no select ");
        try {
            ProdutoDao daoProd = new ProdutoDao();
//            ArrayList<Produto> produtoBusca = daoProd.findProduto(produto);
            Produto produtoBusca = new Produto();
            produtoBusca = daoProd.findProduto(produto);
            System.out.println(produto.getNome());
            model.addAttribute("produto", produtoBusca);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return "/CadastroProduto";   
    }

    @RequestMapping(value = "CrudProd", method = RequestMethod.POST, params = "deleta")
    public String DeletaProd(@ModelAttribute("produto")Produto produto, Model model ){
    System.out.println("VEIIOOOOOO no delete ");
    try {
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Delete(produto);
            System.out.println(produto.getId());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:cadprod";
    }

    @RequestMapping(value = "CrudProd", method = RequestMethod.POST, params = "atualiza")
    public String AtualizaProd(@ModelAttribute("produto")Produto produto, Model model ){
    System.out.println("VEIIOOOOOO no atualiza ");
    try {
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Update(produto);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:cadprod";
    }
    //
    //
}
