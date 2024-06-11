const id = params.get("id");

if (id == null || id == "") window.location.href = "./teretana.html";

const breadcrumb = document.getElementById("breadcrumb")
const cid = document.getElementById("id")
const name = document.getElementById("name")
const surname = document.getElementById("surname")
const email = document.getElementById("email")
const phone = document.getElementById("phone-number")
let address = document.getElementById("address")
let updated = document.getElementById("updated")

fetch("http://localhost:8080/api/clanovi/" + id)
  .then((rsp) => {
    if (rsp.status == 200) return rsp.json();

    alert("Clan nije pronadjen");
    window.location.href = "./teretana.html";
  })
  .then((data) => {
    breadcrumb.innerText = ` ${data.ime} ${data.prezime} `;
    cid.value = data.id;
    name.value = data.ime;
    surname.value = data.prezime;
    email.value = data.email;
    phone.value = data.broj_telefona;
    address.value = data.adresa;
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
            email: email.value,
            brojTelefona: phone.value,
            adresa: address.value
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
  });
