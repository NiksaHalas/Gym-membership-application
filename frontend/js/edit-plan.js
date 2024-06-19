const params = new URLSearchParams(window.location.search)
const id = params.get("id")

if (id === null || id === "") window.location.href = "./teretana.html"

const breadcrumb = document.getElementById("breadcrumb")
const pid = document.getElementById("id")
const naziv = document.getElementById("naziv")
const cena = document.getElementById("cena")
let created = document.getElementById("created")
let updated = document.getElementById("updated")

fetch("http://localhost:8080/api/planovi/" + id)
    .then((rsp) => {
        if (rsp.status === 200) return rsp.json()

        alert("Plan nije pronadjen")
        window.location.href = "./plan.html"
    })
    .then((data) => {
        breadcrumb.innerText = ` ${data.naziv} ${data.cena} `
        pid.value = data.id
        naziv.value = data.naziv
        cena.value = data.cena
        created = formatDate(data.createdAt)
        updated = formatDate(data.updatedAt)

        document.getElementById('save').addEventListener('click', () => {
            fetch(`http://localhost:8080/api/planovi/${data.id}`,{
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(
                    {
                        naziv: naziv.value,
                        cena: parseInt(cena.value),
                    }
                )
            })
                .then(rsp => {
                    if (rsp.ok) {
                        window.location.href = `./plan.html`
                        return
                    }

                    alert(`Izmena plana nije uspela (HTTP${rsp.status})`)
                })
        })
    })
