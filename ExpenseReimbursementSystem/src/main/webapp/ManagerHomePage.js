let id = null;
window.onload = function() {
    determineUser();
    getReqeusts();
}
function determineUser() {
	fetch("http://localhost:8087/ExpenseReimbursementSystem/session").then(
		function(response) {
			let data = response.json();
			return data;
		}).then(
		function(data) {
			document.getElementById("welcome").innerText = "Welcome "+ data.firstName + " " + data.lastName;
            id = data;
            return data;
	})
}

const URL = "http://localhost:8087/ExpenseReimbursementSystem/viewRequests";
function getReqeusts() {
	fetch(URL).then(function(response) {
		let data1 = response.json();
		return data1;
	}).then(function(data1) {
		rTableGenerator(data1);
	})
}

function rTableGenerator(data1) {

	console.log(data1);
	// Create a HTML Table element.
	let table = document.createElement("TABLE");
	table.border = "1";

	// Add the header row.
	let row = table.insertRow(-1);
	let headerCell = document.createElement("TH");

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Dollar Amount";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Reason";

	headerCell = row.insertCell(-1);
	headerCell.innerHTML = "Status";

	// Add the data rows.
	for (let i = 0; i < data1.length; i++) {
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = "$" + data1[i].dollarAmount;

		cell = row.insertCell(-1);
		cell.innerHTML = data1[i].reason;

		cell = row.insertCell(-1);
		if (data1[i].status === 1) {
			cell.innerHTML = "Pending";
		} else if (data1[i].status === 2) {
			cell.innerHTML = "Approved";
		} else {
			cell.innerHTML = "Denied";
		}
    }
    console.log("doing stuff");
	// replace the empty div with a table
	let newTable = document.getElementById("makeMeATable");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}