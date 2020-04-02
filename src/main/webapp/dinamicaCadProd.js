function Desabilita(componenteID){
    let cadastroAtivo = 0;
    let recebimentoAtivo = 0;
    if (componenteID == 'cadastro'){
        const divAtiva = document.getElementById('blocoCadastro')
        const divDesativa = document.getElementById('blocoEntrada')
        divDesativa.classList.add('disabledbutton')
        divAtiva.classList.remove('disabledbutton')
        console.log("foi 1")
        cadastroAtivo = 1
        recebimentoAtivo = 0
    }
    else{
        const divDesativa = document.getElementById('blocoCadastro')
        const divAtiva = document.getElementById('blocoEntrada')
        divDesativa.classList.add('disabledbutton')
        divAtiva.classList.remove('disabledbutton')
        console.log("foi 2")
        cadastroAtivo = 0
        recebimentoAtivo = 1
    }
} ;




const cadastro = document.getElementById('CadastraProduto')
cadastro.addEventListener('click', () => Desabilita('cadastro'));

const recebe = document.getElementById('RecebeProduto')
recebe.addEventListener('click', () => Desabilita('recebe'));