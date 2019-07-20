let user = {};

window.onload = function(){
    determineUser();
}

function determineUser(){
    fetch("http://localhost:8087/ExpenseReimbursementSystem/session").then(function(response){
        return response.json();
    }).then(function(data){
        tableGenerator(data);
        user = data;
        document.getElementById("welcome").innerText = "Welcome " + user.firstName + " "+ user.lastName;

    })
}
function tableGenerator(data) {

    //Create a HTML Table element.
    let table = document.createElement("TABLE");
    table.border = "1";

    //Add the header row.
    let row = table.insertRow(-1);
    let headerCell = document.createElement("TH");
    
    headerCell = row.insertCell(-1);
    headerCell.innerHTML = "First Name";

    headerCell = row.insertCell(-1);
    headerCell.innerHTML = "Last Name";
    
    headerCell = row.insertCell(-1);
    headerCell.innerHTML = "Email";

    headerCell = row.insertCell(-1);
    headerCell.innerHTML = "Department";

 
    //Add the data rows.
    for (let i = 1; i < data.length; i++) {
        row = table.insertRow(-1);
        
       let cell = row.insertCell(-1);
        cell.innerHTML = "$"+data[i].firstName;

        cell = row.insertCell(-1);
        cell.innerHTML = data[i].lastName;

        cell = row.insertCell(-1);
        cell.innerHTML = data[i].email;

        cell = row.insertCell(-1);
        cell.innerHTML = data[i].departmentId;


    }
    
    //replace the empty div with a table 
    let newTable = document.getElementById("EmployeeTable");
    newTable.innerHTML = "";
    newTable.appendChild(table);
}