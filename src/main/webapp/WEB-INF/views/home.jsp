<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset='utf-8'>
    <title>Pagina Principal</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/estiloaps.css" />" />
    
</head>
<body>    
    <header class='menu'>
        <div id='menurelativo'>
            <div id="logo"><strong>BACKDONALDS</strong></div>
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
        <div id="objPesquisa">
            <ul>
                <li>
                    <form:form action="/Sistema-Lanchonete-/burger" modelAttribute="loginUsuario" method="post">
                        <input type="submit" id="Burger" name="action" value="Burger">
                        <form:input type="text" path="email" name ="email" class="esconde"/><br/>
                        <form:input type="password" path="senha" name="senha" class="esconde"/>
                    </form:form> 
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/frango" modelAttribute="loginUsuario" method="post">
                        <input type="submit" id="Frango" name="action" value="Frango">
                        <form:input type="text" path="email" name ="email" class="esconde"/><br/>
                        <form:input type="password" path="senha" name="senha" class="esconde"/>
                    </form:form>
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/porcao" modelAttribute="loginUsuario" method="post">
                        <input type="submit" id="Porcao" name="action" value="Porcoes">
                        <form:input type="text" path="email" name ="email" class="esconde"/><br/>
                        <form:input type="password" path="senha" name="senha" class="esconde"/>
                    </form:form>
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/bebida" modelAttribute="loginUsuario" method="post">
                        <input type="submit" id="Bebidas" name="action" value="Bebidas" /> 
                        <form:input type="text" path="email" name ="email" class="esconde"/><br/>
                        <form:input type="password" path="senha" name="senha" class="esconde"/>
                    </form:form>
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/filtro" modelAttribute="loginUsuario" method="post">
                        <form:input type="text" path="filtro" id="search" placeholder="Pesquisa..." onblur="clicaBtn()" />
                        <form:input type="text" path="email" name ="email" class="esconde"/><br/>
                        <form:input type="password" path="senha" name="senha" class="esconde"/>
                        <input type="submit" class="esconde" name="action" value="pesquisa" id="BtnPesquisa"/>
                    </form:form>
                </li>
            </ul>
        </div>
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
                               <input class="esconde" type="text" name="usernome" value="${user.id}"/>
                            </c:forEach>
                               <input class="esconde" type="text" name="id_produto" value="${lista.id}"/>
                               <input type="number" class="add" name="quantidade" value="0" />
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
            <a href="index"> DESLOGAR </a>
        </div>
    </div>
    <a href="<c:url value="#" />" class="menu-open">Abrir Menu</a>

    <div class="overlay"></div>

    <div class="menucar">
      <a href="<c:url value="#" />" class="menu-close">&times;</a>
      <ul>
        <c:forEach items="${carrinho}" var="carrinho">
        <li><a href="<c:url value="#" />" target="_blank">${carrinho.quantidade}  ${carrinho.nome_prod}</a></li>
        </c:forEach>
        <a href="<c:url value="fimPedido" />">finalizar o pedido</a>
      </ul>
    </div>

<script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js' />" ></script>
<script src="<c:url value='/resources/js/dinamismo.js' />" ></script>

</body>
</html>