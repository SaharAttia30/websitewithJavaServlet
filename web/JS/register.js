function myfun(){
    const tems = document.getElementById("terms");
    
    const button11 = document.getElementsByClassName("mybutt11");
    if(tems.checked){
        button11[0].disabled =  false;
    }
    else{
        button11[0].disabled =  true;
    }
}
function login(){
    
    const tems = document.getElementById("terms");
    const email = document.getElementById("uname").value;
    const passwd = document.getElementById("psw").value;
    if(! email.includes(".com") || ! email.includes("@")){
        alert("Email is wrong, doesnt contain '.com' or '@'");
    }
    if(passwd.length < 6){
        alert("passwd must be at least 6 characters");
    }
    if(! terms.checked){
        alert("You Must Accept Terms and Conditions");
    }
}

