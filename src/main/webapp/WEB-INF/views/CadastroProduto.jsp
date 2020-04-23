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
        <form:form class="formCadastro" action="/Sistema-Lanchonete-/CrudProd" modelAttribute="produto">
        <div class="menu">
            <ul>
                <li id="CadastraProduto">Cadastro Ingrediente</li>
                <li id="RecebeProduto">Manutenção Ingrediente</li><br><br>
                <li>
                    <input type="submit" name="adiciona" value="adiciona">
                    <img class="imagem" src="https://image.flaticon.com/icons/svg/711/711274.svg"/>
                </li>
                <li>
                    <input type="submit" name="pesquisa" value="pesquisa">
                    <img class="imagem" src="https://cdn.icon-icons.com/icons2/494/PNG/128/magnifier_icon-icons.com_48267.png"/>
                </li>
                <li>
                    <input type="submit" name="deleta" value="deleta">
                    <img class="imagem" src="https://cdn.icon-icons.com/icons2/494/PNG/128/trash_icon-icons.com_48207.png"/>
                </li>
                <li>
                    <input type="submit" name="atualiza" value="atualiza">
                    <img class="imagem" src="https://cdn.discordapp.com/attachments/564604859245002756/695444807841087519/atualizar.png" alt="Atualizar">
                </li>
            </ul>
        </div>
    </header>
    <div id = "PAGINAINTEIRA">
        <div id="blocoCadastro">
            <div id="CodigoProd">
                <label>Codigo do Ingrediente</label><br>
                <form:input path="id" type="text"  tabindex="-1"/>  
            </div><br>
            <div id="NomeReduzido">
                <label>Nome Reduzido</label><br>
                <form:input path="nome" type="text" tabindex="-1"/>
            </div><br>
            <div id="DescricaoProd">
                <label>Descrição</label><br>
                <form:input path="descricao" type="text"  tabindex="-1"/>
            </div><br>
            <div id="CategoriaProd">
                <label>Categoria</label><br>
                <form:select path="categoria" id="ComboCategoria"  tabindex="-1">
                    <option value="Bebida"> Bebida </option>
                    <option value="Burger"> Burger </option>
                    <option value="Frango"> Frango </option>
                    <option value="Pernil"> Pernil </option>
                </form:select>
            </div><br>
            <div id="InfoProd">
                <label>Informações Produto</label><br>
                <form:textarea  path="informacao" tabindex="-1"></form:textarea>
            </div>
            <br>
        </form:form>
        </div>
        <hr class='linha'>
    </div>
    <footer class="rodape">
        <div>Icones feitos por <a href="https://www.flaticon.com/br/autores/freepik" title="Freepik">João Tostes</a> from <a href="https://www.flaticon.com/br/" title="Vinicius Binue">www.binue.com</a></div>
    </footer>

    <script src="<c:url value='/resources/js/dinamicaCadProd.js' />"></script>
</body>
</html>