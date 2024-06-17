document.addEventListener("DOMContentLoaded", function() {

  // Ucitavanje planova
  fetch('http://localhost:8080/api/planovi')
      .then(rsp => rsp.json())
      .then(planData => {
        planData.forEach(plan => {
          const option = document.createElement("option")
          option.value = plan.id
          option.text = plan.naziv
          document.getElementById("plan").appendChild(option)
        })

      })


  document.getElementById("save").addEventListener("click", function (event) {
    event.preventDefault()

    const name = document.getElementById("name")
    const surname = document.getElementById("surname")
    const phone = document.getElementById('phone-number')
    let plan = document.getElementById("plan")


    if (name.value === '' || name.value == null) {
      alert('Ime člana ne sme biti prazno')
    }

    if (surname.value === '' || surname.value == null) {
      alert('Prezime člana ne sme biti prazno')
    }

    if (phone.value === '' || phone.value == null) {
      alert('Broj telefona člana ne sme biti prazan')
    }
    console.log('Spremam podatke za dodavanje:', {name, surname, phone, plan})

    fetch('http://localhost:8080/api/clanovi', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(
          {
            name: name.value,
            surname: surname.value,
            brojTelefona:  phone.value,
            planId: plan.value

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
})

