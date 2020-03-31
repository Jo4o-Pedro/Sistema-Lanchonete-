import crud.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginUsuario")
public class LoginUsuario extends HttpServlet{
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario LogarUsuario = new Usuario();

        LogarUsuario.SetEmail(email);
        LogarUsuario.SetSenha(senha);

        System.out.println(LogarUsuario.GetEmail() + LogarUsuario.GetSenha());
    };
}