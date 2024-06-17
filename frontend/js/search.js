const searchInput = document.getElementById('search')
const Sparams = new URLSearchParams(window.location.search)
const searchParam = Sparams.get('search')

if (searchParam != null && searchParam !== '')
    searchInput.value = searchParam

searchInput.addEventListener('keypress', (e) => {
    if(e.key === 'Enter') doSearch()

})
document.getElementById('search-btn')
    .addEventListener('click', () => {
       doSearch()

    })
function doSearch() {
    if (searchInput.value === '') return
    window.location.href = `./teretana.html?search=${searchInput.value}`

}
function formatDate(iso) {
    if (iso == null) return 'N/A'
    return new Date(iso).toLocaleString('sr-RS')

  }