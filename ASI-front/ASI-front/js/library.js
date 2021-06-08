
function setCookie(name,value,days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}
function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}
function eraseCookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function loginCheck() {
    if (getCookie('token') == null) {
        $(location).attr('href', '/public/index.html');
    } else {
        var formData = {
            "token": getCookie("token")
        }
        $.ajax({
            type: "POST",
            url: "/user/login-check",
            data: JSON.stringify(formData),
            dataType: "json",
            contentType: 'application/json'
        }).done(function (data) {
            if (data) {
                return true
            } else {
                $(location).attr('href', '/index.html');
            }
        });
    }
}


function getUser() {
    if (getCookie('token') == null) {
        $(location).attr('href', '/public/index.html');
    } else {
        var formData = {
            "token": getCookie("token")
        }
        $.ajax({
            type: "POST",
            url: "/user/token",
            data: JSON.stringify(formData),
            dataType: "json",
            contentType: 'application/json'
        }).done(function (data) {
            if (data) {
                $("#userUsername")[0].innerHTML = data['username'];
                $("#userWallet")[0].innerHTML = data['walletAmount'];
            }
        });
    }
}

function getUserData() {
    if (getCookie('token') == null) {
        $(location).attr('href', '/public/index.html');
    } else {
        var formData = {
            "token": getCookie("token")
        }
        var user;
        $.ajax({
            type: "POST",
            url: "/user/token",
            data: JSON.stringify(formData),
            dataType: "json",
            contentType: 'application/json'
        }).done(function (data) {
            if (data) {
                console.log(data);
                user = data;
            }
        });

        return user;
    }
}