document.addEventListener('DOMContentLoaded', function(){

    const nav_elements = document.getElementsByClassName("nav-item");

    console.log(nav_elements);
    console.log("hola");

    for ( var i = 0; i < nav_elements.length; i++){
        nav_elements[i].addEventListener("click", function() {
            let current = document.getElementsByClassName("active");
            current[0].className = current[0].className.replace(" active", "");
            this.className+=" active";

        });
    }

});