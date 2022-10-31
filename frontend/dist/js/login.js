const loginForm = document.getElementById("login-form")
const formErrorMessage = document.getElementById("form-error-message")

loginForm.addEventListener("submit", onLoginAttempt)

function onLoginAttempt(event) {
    event.preventDefault();
    const username = document.getElementById("username").value
    const password = document.getElementById("password").value
    checkUserLogin({ username, userPassword: password });
}

function checkUserLogin(login) {

    console.log("Checking: ", login)
    postAjax("http://localhost:8080/userLogin", login, (xmlhttp) => {
        if (xmlhttp.responseText == "[]") {
            formErrorMessage.textContent = "No user with that username and password!"
        } else {
            customerAccount = JSON.parse(xmlhttp.responseText)[0]
            setLoggedIn(customerAccount.username);
            window.location.replace('./portal.html')
        }
    })
}