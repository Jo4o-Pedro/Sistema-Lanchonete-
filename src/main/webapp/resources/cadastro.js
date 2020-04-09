
function onlynumber(evt) {
   var theEvent = evt || window.event;
   var key = theEvent.keyCode || theEvent.which;
   key = String.fromCharCode( key );
   //var regex = /^[0-9.,]+$/;
   var regex = /^[0-9.]+$/;
   if( !regex.test(key) ) {
      theEvent.returnValue = false;
      if(theEvent.preventDefault) theEvent.preventDefault();
   }
};


function AdicionaCss(classeRecebendo){
   
}

const btnAdicionaCss = document.getElementById('AdicionaCSS')
const avisoEmail = document.getElementById('EmailExistente')
btnAdicionaCss.addEventListener('click', () => avisoEmail.style.display = "block");
