
//document.querySelectorAll('checkbox').forEach(element => {
//    element.addEventListener('click',myfunc)
//});
function action11() {
    let var1 = document.getElementById("table");
    let iter = document.getElementById("amountofrows").value;
    for(let j = 0; j < Number(iter); j++) {
        let tr = document.createElement("div");
        tr.className = "row";
        for (let i = 0; i < 2; i++) {
            let node = document.createTextNode("ewornw ioenraowenronewknfadsfsafd fdsafsdfsad dfdsafsadf fasf fd safsdfds sd niofnaefio neiofnioa");
            let td = document.createElement("div");
            td.className = "table_cell";
            td.appendChild(node);
            tr.appendChild(td);
        }
        let td = document.createElement("div");
        td.className = "table_cell";
        var number = document.createElement('input');
        number.type = "number";
        number.name = "number";
        number.value = "2";
        number.min ="1";
        number.max = "3";
        td.appendChild(number);
        tr.appendChild(td);
        var1.appendChild(tr);
        td = document.createElement("div");
        td.className = "table_cell";
        var date = document.createElement('input');
        date.type = "date";
        date.name = "date to be done";
        date.value = "2022-12-18";
        td.appendChild(date);
        tr.appendChild(td);
        var1.appendChild(tr);
        td = document.createElement("div");
        td.className = "table_cell";
        var checkbox = document.createElement('input');
        checkbox.type = "checkbox";
        checkbox.name = "Isdone";
        checkbox.value = "Is Done";
        checkbox.addEventListener("click", myfunc);
        td.appendChild(checkbox);
        tr.appendChild(td);
        var1.appendChild(tr);
       
    }
}
function myfunc(event){
    var id_res = "checkbox"+event;
    var res = document.getElementById(id_res);
    var row = res.parentNode.parentNode;
    if(res.checked){
        row.style.background = "green";
    }
    else{
        row.style.background = "";
    }
}