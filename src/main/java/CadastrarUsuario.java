import models.Usuario;
import DAO.ClientesDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.script.*;

@WebServlet("/cadastro/novoUsuario")
public class CadastrarUsuario extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        try{
            String nombre = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String telefone = request.getParameter("telefone");
            System.out.println("Executando servlet");

            ClientesDao dao = new ClientesDao();
            Usuario user = new Usuario();
            
            user.setNome(nombre);
            user.setEmail(email);
            user.setTelefone(telefone);
            user.setSenha(senha);

            if(dao.ValidaExiste(email) == false){
                System.out.println("JA EXISTE");
                ScriptEngineManager factory = new ScriptEngineManager();
                ScriptEngine engine = factory.getEngineByName("JavaScript");
                engine.eval("document.getElementById('avisoEmail.style.display = \"block\";");
                
            } else{
             dao.Insert(user);
            
            }
            
           
            //request.setAttribute("usuario", user);
            //RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
            //disp.forward(request, response);
        } catch (ClassNotFoundException ex) {
           System.out.println("DEU ERRADO"+ ex);
        } catch (SQLException ex) {
            System.out.println("DEU ERRADO "+ ex);
        }catch (ScriptException ex) {
            System.out.println("DEU ERRADO "+ ex);
        }
    }

}
