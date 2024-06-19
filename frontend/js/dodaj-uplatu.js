document.addEventListener("DOMContentLoaded", function() {
    // Učitavanje članova
    fetch('http://localhost:8080/api/clanovi')
        .then(rsp => rsp.json())
        .then(clanData => {
            const clanSelect = document.getElementById("clan")
            clanData.forEach(clan => {
                const option = document.createElement("option")
                option.value = clan.id
                option.text = `${clan.ime} ${clan.prezime}`
                clanSelect.appendChild(option)
            })
        })

    document.getElementById("save").addEventListener("click", function(event) {
        event.preventDefault()

        const clanSelect = document.getElementById("clan")
        const clanId = parseInt(clanSelect.value)
        const amount = parseFloat(document.getElementById("amount").value)
        const paymentDate = document.getElementById("payment-date").value

        if (!clanId) {
            alert('Član mora biti odabran')
            return
        }

        if (!amount || amount <= 0) {
            alert('Iznos uplate mora biti veći od nule')
            return
        }

        if (!paymentDate) {
            alert('Datum uplate ne sme biti prazan')
            return
        }

        const newUplata = {
            clanId: clanId,
            iznos: amount,
            datumUplate: paymentDate
        }

        console.log('Spremam podatke za dodavanje uplate:', newUplata)

        fetch('http://localhost:8080/api/uplate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newUplata)
        })
            .then(rsp => {
                if (rsp.ok) {
                    console.log('Uplata uspešno dodata.')
                    window.location.href = `./uplate.html`
                } else {
                    rsp.json().then(error => {
                        alert(`Dodavanje uplate nije uspelo (HTTP ${rsp.status}): ${error.message}`)
                    })
                }
            })
            .catch(error => {
                console.error('Error:', error)
                alert(`Došlo je do greške: ${error.message}`)
            })
    })
})
