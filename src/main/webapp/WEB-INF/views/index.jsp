<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset='utf-8'>
    <title>♥ Back'sDonald's ♥</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estiloaps.css" />" />
    
</head>
<body>    
    <header class='menu'>
        <div id='menurelativo'>
            <div id="logo"><strong>(っ◔◡◔)っ ♥ Back'sDonald's ♥</strong></div>
            <nav id="menuinicial">
                <ul class="btn">
                    <li><a class="btnmenu">login</a><br/></li>
                    <li><a href="<c:url value="cadastro" />" >cadastRar</a><br></li>
                    <li><a href="<c:url value="cadprod" />" >pagina administrativa</a><br></li>
                </ul>
            </nav><br>
        </div> 
        <br>
        <br>
    </header>
    <div class="pagina">
        <div class="cardapio">
                <div class="produto">
                    <div class="tituloProduto">
                        <div>$TESTE</div>
                    </div>
                    <div class="infosProduto">
                        <div>
                           TESTAD
                        </div>
                    </div>
                    <div class="finalCaixaLanche">
                        <br>
                    </div>
                </div>
        </div>

                

    <footer>
        <p class="assinatura">Desenvolvido por: Vinicius BInué/João Tostes</p>
    </footer>
    
    </div>
    <div class="modalLogin" id="modalID">
        <div class="modal" id="modalDentro">
            <button class="fechar">x</button>
            <h3 class="legendaLogin"> LOGIN </h3>
            <form:form action="/Sistema-Lanchonete-/LoginUsuario" modelAttribute="loginUsuario" method="post" >
                <form:input type="text" path="email" name ="email" class="inputLogin" placeholder="E-mail"/><br/>
                <form:input type="password" path="senha" name="senha" class="userkeyLogin" placeholder="Senha"/>
                <input type="submit" class="botaoLogin" value="LOGIN">
            </form:form>
        </div>
    </div>

<script src="<c:url value='/resources/js/dinamismo.js' />" ></script>

</body>
</html>