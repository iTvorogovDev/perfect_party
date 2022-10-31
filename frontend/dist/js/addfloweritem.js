const form = document.getElementById("register-form")

const supplierField = document.getElementById("supplierid")
const nameField = document.getElementById("itemname")
const descriptionField = document.getElementById("itemdescription")
const startdatetimeField = document.getElementById("startdatetime")
const enddatetimeField = document.getElementById("enddatetime")
const priceField = document.getElementById("price")

const formErrorMessage = document.getElementById("form-error-message")

form.addEventListener("submit", onRegisterAttempt)

getSupplierListing()

function onRegisterAttempt(event) {
    event.preventDefault();
    const item = {
        supplierId: supplierField.value,
        itemType: "FlowerArrangement",
        itemName: nameField.value,
        itemDescription: descriptionField.value,
        price: priceField.value
    }

    registerCustomer(item)
}

function getSupplierListing() {
    console.log("Attempting to get supplier list", event)
    postAjax("http://localhost:8080/getSupplierTable", null, (xmlhttp) => {
        if (xmlhttp.responseText == "[]") {
            console.warn("Something went wrong - got empty response")
            return
            // window.location.replace('./employeehome.html')
        }
        const supplierTable = JSON.parse(xmlhttp.responseText)
        supplierTable.forEach((supplier, index) => {
            supplierField.options[index] = new Option(supplier.supplierName, supplier.supplierId)
        })
    })
}

function registerCustomer(event) {
    console.log("Attempting to add FlowerArrangement", event)
    postAjax("http://localhost:8080/addFlowerArrangement", event, (xmlhttp) => {
        // if (xmlhttp.responseText == "[]") {
            window.location.replace('./employeehome.html')
        // }
    })
}