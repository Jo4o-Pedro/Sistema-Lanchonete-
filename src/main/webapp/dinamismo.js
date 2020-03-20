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

const login = document.querySelector('.btnmenu')
login.addEventListener('click', () => iniciaModal('modalID'))