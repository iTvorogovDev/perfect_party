const loggedOutNavLinks = document.querySelectorAll(".logged-out")
const loggedInNavLinks = document.querySelectorAll(".logged-in")
const signOutLink = document.getElementById("sign-out")

if (signOutLink != null) {
    signOutLink.addEventListener("click", onSignOut)
}

let loggedInUsername = "";

function getLoggedInFromCookie() {
    loggedInUsername = getCookie("loggedIn");
}

function setLoggedIn(newloginUsername) {
    loggedInUsername = newloginUsername
    setCookie("loggedIn", newloginUsername, 2)
    updateNavLinks()
}

function updateNavLinks() {
    if (!!loggedInUsername) {
        loggedOutNavLinks.forEach(item => item.style.display = "none")
        loggedInNavLinks.forEach(item => item.style.display = "inline-block")
    } else {
        loggedOutNavLinks.forEach(item => item.style.display = "inline-block")
        loggedInNavLinks.forEach(item => item.style.display = "none")
    }
}

function doLoggedInRedirect() {
    if (!!loggedInUsername && window.location.pathname.split("/").slice(-1)[0] === "index.html") {
        window.location.replace('./portal.html')
    }
}

getLoggedInFromCookie()
doLoggedInRedirect()
updateNavLinks()

function onSignOut(event) {
    setLoggedIn("")
    window.location.replace('./index.html')
}

/* Cookie Functions */

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

/* HTTP Request Functions */

function postAjax(url, data, success) {
    const xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
    xmlhttp.open("POST", url);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    if (data == null || data == undefined) {
        xmlhttp.send();   
        console.log("sending empty") 
    } else {
        console.log("sending", data)
        xmlhttp.send(JSON.stringify(data));
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState > 3 && xmlhttp.status == 200) {
            success(xmlhttp); 
        }
    };
    return xmlhttp;
}