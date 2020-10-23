<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
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
                    <li><button class="btnmenu">Perfil</button><br/></li>
                </ul>
            </nav><br>
        </div> 
        <br>
        <br>
    </header>
    <div class="pagina">
        <div class="cardapio">
            <c:forEach items="${lista}" var="lista">
                <div class="produto">
                    <div class="tituloProduto">
                        <div>${lista.nome}</div>
                    </div>
                    <div class="infosProduto">
                        <div>
                           ${lista.descricao}
                        </div>
                    </div>
                    <div class="finalCaixaLanche">
                        <br>
                        <form:form action="/Sistema-Lanchonete-/adiciona" method="POST">
                            <c:forEach items="${user}" var="user">
                               <input class="esconde" type="text" name="idUser" value="${user.id}"/>
                               <input class="esconde" type="text" name="senha" value="${user.senha}"/>
                               <input class="esconde" type="text" name="email" value="${user.email}"/>
                            </c:forEach>
                               <input class="esconde" type="text" name="id_produto" value="${lista.id}"/>
                               <input type="number" class="esconde" name="quantidade" value="1" />
                            <input type="submit" class="add" name="add_carinho" value="adicionar" />
                        </form:form>
                    </div>
                </div>
            </c:forEach>
        </div>

                

    <footer>
        <p class="assinatura">Desenvolvido por: Vinicius BInué/João Tostes</p>
    </footer>
    
    </div>
    <div class="modalLogin" id="modalID">
        <div class="modal" id="modalDentro">
            <button class="fechar">x</button>
            <c:forEach items="${user}" var="user">
            <h3 class="legendaLogin"> ${user.getNome()} </h3>
            </c:forEach>
            <a class="deslogar" href="index"> DESLOGAR </a>
        </div>
    </div>
    <a href="<c:url value="#" />" class="menu-open">Abrir Carrinho</a>

    <div class="overlay"></div>

    <div class="menucar">
      <a href="<c:url value="#" />" class="menu-close">&times;</a>
      <ul>
        <form:form action="/Sistema-Lanchonete-/fimPedido" method="POST">
            <c:forEach items="${carrinho}" var="carrinho">
                <li><a href="<c:url value="#" />" target="_blank">${carrinho.nome_prod}</a></li>
            </c:forEach>
            <c:forEach items="${user}" var="user">
                <input class="esconde" type="text" name="id_user" value="${user.id}"/>
            </c:forEach>
            <input type="submit" name="add_carinho" value="adicionar" />
        </form:form>
      </ul>
    </div>

<script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js' />" ></script>
<script src="<c:url value='/resources/js/dinamismo.js' />" ></script>

</body>
</html>