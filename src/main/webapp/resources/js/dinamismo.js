function iniciaModal(modalId){
  const modal = document.getElementById(modalId)
  if(modal){
    modal.classList.add('mostrar')
    modal.addEventListener('click', (e) => {
      if(e.target.id == modalId || e.target.className == 'fechar') {
        modal.classList.remove('mostrar')
      }
    })
  }
}

function clicaBtn(){
  const btnPesquisa = document.getElementById('BtnPesquisa')
  btnPesquisa.click()
}

const login = document.querySelector('.btnmenu')
login.addEventListener('click', () => iniciaModal('modalID'));


$(function () {
 var menu_width = 290;
 var menu = $(".menucar");
 var menu_open = $(".menu-open");
 var menu_close = $(".menu-close");
 var overlay = $(".overlay");

 menu_open.click(function (e) {
   e.preventDefault();
   menu.css({"right": "0px"});
   overlay.css({"opacity": "1", "width": "100%"});
 });
 
 menu_close.click(function (e) {
   e.preventDefault();
   menu.css({"right": "-" + menu_width + "px"});
   overlay.css({"opacity": "0", "width": "0"});
 });
});
//function MostraCarrinho()



//const carrinho = document.querySelector('.carrinho')
//carrinho.addEventListener('click', () => MostraCarrinho('MostraCarrinho'));


