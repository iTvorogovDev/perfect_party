const form = document.getElementById("register-form")
 
const typeField = document.getElementById("type")
const usernameField = document.getElementById("username")
const startdatetimeField = document.getElementById("startdatetime")
const enddatetimeField = document.getElementById("enddatetime")
const venueField = document.getElementById("venueid")
const attendeesField = document.getElementById("attendees")

const formErrorMessage = document.getElementById("form-error-message")

form.addEventListener("submit", onRegisterAttempt)

getVenueListing()

function onRegisterAttempt(event) {
    event.preventDefault();
    const booking = {
        bookingType: typeField.value,
        username: usernameField.value,
        startDateTime: startdatetimeField.value,
        endDateTime: enddatetimeField.value,
        venueId: venueField.value,
        attendeesNumber: attendeesField.value,
    }

    registerCustomer(booking)
}

function getVenueListing() {
    console.log("Attempting to get venue list", event)
    postAjax("http://localhost:8080/getVenueTable", null, (xmlhttp) => {
        if (xmlhttp.responseText == "[]") {
            console.warn("Something went wrong - got empty response")
            return []
            // window.location.replace('./employeehome.html')
        }
        const venueTable = JSON.parse(xmlhttp.responseText)
        venueTable.forEach((venue, index) => {
            venueField.options[index] = new Option(venue.venueName, venue.venueId)
        })
    })
}

function registerCustomer(booking) {
    console.log("Attempting to add event", booking)
    postAjax("http://localhost:8080/addBooking", booking, (xmlhttp) => {
        // if (xmlhttp.responseText == "[]") {
            window.location.replace('./employeehome.html')
        // }
    })
}