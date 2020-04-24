<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <form:form action="/Sistema-Lanchonete-/burger" method="post">
                        <input type="submit" id="Burger" value="Burgers">
                    </form:form> 
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/frango" method="post">
                        <input type="submit" id="Frango" value="Frango">
                    </form:form>
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/porcao" method="post">
                        <input type="submit" id="Porcao" value="Porções">
                    </form:form>
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/bebida" method="post">
                        <input type="submit" id="Bebidas" value="Bebidas" /> 
                    </form:form>
                </li>
                <li>
                    <form:form action="/Sistema-Lanchonete-/filtro" modelAttribute="pesquisa" method="post">
                        <form:input type="text" path="filtro" id="search" placeholder="Pesquisa..." onblur="clicaBtn()" />
                        <input type="submit" class="esconde" id="BtnPesquisa"/>
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
            <h3 class="legendaLogin"> ${user.nome} </h3>
            </c:forEach>
            <a> DESLOGAR </a>
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