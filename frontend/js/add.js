document.getElementById("save").addEventListener("click", function (event) {
  event.preventDefault()

  const name = document.getElementById("name")
  const surname = document.getElementById("surname")
  const email = document.getElementById("email")
  const phone = document.getElementById('phone-number')
  const address = document.getElementById('address')


  if (name.value == '' || name.value == null) {
    alert('Ime člana ne sme biti prazno')
  }

  if (surname.value == '' || surname.value == null) {
    alert('Prezime člana ne sme biti prazno')
  }

  if (email.value == '' || email.value == null) {
    alert('Email člana ne sme biti prazan')
  }
  if (phone.value == '' || phone.value == null) {
    alert('Broj telefona člana ne sme biti prazan')
  }
  if (address.value == '' || address.value == null) {
    alert('Adresa člana ne sme biti prazana')
  }
  console.log('Spremam podatke za dodavanje:', { name, surname, email, phone, address })

  fetch('http://localhost:8080/api/clanovi', {
    method: 'POST',
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
  }).then(rsp => {
    if (rsp.ok) {
      console.log('Član uspešno dodat.');
      window.location.href = `./teretana.html`
      return
    }

    alert(`Dodavanje člana nije uspelo (HTTP${rsp.status})`)
  })
})
