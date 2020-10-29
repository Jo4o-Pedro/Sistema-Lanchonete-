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
            <form:form action="/Sistema-Lanchonete-/adiciona" method="POST">
            <div class="produto">
                <div class="tituloProduto">
                    <h3>Pães</h3>
                </div>
                <div class="infosProduto">
                   <c:forEach items="${paes}" var="paes">
                    <input type="radio" class="radiobtn" id="paes" name="paes" value=${paes.nome} checked>
                    <h4>${paes.nome}</h4>
                    <p>${paes.descricao}</p>
                    <br>
                    <p>R$ ${paes.preco}</p>
                    <hr>
                   </c:forEach>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto">
                <div class="tituloProduto">
                    <h3>Carnes</h3>
                </div>
                <div class="infosProduto">
                   <c:forEach items="${carnes}" var="carnes">
                    <input type="radio" class="radiobtn" id="carne" name="carnes" value=${carnes.nome} checked>
                    <h4>${carnes.nome}</h4>
                    <p>${carnes.descricao}</p>
                    <br>
                    <p>R$ ${carnes.preco}</p>
                    <hr>
                   </c:forEach>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto">
                <div class="tituloProduto">
                    <h3>Molhos</h3>
                </div>
                <div class="infosProduto">
                   <c:forEach items="${molhos}" var="molhos">
                    <input type="radio" id="molhos" name="molhos" value=${molhos.nome} checked>
                    <h4>${molhos.nome}</h4>
                    <p>${molhos.descricao}</p>
                    <br>
                    <p>R$ ${molhos.preco}</p>
                    <hr>
                   </c:forEach>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto">
                <div class="tituloProduto">
                    <h3>Saladas</h3>
                </div>
                <div class="infosProduto">
                   <c:forEach items="${saladas}" var="saladas">
                    <input type="radio" id="salada" name="saladas" value=${saladas.nome} checked>
                    <h4>${saladas.nome}</h4>
                    <p>${saladas.descricao}</p>
                    <br>
                    <p>R$ ${saladas.preco}</p>
                    <hr>
                   </c:forEach>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                    
                </div>
            </div>
            
                <c:forEach items="${user}" var="user">
                   <input class="esconde" type="text" name="idUser" value="${user.id}"/>
                   <input class="esconde" type="text" name="senha" value="${user.senha}"/>
                   <input class="esconde" type="text" name="email" value="${user.email}"/>
                </c:forEach>
                <input type="submit" class="add" name="add_carinho" value="adicionar" />
            </form:form>
        </div>

                
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
                <li>${carrinho.carne} + ${carrinho.salada}
                 + ${carrinho.pao} + ${carrinho.molho} = R$ ${carrinho.valor}</a></li>
            </c:forEach>
            <c:forEach items="${user}" var="user">
                <input class="esconde" type="text" name="id_user" value="${user.id}"/>
            </c:forEach>
            <input type="submit" name="add_carinho" value="Finalizar Pedido" />
        </form:form>
      </ul>
    </div>

<script src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js' />" ></script>
<script src="<c:url value='/resources/js/dinamismo.js' />" ></script>

</body>
</html>