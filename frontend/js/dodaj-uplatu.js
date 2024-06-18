document.addEventListener("DOMContentLoaded", function() {

    // Učitavanje članova
    fetch('http://localhost:8080/api/clanovi')
        .then(rsp => rsp.json())
        .then(clanData => {
            clanData.forEach(clan => {
                const option = document.createElement("option")
                option.value = clan.id
                option.text = `${clan.ime} ${clan.prezime}`
                document.getElementById("clan").appendChild(option)
            })
        })

    document.getElementById("save").addEventListener("click", function(event) {
        event.preventDefault()

        const clan = document.getElementById("clan")
        const amount = document.getElementById("amount")
        const paymentDate = document.getElementById("payment-date")

        if (clan.value === '' || clan.value == null) {
            alert('Član mora biti odabran')
            return
        }

        if (amount.value === '' || amount.value == null || amount.value <= 0) {
            alert('Iznos uplate mora biti veći od nule')
            return
        }

        if (paymentDate.value === '' || paymentDate.value == null) {
            alert('Datum uplate ne sme biti prazan')
            return
        }

        console.log('Spremam podatke za dodavanje uplate:', {clan, amount, paymentDate})

        fetch('http://localhost:8080/api/uplate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                clanId: clan.value,
                iznos: amount.value,
                datumUplate: paymentDate.value
            })
        }).then(rsp => {
            if (rsp.ok) {
                console.log('Uplata uspešno dodata.');
                window.location.href = `./uplate.html`
                return
            }

            alert(`Dodavanje uplate nije uspelo (HTTP${rsp.status})`)
        })
    })
})
