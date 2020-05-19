<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="fimdacompra.css" />
    <title>Finalizar a </title>
</head>
<body>
    <header>
        <h1>Finalizar a compra </h1><br><br>
        <hr/>
    </header>
    <br>
    <div id="AllPage">
        <div class="menufim">
            <h2 class="legenda">Seu Pedido</h2>
            <div class="pedido">
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
                        <div class="infosProduto">
                            <div>
                            ${lista.preco}
                            </div>
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
                    <label> Rua</label>
                    <input calss="dados"type="number"/>
                    <label> Numero</label>
                    <input type="number"><br> <br>
                </div>
             
                <input class="botaofinal" type="button" value="Finalizar Compra">
            </div>
        </div>
    </div>
</body>
</html>