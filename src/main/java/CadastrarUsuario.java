import crud.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
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

        
        request.setAttribute("usuario", nombre);
        request.setAttribute("email", email);

        String url = ("computador.jsp?nome=" + nombre + "&email=" + email);
        response.sendRedirect(url);
    }

}
