const registerForm = document.getElementById("card-form")

const cardnumberField = document.getElementById("cardnumber")
const firstnameField = document.getElementById("firstname")
const lastnameField = document.getElementById("lastname")
const expirydateField = document.getElementById("expirydate")
const cvvField = document.getElementById("cvv")
const phonenumberField = document.getElementById("phonenumber")
const addressline1Field = document.getElementById("addressline1")
const addressline2Field = document.getElementById("addressline2")
const postalcodeField = document.getElementById("postalcode")
const provinceField = document.getElementById("province")
const countryField = document.getElementById("country")

const formErrorMessage = document.getElementById("form-error-message")


registerForm.addEventListener("submit", onAddAttempt)

function onAddAttempt(event) {
    if (!loggedInUsername) {
        console.warn("Tried to add a card while not logged in!!")
    }
    event.preventDefault();
    const expiryDateReg = /(\d+)/g
    const expiryDateMatches = expirydateField.value.match(expiryDateReg)
    let expMonth = parseInt(expiryDateMatches[0])
    let expYear = 2000 + parseInt(expiryDateMatches[1])
    // We've already "added one" because months are zero-based, so just fix the year if necessary
    if (expMonth == 12) {
        expMonth = 0
        expYear += 1
    }
    const expiryDate = new Date(expYear, expMonth, 0)
    console.log(expiryDate)
    const card = {
        username: loggedInUsername,
        cardNumber: cardnumberField.value,
        firstName: firstnameField.value,
        lastName: lastnameField.value,
        expiryDate,
        cvv: cvvField.value,
        phoneNumber: phonenumberField.value,
        addressLineOne: addressline1Field.value,
        adressLineTwo: addressline2Field.value === "" ? null : addressline2Field.value,
        postalCode: postalcodeField.value,
        province: provinceField.value,
        country: countryField.value
    }
    addCard(card)
}

function addCard(card) {
    console.log("Attempting to add card", card)
    postAjax("http://localhost:8080/addPaymentMethod", card, (xmlhttp) => {
        console.log(xmlhttp.responseText)
        console.log(JSON.parse(xmlhttp.responseText))    
        window.location.replace('./portal.html')
    })
}