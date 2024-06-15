const table = document.getElementById("table")
const template = document.getElementById("Clan")
const searchTitle = document.getElementById('search-title')

if (searchParam != null && searchParam != '') {
  searchTitle.innerText = 'Pretraga članova'
  fetchClanovi('/ime/' + searchParam)
}
else {
  searchTitle.innerText = 'Lista članova'
  fetchClanovi()
}


function fetchClanovi(url = '') {
  fetch(`http://localhost:8080/api/clanovi${url}`)
    .then((rsp) => rsp.json())
    .then((data) => {
      if (data.lenght == 0) {
        alert("Clan nije pronadjen")
        fetchClanovi()
        return

      }
      data.forEach((clanovi) => {
        const copy = template.content.cloneNode(true)
        copy.querySelector(".id").innerText = clanovi.id
        copy.querySelector(".name").innerText = clanovi.ime
        copy.querySelector(".surname").innerText = clanovi.prezime
        copy.querySelector(".email").innerText = clanovi.email
        copy.querySelector(".phone-number").innerText = clanovi.broj_telefona
        copy.querySelector(".address").innerText = clanovi.adresa
        copy.querySelector(".edit").href = `./edit.html?id=${clanovi.id}`
        copy.querySelector(".remove").addEventListener('click', () => {
          if (confirm(`Da li ste sigurni da želite da obrišete člana ${clanovi.ime} ${clanovi.prezime} ${clanovi.id}`)) {
            fetch(`http://localhost:8080/api/clanovi/${clanovi.id}`, {
              method: 'DELETE',
            })
              .then(rsp => {
                if (rsp.status == 204) {
                  window.location.href = `./teretana.html`
                  return
                }

                alert(`Brisanje  člana nije uspelo   (HTTP${rsp.status})`)
              })
          }
        })
        copy.querySelector(".updated").innerText = formatDate(clanovi.updatedAt)
        table.appendChild(copy)
      })
    })

}

function formatDate(iso) {
  if (iso == null) return 'N/A'
  return new Date(iso).toLocaleString('sr-RS')

}