<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Cadastrar Produto</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/CadastroProd.css" />" />
</head>
<body>
    <header>
        <div class="menu">
            <a href="<c:url value="index" />" ><img src="https://cdn.discordapp.com/attachments/757733760979435562/770459941458804766/LogoNOvanova.png"></a>
        </div>
        <form:form class="formCadastro" action="/Sistema-Lanchonete-/CrudProd" modelAttribute="produto">
        <div class="menu">
            <ul>
                <li>
                    <input type="image" class="imagem" name="adiciona" value="adiciona" alt="adiciona" src="https://image.flaticon.com/icons/svg/711/711274.svg"/>
                </li>
                <li>
                    <input type="image" class="imagem" name="pesquisa" value="pesquisa" alt="pesquisa" src="https://cdn.icon-icons.com/icons2/494/PNG/128/magnifier_icon-icons.com_48267.png"/>
                </li>
                <li>
                    <input type="image" class="imagem" name="deleta" value="deleta" alt="deleta" src="https://cdn.icon-icons.com/icons2/494/PNG/128/trash_icon-icons.com_48207.png"/>
                </li>
                <li>
                    <input type="image" class="imagem" name="atualiza" value="atualiza" alt="atualiza" src="https://cdn.discordapp.com/attachments/564604859245002756/695444807841087519/atualizar.png">
                </li>
                <li>
                    
                </li>
            </ul>
        </div>
    </header>
    <div id = "PAGINAINTEIRA">
        <div id="blocoCadastro">
            <div id="CodigoProd">
                <label>Codigo </label><br>
                <form:input path="id" type="text"  />  
            </div><br>
            <div id="NomeReduzido">
                <label>Nome Reduzido</label><br>
                <form:input path="nome" type="text" />
            </div><br>
            <div id="DescricaoProd">
                <label>Descrição</label><br>
                <form:textarea path="descricao" type="text"  />
            </div><br>
            <div id="Preco">
                <label>Preço</label><br>
                <form:input type="number" path="preco" step="0.01" />
            </div><br>
            <div id="CategoriaProd">
                <label>Categoria</label><br>
                <form:select path="categoria" id="ComboCategoria"  >
                    <form:option value="PAO"> Pão </form:option>
                    <form:option value="CARNE"> Carne </form:option>
                    <form:option value="SALADA"> Salada </form:option>
                    <form:option value="MOLHO"> Molho </form:option>
                </form:select>
            </div><br>
            <br>
        </form:form>
        </div>
        <form:form class="relatorioVendas" action="/Sistema-Lanchonete-/relatorio" modelAttribute="pedido">
        <div id ="relatorio">
            <ul>
                <li><input type="submit" value="Procurar" class="btn" /></li>
                    
                <li class="filtrodedata">
                    <h4> Filtrar entre a data </h4>
                    <input type="date" name="inicio"/>
                    <h4>E </h4>
                    <input type="date" name="fim"/>
                </li>    
                <li>
                    <c:forEach items="${pedido}" var="pedido">
                        <div>Total de venda no perído: R$ ${pedido.totalRS}</div>
                    </c:forEach>
                    <c:forEach items="${produtosLista}" var="produtosLista">
                        <div>A carne mais vendida é: ${produtosLista.carne}</div>
                        <div>O pao mais vendido é: ${produtosLista.pao}</div>
                        <div>A salada mais vendida é: ${produtosLista.salada}</div>
                        <div>O molho mais vendido é: ${produtosLista.molho}</div>
                    </c:forEach>
                </li>
            </ul>
        </div>
        </form:form>
    </div>

    <script src="<c:url value='/resources/js/dinamicaCadProd.js' />"></script>
</body>
</html>