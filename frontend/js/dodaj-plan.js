document.getElementById("save").addEventListener("click", function (event) {
    event.preventDefault()

    const naziv = document.getElementById("name")
    const cena = document.getElementById("price")


    if (naziv.value === '' || naziv.value === null) {
        alert('Naziv plana mora biti popunjen')
    }

    if (cena.value === '' || cena.value === null) {
        alert('Cena plana mora biti popunjena')
    }

    console.log('Spremam podatke za dodavanje:', { naziv, cena})

    fetch('http://localhost:8080/api/planovi', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
            {
                naziv: naziv.value,
                cena: cena.value,
            }
        )
    }).then(rsp => {
        if (rsp.ok) {
            console.log('Plan uspešno dodat.')
            window.location.href = `./plan.html`
            return
        }

        alert(`Dodavanje plana nije uspelo (HTTP${rsp.status})`)
    })
})
