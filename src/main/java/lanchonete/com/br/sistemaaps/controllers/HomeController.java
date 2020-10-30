package lanchonete.com.br.sistemaaps.controllers;

import DAO.CarrinhoDao;
import DAO.ClientesDao;
import DAO.ProdutoDao;
import DAO.ValidacaoDao;
import DAO.PedidoDao;
import models.Usuario;
import models.Produto;
import models.Pedido;   
import models.Carrinho;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    @ModelAttribute("carrinho")
    public Carrinho setCar() {
        return new Carrinho();
    }

    @ModelAttribute("pedido")
    public Pedido setPedido() {
        return new Pedido();
    }
    
    //Aqui estão os controllers para pesquisa de prodtuo
    
    //Fim dos controllers que pesquisam produto
    
    @RequestMapping("cadastro")
    public String Cadastro(){
        return "cadastro"; 
    }

    @RequestMapping("cadprod")
    public String CadastroProduto(Model model){
        Pedido pedido = new Pedido();
        pedido.setTotalRS(0);
        ArrayList<Pedido> pedidoLista = new ArrayList<>();
        pedidoLista.add(pedido);
        model.addAttribute("pedido", pedidoLista);
        return "CadastroProduto"; 
    }
    
    @RequestMapping("fimPedido")
    public String finalizarpedidos(@ModelAttribute("loginUsuario")Usuario usuario, Model model, @RequestParam String id_user){
    try{
        System.out.println(id_user);
        long id_userLong = Long.parseLong(id_user);
        CarrinhoDao car = new CarrinhoDao();
        ArrayList<Carrinho> prods = car.findCarrinho(id_userLong);
        ArrayList<Carrinho> total = car.calculaTotal(id_userLong);
        car.desativaPedido(id_user);
        model.addAttribute("prods", prods);
        model.addAttribute("total", total);

        return "fimPedido";
    }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "fimPedido";
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
                
                CarrinhoDao carrinho = new CarrinhoDao();
                ArrayList<Carrinho> listaCarrinho = carrinho.findCarrinho(id);
                model.addAttribute("carrinho", listaCarrinho);

                //aqui popula a pagina com os ingredientes de acordo com suas categorias
        
                ProdutoDao ProdCarne = new ProdutoDao();
                ArrayList<Produto> carne = ProdCarne.findProdutoCategoria("carne");
                model.addAttribute("carnes", carne);

                ProdutoDao ProdPao = new ProdutoDao();
                ArrayList<Produto> pao = ProdPao.findProdutoCategoria("pao");
                model.addAttribute("paes", pao);

                ProdutoDao ProdSalada = new ProdutoDao();
                ArrayList<Produto> salada = ProdSalada.findProdutoCategoria("salada");
                model.addAttribute("saladas", salada);

                ProdutoDao ProdMolho = new ProdutoDao();
                ArrayList<Produto> molho = ProdMolho.findProdutoCategoria("molho");
                model.addAttribute("molhos", molho);
                
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
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Insert(produto);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro aqui" + ex);
        }
    return "redirect:cadprod";   
    }
    
    @RequestMapping(value = "CrudProd", method = RequestMethod.POST, params = "pesquisa")
    public String SelectProd(@ModelAttribute("produto")Produto produto, Model model ){
        try {
            ProdutoDao daoProd = new ProdutoDao();
            Produto produtoBusca = new Produto();
            produtoBusca = daoProd.findProduto(produto);
            model.addAttribute("produto", produtoBusca);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return "/CadastroProduto";   
    }

    @RequestMapping(value = "CrudProd", method = RequestMethod.POST, params = "deleta")
    public String DeletaProd(@ModelAttribute("produto")Produto produto, Model model ){
    try {
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Delete(produto);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:cadprod";
    }

    @RequestMapping(value = "CrudProd", method = RequestMethod.POST, params = "atualiza")
    public String AtualizaProd(@ModelAttribute("produto")Produto produto, Model model ){
    try {
            ProdutoDao daoProd = new ProdutoDao();
            daoProd.Update(produto);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:cadprod";
    }
    
    @RequestMapping(value = "adiciona", method = RequestMethod.POST)
    public String adicionar(@ModelAttribute("carrinho")Carrinho carrinho, RedirectAttributes redirectAttributes, Model mode, @RequestParam String idUser, @RequestParam String senha, @RequestParam String email,
    @RequestParam String saladas, @RequestParam String carnes, @RequestParam String paes, @RequestParam String molhos) {
    try{
            Carrinho novoLanch = new Carrinho(carnes, saladas, paes, molhos);
            CarrinhoDao daocar = new CarrinhoDao();
            daocar.insertcar(idUser, novoLanch);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long idUsuario = Long.parseLong(idUser);
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        redirectAttributes.addFlashAttribute("loginUsuario", usuario);
        return "redirect:LoginUsuario";
    }

    @RequestMapping(value = "relatorio", method = RequestMethod.POST)
    public String adicionar(@ModelAttribute("carrinho")Carrinho carrinho, RedirectAttributes redirectAttributes, Model model,
    @RequestParam String inicio, @RequestParam String fim ) {
        try{
            PedidoDao pedidoDao = new PedidoDao();

            ArrayList<Pedido> pedido = pedidoDao.totalMes(inicio, fim);
            model.addAttribute("pedido", pedido);

            CarrinhoDao produtos = new CarrinhoDao();

            ArrayList<Carrinho> produtosLista = produtos.maisVendidos();
            model.addAttribute("produtosLista", produtosLista);
            
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return  "/CadastroProduto"   ;
    }
}
