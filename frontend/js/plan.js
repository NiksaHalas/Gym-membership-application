const table = document.getElementById('plan-table')
const template = document.getElementById('plan')

fetch('http://localhost:8080/api/planovi')
    .then((rsp) => rsp.json())
    .then((data) => {
        data.forEach((plan) => {
            const copy = template.content.cloneNode(true)
            copy.querySelector(".id").innerText = plan.id
            copy.querySelector(".name").innerText = plan.naziv
            copy.querySelector(".price").innerText = plan.cena
            copy.querySelector(".created").innerText = plan.createdAt
            copy.querySelector(".updated").innerText = plan.updatedAt
            copy.querySelector(".edit").href = `./edit-plan.html?id=${plan.id}`
            copy.querySelector(".remove").addEventListener('click', () => {
              if (confirm(`Da li ste sigurni da želite da obrišete plan ${plan.naziv} ${plan.cena}`)) {
                  fetch(`http://localhost:8080/api/planovi/${plan.id}`, {
                      method: 'DELETE',
                      })
                  .then(rsp => {
                          if (rsp.status === 204) {
                              window.location.href = `./plan.html`
                              return
                          }

                                      alert(`Brisanje plana nije uspelo   (HTTP${rsp.status})`)
                      })
              }
              })
            copy.querySelector(".updated").innerText = formatDate(plan.updatedAt)
            table.appendChild(copy)
        })
    })