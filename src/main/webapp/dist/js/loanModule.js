function getListOfLoanId() {
	const searchLoanId = document.getElementById("searchLoanId");
	$.ajax({
		type: "get",
		contentType: "application/json",
		url: 'getAllLoanId',
		asynch: false,
		success: function(data) {
			data.forEach(value => {
				const option = document.createElement('option')
				option.setAttribute('value', value.id);
				option.innerHTML = value.id
				searchLoanId.appendChild(option)
			})
		},
		error: function() {
			alert("Server not responsding");
		}
	});
}

function getByLoanId(type) {
	var searchLoanId = document.getElementById("searchLoanId1");
	var input = {
		"id": searchLoanId.value
	};

	fetch('getByLoanAppId', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(input)
	})
		.then(function(response) {
			if (response.ok) {
				return response.json();
			} else {
				throw new Error('Server not responding...');
			}
		})
		.then(function(data) {
			if (data.id != null) {
				document.getElementById("id").value = data.id;
			}
			if (data.loanDate != null) {
				document.getElementById("loanDate").value = data.loanDate;
			}

			if (data.searchMemberCode != null) {
				document.getElementById("searchMemberCode").value = data.searchMemberCode;
			}

			if (data.relativeDetails != null) {
				document.getElementById("relativeDetails").value = data.relativeDetails;
			}

			if (data.dob != null) {
				document.getElementById("DOB").value = data.dob;
			}

			if (data.age != null) {
				document.getElementById("age").value = data.age;
			}

			if (data.phoneno != null) {
				document.getElementById("phoneno").value = data.phoneno;
			}

			if (data.smsStatus != null) {
				document.getElementById("smsStatus").value = data.smsStatus;
			}

			if (data.address != null) {
				document.getElementById("address").value = data.address;
			}

			if (data.pin != null) {
				document.getElementById("pin").value = data.pin;
			}

			if (data.cspName != null) {
				document.getElementById("cspName").value = data.cspName;
			}

			if (data.loanName != null) {
				document.getElementById("loanName").value = data.loanName;
			}

			if (data.planTerm != null) {
				document.getElementById("planTerm").value = data.planTerm;
			}

			if (data.mode != null) {
				document.getElementById("mode").value = data.mode;
			}

			if (data.loanAmount != null) {
				document.getElementById("loanAmount").value = data.loanAmount;
			}

			if (data.roiType != null) {
				document.getElementById("roiType").value = data.roiType;
			}

			if (data.emiAmount != null) {
				document.getElementById("emiAmount").value = data.emiAmount;
			}

			if (data.loanPurpose != null) {
				document.getElementById("loanPurpose").value = data.loanPurpose;
			}

			if (data.guarantorCode !== null) {
				document.getElementById("guarantorCode").value = data.guarantorCode;
			}

			if (data.guarantorName != null) {
				document.getElementById("guarantorName").value = data.guarantorName;
			}

			if (data.addressGuarantor != null) {
				document.getElementById("addressGuarantor").value = data.addressGuarantor;
			}

			if (data.pincodeGuarantor != null) {
				document.getElementById("pincodeGuarantor").value = data.pincodeGuarantor;
			}

			if (data.guarantorphone != null) {
				document.getElementById("guarantorphone").value = data.guarantorphone;
			}

			if (data.securityType != null) {
				document.getElementById("securityType").value = data.securityType;
			}

			if (data.coApplicantCode != null) {
				document.getElementById("coApplicantCode").value = data.coApplicantCode;
			}

			if (data.memberRelativesName != null) {
				document.getElementById("memberRelativesName").value = data.memberRelativesName;
			}

			if (data.addressco != null) {
				document.getElementById("addressco").value = data.addressco;
			}

			if (data.pincodeco != null) {
				document.getElementById("pincodeco").value = data.pincodeco;
			}

			if (data.phoneco != null) {
				document.getElementById("phoneco").value = data.phoneco;
			}

			if (data.securityDetails != null) {
				document.getElementById("securityDetails").value = data.securityDetails;
			}

			if (data.processingFee != null) {
				document.getElementById("processingFee").value = data.processing
			}
			if (data.processingFee != null) {
				document.getElementById("processingFee").value = data.processingFee;

			}
			if (data.advisorCode != null) {
				document.getElementById("advisorCode").value = data.advisorCode;

			}
			if (data.gst != null) {
				document.getElementById("GST").value = data.gst;

			}
			if (data.insuranceAmt != null) {
				document.getElementById("insuranceAmt").value = data.insuranceAmt;

			} if (data.advisorName != null) {
				document.getElementById("advisorName").value = data.advisorName;

			}
			if (data.approvalDate != null && type!='payment') {
				document.getElementById("approvalDate").value = data.approvalDate;

			}
			if (data.approvalStatus != null&& type!='payment') {
				document.getElementById("approvalStatus").value = data.approvalStatus;

			}
		})
		.catch(function(error) {
			alert(error.message);
		});

}

function getByLoanIdRegularEmiRepayment() {
	var searchLoanId = document.getElementById("searchLoanId1");
	var input = {
		"id": searchLoanId.value
	};

	fetch('getByLoanIdRegularEmiRepayment', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(input)
	})
		.then(function(response) {
			if (response.ok) {
				return response.json();
			} else {
				throw new Error('Server not responding...');
			}
		})
		.then(function(data) {
			// Create a reference to the table
			var table = document.getElementById("loanTable");

			// Clear existing table rows
			while (table.rows.length > 1) {
				table.deleteRow(1);
			}

			// Iterate over the data and add rows to the table
			for (var key in data) {
				var row = table.insertRow();
				var fieldCell = row.insertCell(0);
				var valueCell = row.insertCell(1);
				if(fieldCell!=null){
					fieldCell.textContent = key;

				}
				if(valueCell!=null){
					valueCell.textContent = data[key];
				}
			}
		})
		.catch(function(error) {
			alert(error.message);
		});
}


