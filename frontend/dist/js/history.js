const historyContainer = document.querySelector(".history-container")

getBookingHistory();

function getBookingHistory() {
    postAjax("http://localhost:8080/getUserBookingHistory", {username: loggedInUsername}, (xmlhttp) => {
        if (xmlhttp.responseText == '[]') {
            historyContainer.textContent = "You have no past bookings!"
            return
        }
        const pastBookings = JSON.parse(xmlhttp.responseText)
        pastBookings.forEach(addBooking)
    })
}

function addBooking(booking) {
    console.log(booking)
    const bookingDiv = document.createElement("div")
    bookingDiv.classList.add("booking-item")

    const dateInfo = document.createElement("div")
    dateInfo.classList.add("date-info")

    const dateYMD = document.createElement("div")
    dateYMD.classList.add("date-ymd")
    dateYMD.textContent = new Date(booking.startDateTime).toLocaleDateString("en-US") 

    const dateTime = document.createElement("div")
    dateTime.classList.add("date-time")
    dateTime.textContent = new Date(booking.startDateTime).toLocaleTimeString("en-US", {hour: "numeric", minute:'2-digit'})
    dateTime.textContent += " to "
    dateTime.textContent += new Date(booking.endDateTime).toLocaleTimeString("en-US", {hour: "numeric", minute:'2-digit'})

    dateInfo.appendChild(dateYMD)
    dateInfo.appendChild(dateTime)

    const bookingInfo = document.createElement("div")
    bookingInfo.classList.add("booking-info")
    bookingInfo.textContent = booking.bookingType + " for " + booking.attendeesNumber;

    const venueInfo = document.createElement("div")
    venueInfo.classList.add("venue-info")

    const venueName = document.createElement("div")
    venueName.classList.add("venue-name")
    venueName.textContent = booking.venueName

    const venueAddress = document.createElement("div")
    venueAddress.classList.add("venue-address")
    venueAddress.textContent = booking.address

    venueInfo.appendChild(venueName)
    venueInfo.appendChild(venueAddress)
    
    bookingDiv.appendChild(dateInfo)
    bookingDiv.appendChild(bookingInfo)
    bookingDiv.appendChild(venueInfo)
    historyContainer.appendChild(bookingDiv)
}
