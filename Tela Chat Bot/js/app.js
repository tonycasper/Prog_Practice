//função do login
function Esconder(selected){
    var display = document.getElementById(selected).style.display;
    if(display == "none")
        document.getElementById(selected).style.display = 'block';
    else
        document.getElementById(selected).style.display = 'none';
}

// outra fita
$(function() {    
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
});
