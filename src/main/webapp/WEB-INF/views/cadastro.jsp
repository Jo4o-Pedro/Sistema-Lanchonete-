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
        <div class="menu">
            <a href="<c:url value="index" />" ><h2>LocaDex</h2></a>
        </div>
    </header>
    <div>
        <h1 class='cabecalho'>Cadastro</h1>
    </div>
    <div class="paicadastro">
        <form:form class="cadastrar" modelAttribute="usuario" action="/Sistema-Lanchonete-/novoUsuario" method="post">
            <div class="dados">
                <ul >
                    <li class='legenda'><h2>Nome</h2></li>
                    <li><form:input path="nome" type="text" name="nome"/></li>
                    <li class='legenda'><h2>E-mail</h2></li>
                    <li><form:input path="email" type="email" name="email"/></li>
                    <li class='legenda'><h2>Senha</h2></li>
                    <li><form:input path="senha" type="password" name="senha"/></li>
                    <li class='legenda'><h2>Confirma Senha</h2></li>
                    <li><input type="password" name="confirma"/></li>
                    <li class='legenda'><h2>Telefone</h2></li>
                    <li><form:input path="telefone" type="tel" name="telefone"/></li>
                    <li><input type="submit" class="finalcadastro" name="cadastrar" value="Cadastrar"/></li>
                    <br>
                    <h3 id='EmailExistente'>Esse Email ja esta cadastrado!</h3>
                </ul>   
            </div>
        </form:form>
    </div>
    <script src=<c:url value="/resources/js/cadastro.js" /> > </script>
</body>
</html>