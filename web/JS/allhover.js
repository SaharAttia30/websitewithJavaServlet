const buttons = document.querySelectorAll('button');
for (var i = 0; i < buttons.length; i++){
    buttons[i].id = i+1;
    buttons[i].onmouseenter =  function(event){
        const old_color = event.target.style.background 
        event.target.style.background = "#5A5AAA";
        event.target.style.opacity = 0.7;
        event.target.onmouseleave = function(event) {
            event.target.style.background = old_color;
            event.target.style.opacity = 1;
        };
    };
}

