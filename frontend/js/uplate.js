document.addEventListener('DOMContentLoaded', () => {
    const table = document.getElementById("table-uplate")
    const template = document.getElementById("Uplata")


    fetchUplate()

    function fetchUplate() {
        fetch(`http://localhost:8080/api/uplate`)
            .then((rsp) => {
                if (!rsp.ok) {
                    throw new Error(`Server error: ${rsp.status} ${rsp.statusText}`)
                }
                return rsp.json()
            })
            .then((data) => {
                if (!Array.isArray(data)) {
                    throw new Error("Received data is not an array")
                }
                if (data.length === 0) {
                    alert("Nema dostupnih uplata")
                    return
                }
                data.forEach((uplata) => {
                    const copy = template.content.cloneNode(true)
                    copy.querySelector(".name").innerText = uplata.clan.ime
                    copy.querySelector(".surname").innerText = uplata.clan.prezime
                    copy.querySelector(".amount").innerText = uplata.iznos
                    copy.querySelector(".date").innerText = formatDate(uplata.datumUplate)
                    table.appendChild(copy)
                })
            })
            .catch((error) => {
                console.error('Error:', error)
                alert(`Error: ${error.message}`)
            })
    }

    function formatDate(iso) {
        if (iso == null) return 'N/A'
        return new Date(iso).toLocaleDateString('sr-RS')
    }
})
