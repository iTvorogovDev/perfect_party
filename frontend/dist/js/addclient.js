const registerForm = document.getElementById("register-form")

const usernameField = document.getElementById("username")
const passwordField = document.getElementById("password")
const confirmPasswordField = document.getElementById("confirm-password")
const firstnameField = document.getElementById("firstname")
const lastnameField = document.getElementById("lastname")
const emailField = document.getElementById("email")
const phonenumberField = document.getElementById("phonenumber")

const formErrorMessage = document.getElementById("form-error-message")



registerForm.addEventListener("submit", onRegisterAttempt)

function onRegisterAttempt(event) {
    event.preventDefault();
    if (!passwordsMatch()) {
        formErrorMessage.textContent = "Passwords don't match"
        return
    }
    const customer = {
        username: usernameField.value,
        userPassword: passwordField.value,
        firstName: firstnameField.value,
        lastName: lastnameField.value,
        emailAddress: emailField.value,
        phoneNumber: phonenumberField.value,
    }

    registerCustomer(customer)
}

function passwordsMatch() {
    return passwordField.value === confirmPasswordField.value
}

function registerCustomer(customer) {
    console.log("Attempting to register", customer)
    postAjax("http://localhost:8080/registerCustomer", customer, (xmlhttp) => {
        // if (xmlhttp.responseText == "[]") {
            setLoggedIn(customer.username);
            window.location.replace('./addcard.html')
        // }
    })
}