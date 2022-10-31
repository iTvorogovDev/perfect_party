const form = document.getElementById("register-form")

const nameField = document.getElementById("venuename")
const addressField = document.getElementById("venueaddress")
const typeField = document.getElementById("type")
const capacityField = document.getElementById("capacity")
const starttimeField = document.getElementById("starttime")
const endtimeField = document.getElementById("endtime")

const formErrorMessage = document.getElementById("form-error-message")

form.addEventListener("submit", onRegisterAttempt)

function onRegisterAttempt(event) {
    event.preventDefault();
    const item = {
        venueName: nameField.value,
        address: addressField.value,
        buildingType: typeField.value,
        capacity: capacityField.value,
        operationStartTime: starttimeField.value.concat(":00"),
        operationEndTime: endtimeField.value.concat(":00"),
    }

    registerCustomer(item)
}

function registerCustomer(event) {
    console.log("Attempting to add venue", event)
    postAjax("http://localhost:8080/addVenue", event, (xmlhttp) => {
        // if (xmlhttp.responseText == "[]") {
            window.location.replace('./employeehome.html')
        // }
    })
}