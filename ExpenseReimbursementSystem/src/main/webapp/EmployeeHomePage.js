let user = {};

window.onload = function(){
    determineUser();
}

function determineUser(){
    fetch("http://localhost:8087/ExpenseReimbursementSystem/session").then(function(response){
        return response.json();
    }).then(function(data){
        user = data;
        document.getElementById("welcome").innerText = "Welcome " + user.firstName + " "+ user.lastName;

    })
}