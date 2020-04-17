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
                    <li><a class="btnmenu">login</a><br/></li>
                    <li><a href="<c:url value="cadastro" />" >cadastar</a><br></li>
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
                <div class="produto" id="xtudo">
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

        <button class="carrinho">carrinho</button>
                

    <footer>
        <p class="assinatura">Desenvolvido por: Vinicius BInué/João Tostes</p>
    </footer>
    
    </div>
    <div class="modalLogin" id="modalID">
        <div class="modal" id="modalDentro">
            <button class="fechar">x</button>
            <h3 class="legendaLogin"> LOGIN </h3>
            <form action="/Sistema-Lanchonete-/loginUsuario" method="post">
                <input type="text" name ="email" class="inputLogin" placeholder="E-mail"><br/>
                <input type="password" name="senha" class="userkeyLogin" placeholder="Senha"/>
                <input type="submit" class="botaoLogin" value="LOGIN">
            </form>
        </div>
    </div>
    <div class="telaCarrinho">
        <ul>
            <li>Produto sdasdasdasd1</li>
            <li>Produtoasdasdasd 2</li>
            <li>Produto 3adsdasd</li>
        </ul>
    </div>

    <script src=<c:url value="dinamismo.js" /> > </script>
</body>
</html>