function getByLoanIdIrRegularEmiRepayment() {
	var searchLoanId = document.getElementById("searchLoanId1");
	var input = {
		"id": searchLoanId.value
	};

	fetch('getByLoanIdIrregularEmiRepayment', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(input)
	})
		.then(function(response) {
			if (response.ok) {
				return response.json();
			} else {
				throw new Error('Server not responding...');
			}
		})
		.then(function(data) {
			// Create a reference to the table
			var table = document.getElementById("loanTable");

			// Clear existing table rows
			while (table.rows.length > 1) {
				table.deleteRow(1);
			}

			// Iterate over the data and add rows to the table
			for (var key in data) {
				var row = table.insertRow();
				var fieldCell = row.insertCell(0);
				var valueCell = row.insertCell(1);
				if(fieldCell!=null){
					fieldCell.textContent = key;

				}
				if(valueCell!=null){
					valueCell.textContent = data[key];
				}
			}
		})
		.catch(function(error) {
			alert("no data");
		});
}

function getRegularLoanData() {
	var searchLoanId = document.getElementById("searchLoanId1");
	var input = {
		"id": searchLoanId.value
	};

	fetch('getByLoanAppId', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(input)
	})
		.then(function(response) {
			if (response.ok) {
				return response.json();
			} else {
				throw new Error('Server not responding...');
			}
		})
		.then(function(data) {
			if (data.id != null) {
				document.getElementById("id").value = data.id;
			}
			if (data.loanDate != null) {
				document.getElementById("loanDate").value = data.loanDate;
			}
			if (data.loanPlanName != null) {
				document.getElementById("loanName").value = data.loanPlanNameView;
			}
			//planTerm
			if (data.planTerm != null) {
				document.getElementById("planTerm").value = data.planTerm;
			}else{
				document.getElementById("planTerm").value = "";
			}
			//roiType
			if (data.roiType != null) {
				document.getElementById("roiType").value = data.roiType;
			}else{
				document.getElementById("roiType").value = "";
			}
			//emiAmount
			if (data.emiAmount != null) {
				document.getElementById("emiAmount").value = data.emiAmount;
			}else{
				document.getElementById("emiAmount").value = "";
			}
			//totalInterest
			if (data.totalInterest != null) {
				document.getElementById("totalInterest").value = data.totalInterest;
			}else{
				document.getElementById("totalInterest").value = "";
			}
			//totalPrinciple
			if (data.totalPrinciple != null) {
				document.getElementById("totalPrinciple").value = data.totalPrinciple;
			}else{
				document.getElementById("totalPrinciple").value = "";
			}
			//totalPayble
			if (data.totalPayble != null) {
				document.getElementById("totalPayble").value = data.totalPayble;
			}else{
				document.getElementById("totalPayble").value = "";
			}
			//totalInterestDue
			if (data.totalInterestDue != null) {
				document.getElementById("totalInterestDue").value = data.totalInterestDue;
			}else{
				document.getElementById("totalInterestDue").value = "";
			}
			//totalPrincipleDue
			if (data.totalPrincipleDue != null) {
				document.getElementById("totalPrincipleDue").value = data.totalPrincipleDue;
			}else{
				document.getElementById("totalPrincipleDue").value = "";
			}
			//totalDueAmt
			if (data.totalDueAmt != null) {
				document.getElementById("totalDueAmt").value = data.totalDueAmt;
			}else{
				document.getElementById("totalDueAmt").value = "";
			}
			//dueDate
			if (data.dueDate != null) {
				document.getElementById("dueDate").value = data.dueDate;
			}else{
				document.getElementById("dueDate").value = "";
			}
			//cspName
			if (data.cspName != null) {
				document.getElementById("cspName").value = data.cspName;
			}else{
				document.getElementById("cspName").value = "";
			}
			//advancePaid
			if (data.advancePaid != null) {
				document.getElementById("advancePaid").value = data.advancePaid;
			}else{
				document.getElementById("advancePaid").value = "";
			}
			//paymentDate
			if (data.paymentDate != null) {
				document.getElementById("paymentDate").value = data.paymentDate;
			}else{
				document.getElementById("paymentDate").value = "";
			}
			//deductLateFine
			if (data.deductLateFine != null) {
				document.getElementById("deductLateFine").value = data.deductLateFine;
			}else{
				document.getElementById("deductLateFine").value = "";
			}
			//payableAmount
			if (data.payableAmount != null) {
				document.getElementById("payableAmount").value = data.payableAmount;
			}else{
				document.getElementById("payableAmount").value = "";
			}
			//totalPayableAmt
			if (data.totalPayableAmt != null) {
				document.getElementById("totalPayableAmt").value = data.totalPayableAmt;
			}else{
				document.getElementById("totalPayableAmt").value = "";
			}
			
			//paymode
			if (data.paymode != null) {
				document.getElementById("paymode").value = data.paymode;
			}else{
				document.getElementById("paymode").value = "";
			}
			
			//advisorName
			if (data.advisorName != null) {
				document.getElementById("advisorName").value = data.paymode;
			}else{
				document.getElementById("advisorName").value = "";
			}
			//remarks
				if (data.remarks != null) {
				document.getElementById("remarks").value = data.remarks;
			}else{
				document.getElementById("remarks").value = "";
			}
			//
			
			

			
		})
		.catch(function(error) {
			alert(error.message);
		});

}

function getByNoc(){
	alert("no data")
}