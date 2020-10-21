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
            <a href="<c:url value="index" />" ><h2>(っ◔◡◔)っ ♥ Back'sDonald's ♥</h2></a>
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
                <form:input path="id" type="text"  tabindex="-1"/>  
            </div><br>
            <div id="NomeReduzido">
                <label>Nome Reduzido</label><br>
                <form:input path="nome" type="text" tabindex="-1"/>
            </div><br>
            <div id="DescricaoProd">
                <label>Descrição</label><br>
                <form:textarea path="descricao" type="text"  tabindex="-1"/>
            </div><br>
            <div id="Preco">
                    <label>Preço</label><br>
                    <form:input type="number" path="preco" step="0.01" tabindex="-1"/>
            </div><br>
            <div id="CategoriaProd">
                <label>Categoria</label><br>
                <form:select path="categoria" id="ComboCategoria"  tabindex="-1">
                    <form:option value="PAO"> Pão </form:option>
                    <form:option value="CARNE"> Carne </form:option>
                    <form:option value="SALADA"> Salada </form:option>
                    <form:option value="MOLHO"> Molho </form:option>
                </form:select>
            </div><br>
            <br>
        </form:form>
        </div>
    </div>
    <footer class="rodape">
        <div>Icones feitos por <a href="https://www.flaticon.com/br/autores/freepik" title="Freepik">João Tostes</a> from <a href="https://www.flaticon.com/br/" title="Vinicius Binue">www.binue.com</a></div>
    </footer>

    <script src="<c:url value='/resources/js/dinamicaCadProd.js' />"></script>
</body>
</html>