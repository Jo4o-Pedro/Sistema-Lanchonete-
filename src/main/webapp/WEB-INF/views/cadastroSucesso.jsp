<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estiloLoginCadastro.css" />" />
    <title>Cadastro</title>
</head>
<body>
    <header>
    </header>
    <div>
        <h1 class='cabecalho'>Cadastrado com sucesso</h1>
         <div class="menu">
            <h2> Voltar para pagina principal </h2>s
            <a href="<c:url value="index" />" ><h2>Backdonalds</h2></a>
        </div>
    </div>
    <div class="paicadastro">
        
    </div>
    <script src=<c:url value="cadastro.js" /> > </script>
</body>
</html>