<%@page import="models.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset='utf-8'>
    <title>Pagina Principal</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <spring:url value="/resources/estiloaps.css" var="estiloaps" />
    <link rel="stylesheet" type="text/css" href="${estiloaps}" />
   
</head>
<body>
    <header class='menu'>
        <div id='menurelativo'>
            <div id="logo"><strong>BACKDONALDS</strong></div>
            <nav id="menuinicial">
                <ul class="btn">
                    <li><a class="btnmenu">login</a><br/></li>
                    <li><a href="cadastro.html">cadastar</a><br/></li>
                </ul>
            </nav></br>
        </div> 
        <br>
        <br>
    </header>
    <div class="pagina">
        <div id="objPesquisa">
            <ul>
                <li> <input type="button" id="Burger" value="Burgers"> </li>
                <li> <input type="button" id="Frango" value="Frango"> </li>
                <li> <input type="button" id="Pernil" value="Pernil"> </li>
                <li> <input type="button" id="Bebidas" value="Bebidas"> </li>
                <li> <input type="text" id="search" placeholder="Pesquisa..."> </li>
            </ul>
        </div>
        <div class="cardapio">
            <div class="produto" id="xtudo">
                <div class="tituloProduto">
                    <div>X-tudo</div>
                </div>
                <div class="infosProduto">
                    <div>
                       INFORMAÇÔESMs ATUDOTUDOTUDOTUDOTUDOTUDO
                       TUDOTUDOTUDOTUDOTUDOTUDOTUDOTUDOTUDOTU
                       TUDOTUDOTUDOTUDOTUDOTUDOTUDOTUDOTUDO
                       TUDOTUDOTUDOTUDO

                    </div>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto" id="xbacon">
                <div class="tituloProduto">
                    <div>X-bacon</div>
                </div>
                <div class="infosProduto">
                    <div>
                       INFORBCAON BaconBaconBaconBaconBaconBaconBaconBaconBaconBaconBa
                       BaconBaconBaconBaconBaconBaconBaconBaconBaconBaconBacon
                       BaconBaconBaconBaconBaconBaconBaconBacon
                       BaconBaconBaconBaconBacon

                    </div>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto" id="xsalada">
                <div class="tituloProduto">
                    <div>X-salada</div>
                </div>
                <div class="infosProduto">
                    <div>
                       INFORBCAON saladasaladasaladasaladasaladasaladasaladasalada
                       saladasaladasaladasaladasaladasaladasaladasaladasaladasalada
                       saladasaladasaladasaladasaladasaladasaladasaladasaladasalada

                    </div>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto" id="xfrango">
                <div class="tituloProduto">
                    <div>X-frango</div>
                </div>
                <div class="infosProduto">
                    <div>
                       INFORBCAON frangofrnago afnafrangoanffranfo
                       frangofrnagornofaonfrnanfrangogranofrnfoa
                       franfofrnaogrnfranfrnofaonfrnanfrangogranofrnfoa
                       nadsnansdnasdnasndnasndnasdnnasdnasndnasdn
                       nasnd
                    </div>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto" id="xpernil">
                <div class="tituloProduto">
                    <div>X-frango</div>
                </div>
                <div class="infosProduto">
                    <div>
                       INFORBCAON pernilpernilpernilpernilpernil
                       pernilpernilpernilpernilpernilpernil
                       pernilpernilpernilpernilpernilpernilpernil
                       pernilpernilpernilpernilpernilpernilpernil

                    </div>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto" id="cocacola">
                <div class="tituloProduto">
                    <div>Coca-Cola</div>
                </div>
                <div class="infosProduto">
                    <div>
                        CocaCOlaCocaCOlaCocaCOlaCocaCOlaCocaCOla
                        CocaCOlaCocaCOlaCocaCOlaCocaCOlaCocaCOla
                        CocaCOlaCocaCOlaCocaCOlaCocaCOlaCocaCOlaCocaCOla
                        CocaCOlaCocaCOlaCocaCOlaCocaCOlaCocaCOla
                    </div>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
            <div class="produto" id="fanta">
                <div class="tituloProduto">
                    <div>Fanta</div>
                </div>
                <div class="infosProduto">
                    <div>
                        FanataFanataFanataFanataFanataFanataFanata
                        FanataFanataFanataFanataFanataFanataFanataFanata
                        FanataFanataFanataFanataFanataFanataFanataFanata
                    </div>
                </div>
                <div class="finalCaixaLanche">
                    <br>
                </div>
            </div>
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

    <script src='dinamismo.js'></script>
</body>
</html>