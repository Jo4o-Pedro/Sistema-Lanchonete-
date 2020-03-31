import crud.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastro/novoUsu")
public class CadastrarUsuario extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String nombre = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = "telefone";

        Usuario usuario = new Usuario();

        usuario.SetNome(nombre);
        usuario.SetEmail(email);
        usuario.SetSenha(senha);
        usuario.SetTelefone(telefone);

        request.setAttribute("usuario", usuario);
        RequestDispatcher disp = request.getRequestDispatcher("computador.jsp");
        disp.forward(request, response);
    }

}
