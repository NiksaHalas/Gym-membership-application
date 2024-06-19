const params = new URLSearchParams(window.location.search)
const id = params.get("id")

if (id == null || id === "") window.location.href = "./teretana.html"

const breadcrumb = document.getElementById("breadcrumb")
const cid = document.getElementById("id")
const name = document.getElementById("name")
const surname = document.getElementById("surname")
const phone = document.getElementById("phone-number")
let plan = document.getElementById("plan")
let updated = document.getElementById("updated")

fetch("http://localhost:8080/api/clanovi/" + id)
  .then((rsp) => {
    if (rsp.status === 200) return rsp.json()

    alert("Clan nije pronadjen")
    window.location.href = "./teretana.html"
  })
  .then((data) => {
    breadcrumb.innerText = ` ${data.ime} ${data.prezime} `
    cid.value = data.id
    name.value = data.ime
    surname.value = data.prezime
    phone.value = data.broj_telefona

    // Ucitavanje planova
      fetch('http://localhost:8080/api/planovi')
          .then(rsp => rsp.json())
          .then(planData =>{
              planData.forEach(plan=> {
                  const option = document.createElement("option")
                  if (plan.id === data.plan.id) {
                      option.selected = true
                  }
                  option.value = plan.id
                  option.text = plan.naziv
                  document.getElementById("plan").appendChild(option)
              })
          })



      updated = formatDate(data.updatedAt)

    document.getElementById('save').addEventListener('click', () => {
      fetch(`http://localhost:8080/api/clanovi/${data.id}`,{
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(
          {
            name: name.value,
            surname: surname.value,
            brojTelefona: phone.value,
              planId: plan.value

          }
        )
      })
        .then(rsp => {
          if (rsp.ok) {
            window.location.href = `./teretana.html`
            return
          }

          alert(`Izmena člana nije uspela (HTTP${rsp.status})`)
      })
    })
  })
