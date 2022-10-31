const venueDisplayTable = document.getElementById("event-table")

getVenueListing()

function getVenueListing() {
    console.log("Attempting to get event list", event)
    postAjax("http://localhost:8080/getBookingTable", null, (xmlhttp) => {
        if (xmlhttp.responseText == "[]") {
            console.warn("Something went wrong - got empty response")
            return []
            // window.location.replace('./employeehome.html')
        }
        const venueTable = JSON.parse(xmlhttp.responseText)
        venueTable.forEach((venue, index) => {
            const row = document.createElement("tr")
            Object.keys(venue).forEach(function(key,index) {
                const entry = document.createElement("td")
                entry.textContent = venue[key]
                row.appendChild(entry)
            });            
            venueDisplayTable.appendChild(row)    
        })
    })
}