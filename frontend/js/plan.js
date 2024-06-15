const table = document.getElementById('plan-table')
const template = document.getElementById('plan')

fetch('http://localhost:8080/api/planovi')
    .then((rsp) => rsp.json())
    .then((data) => {
        data.forEach((clanovi) => {
            const copy = template.content.cloneNode(true)
            copy.querySelector(".id").innerText = clanovi.id
            copy.querySelector(".name").innerText = clanovi.naziv
            copy.querySelector(".price").innerText = clanovi.cena
            copy.querySelector(".created").innerText = clanovi.createdAt
            copy.querySelector(".updated").innerText = clanovi.updatedAt
        //    copy.querySelector(".edit").href = `./edit.html?id=${clanovi.id}`
            //    copy.querySelector(".remove").addEventListener('click', () => {
            //  if (confirm(`Da li ste sigurni da želite da obrišete člana ${clanovi.ime} ${clanovi.prezime} ${clanovi.id}`)) {
            //      fetch(`http://localhost:8080/api/clanovi/${clanovi.id}`, {
            //          method: 'DELETE',
                //      })
            //      .then(rsp => {
            //              if (rsp.status == 204) {
            //                  window.location.href = `./teretana.html`
            //                  return
            //              }
//
            //                          alert(`Brisanje  člana nije uspelo   (HTTP${rsp.status})`)
            //          })
            //  }
            //  })
            copy.querySelector(".updated").innerText = formatDate(clanovi.updatedAt)
            table.appendChild(copy)
        })
    })