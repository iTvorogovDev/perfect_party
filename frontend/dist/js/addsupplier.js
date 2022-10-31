const form = document.getElementById("register-form")

const supplierField = document.getElementById("suppliername")

const formErrorMessage = document.getElementById("form-error-message")

form.addEventListener("submit", onRegisterAttempt)

function onRegisterAttempt(event) {
    event.preventDefault();
    const item = {
        supplierName: supplierField.value,
    }

    registerCustomer(item)
}

function registerCustomer(event) {
    console.log("Attempting to add supplier", event)
    postAjax("http://localhost:8080/addSupplier", event, (xmlhttp) => {
        // if (xmlhttp.responseText == "[]") {
            window.location.replace('./employeehome.html')
        // }
    })
}