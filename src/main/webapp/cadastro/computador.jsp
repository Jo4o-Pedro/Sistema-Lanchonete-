<%@page import="crud.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Computador de Bordo</title>
    </head>
    <body>
            <%  
                Usuario usuario = (Usuario) request.getAttribute("usuario");
            %>
        <h1>Resultado do Calculo</h1>
        <form>
            nOme do CUZAO
            <input type="text" value="<%= usuario.GetNome() %>" ><br>
            EMial do COrono
            <input type="text" value="<%= usuario.GetEmail() %>" >
            <input type="button" value="KAKAKKAKAKAKKK" onclick="history.back()">
            <p> SUA SENHA VAZOA  </p> <%= usuario.GetSenha() %>
        </form>
    </body>
</html>