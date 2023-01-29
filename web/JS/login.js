function login(){
    const email = document.getElementById("uname").value;
    const passwd = document.getElementById("psw").value;
    if(! email.includes(".com") || passwd.length < 6 ){
        alert("Email or password are wrong");
    }
}
