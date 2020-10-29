<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/fimdacompra.css" />" />
    <title>Finalizar Pedido</title>
</head>
<body>
    <header>
        <h1>Finalizar a compra </h1><br><br>
        <hr/>
    </header>
    <br>
    <div id="AllPage">
        <div class="menufim">
            <h2 class="legenda">Seu Pedido:</h2>
            <div class="pedido">
                <c:forEach items="${prods}" var="prods">
                    <div class="produto">
                        <div class="tituloProduto">
                            <div>${prods.carne} + ${prods.salada}
                                + ${prods.pao} + ${prods.molho} = R$ ${prods.valor}</div>
                        </div>
                        <div class="finalCaixaLanche">
                            <br>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <hr>
            <div class="infopessoais">
                <div class="infopagamento">
                    <strong>Finalizar </strong><br>
                    <c:forEach items="${total}" var="total">
                        <h4>Preço: ${total.total} </h4><br>
                    </c:forEach>
                </div>
                    <form:form action="/Sistema-Lanchonete-/LoginUsuario" modelAttribute="loginUsuario" method="post">
                        <input class="botaofinal" type="submit" value="Finalizar Compra">
                    </form:form> 
                    
            </div>
        </div>
    </div>
</body>
</html>