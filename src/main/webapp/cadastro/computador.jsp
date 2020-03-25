
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Computador de Bordo</title>
    </head>
    <body>
            <%  String nome = request.getParameter("nome");
                String email = request.getParameter("email");
            %>
        <h1>Resultado do Calculo</h1>
        <form>
            nOme do CUZAO
            <input type="text" value="<%= nome %>" ><br>
            EMial do COrono
            <input type="text" value="<%= email %>" >
            <input type="button" value="KAKAKKAKAKAKKK" onclick="history.back()">
        </form>
    </body>
</html>