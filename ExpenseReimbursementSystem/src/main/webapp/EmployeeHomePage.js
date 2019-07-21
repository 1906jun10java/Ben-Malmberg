window.onload = function() {
	determineUser();
	document.getElementById('viewInfo').addEventListener('click',tableGenerator);
	document.getElementById('viewRequests').addEventListener('click',getReqeusts);
	document.getElementById('requestsByDpt').addEventListener('click',pendingManagerTableGenerator);
}

const URL = "http://localhost:8087/ExpenseReimbursementSystem/viewRequests";

function determineUser() {
	fetch("http://localhost:8087/ExpenseReimbursementSystem/session").then(
			function(response) {
				let data = response.json();
				return data;
			}).then(
			function(data) {
				document.getElementById("welcome").innerText = "Welcome "
						+ data.firstName + " " + data.lastName;
				return data;
			})
}

function getReqeusts() {
	fetch(URL).then(function(response) {
		let data1 = response.json();
		return data1;
	}).then(function(data1) {
		rTableGenerator(data1);
	})
}

function tableGenerator() {
	fetch("http://localhost:8087/ExpenseReimbursementSystem/session").then(
			function(response) {
				let data = response.json();
				return data;
			}).then(function(data) {

		// Create a HTML Table element.
		let table = document.createElement("TABLE");
		table.border = "1";

		// Add the header row.
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

		// Add the data rows.
		row = table.insertRow(-1);

		let cell = row.insertCell(-1);
		cell.innerHTML = data.firstName;

		cell = row.insertCell(-1);
		cell.innerHTML = data.lastName;

		cell = row.insertCell(-1);
		cell.innerHTML = data.email;

		cell = row.insertCell(-1);
		cell.innerHTML = data.departmentId;

		// replace the empty div with a table
		let newTable = document.getElementById("EmployeeTable");
		newTable.innerHTML = "";
		newTable.appendChild(table);
	})
}

function rTableGenerator(data1) {

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
	for (let i = 1; i < data1.length; i++) {
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

	// replace the empty div with a table
	let newTable = document.getElementById("makeMeATable");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}

function pendingManagerTableGenerator() {
	fetch("http://localhost:8087/ExpenseReimbursementSystem/managerRequestsByDpt").then(
			function(response) {
				let data = response.json();
				return data;
			}).then(function(data) {
				
		console.log(data);
		// Create a HTML Table element.
		let table = document.createElement("TABLE");
		table.border = "1";

		// Add the header row.
		let row = table.insertRow(-1);
		let headerCell = document.createElement("TH");

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "EmployeeId";
		
		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Dollar Amount";

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Reason";

		headerCell = row.insertCell(-1);
		headerCell.innerHTML = "Status";

		// Add the data rows.
		for (let i = 1; i < data.length; i++) {
			row = table.insertRow(-1);

			let cell = row.insertCell(-1);
			cell.innerHTML = data[i].employeeId;
			
			cell = row.insertCell(-1);
			cell.innerHTML = "$" + data[i].dollarAmount;

			cell = row.insertCell(-1);
			cell.innerHTML = data[i].reason;

			cell = row.insertCell(-1);
			if (data[i].status === 1) {
				cell.innerHTML = "Pending";
			} else if (data1[i].status === 2) {
				cell.innerHTML = "Approved";
			} else {
				cell.innerHTML = "Denied";
			}
			let acceptButton = document.createElement("BUTTON");
			acceptButton.type="submit";
			acceptButton.value =data[i].reimbursementId;
			acceptButton.innerHTML="ApproveReimbursement";
			acceptButton.id="accept";
			//let rejectButton = document.createElement("BUTTON");
			row.appendChild(acceptButton);
		}

		// replace the empty div with a table
		let newTable = document.getElementById("managerViewdpt");
		newTable.innerHTML = "";
		newTable.appendChild(table);
	})
}
