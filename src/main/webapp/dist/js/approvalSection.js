/* MEMBER APPROVAL */
function getMemberApproval() {
    var input = {
        branchName: document.getElementById("branchName").value,
        fDate: document.getElementById("fDate").value,
        tDate: document.getElementById("tDate").value,
    };
	//console.log("Input:", input);
    const myJson = JSON.stringify(input);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        data: myJson,
        url: 'memberApproval',
        async: false,
        success: function (data) {
            var tableData = "";
            for (let i = 0; i < data.length; i++) {
                const value = data[i];
                var j = i + 1;
                tableData += `<tr>
                    <td>${j}</td>
                    <td>${value.memberName}</td>
                    <td>${value.dob}</td>
                    <td>${value.age}</td>
                    <td>${value.gender}</td>
                    <td>${value.address}</td>
                    <td>${value.education}</td>
                    <td>${value.aadharNo}</td>
                    <td>${value.pan}</td>
                    <td>${value.phoneno}</td>
                    <td>${value.emailid}</td>
                    <td>${value.branchName}</td>
                </tr>`;
            }
            const tableBody = document.querySelector("#tableBody");
            tableBody.innerHTML = tableData;
        },
        error: function () {
            alert("Failed to retrieve data");
        },
    });
}

/* SHARE APPROVAL */
function getShareApproval() {
    var input = {
        branchName: document.getElementById("branchName").value,
        fDate: document.getElementById("fDate").value,
        tDate: document.getElementById("tDate").value,
    };
	//console.log("Input:", input);
    const myJson = JSON.stringify(input);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        data: myJson,
        url: 'shareApproval',
        async: false,
        success: function (data) {
            var tableData = "";
            for (let i = 0; i < data.length; i++) {
                const value = data[i];
                var j = i + 1;
                tableData += `<tr>
                    <td>${j}</td>
                    <td>${value.memberName}</td>
                    <td>${value.doj}</td>
                    <td>${value.noOfShare}</td>
                    <td>${value.previousShare}</td>
                    <td>${value.transferAmount}</td>
                    <td>${value.sharebalance}</td>
              		<td>${value.paymode}</td>
              		<td>${value.remarks}</td>
                </tr>`;
            }
            const tableBody = document.querySelector("#tableBody");
            tableBody.innerHTML = tableData;
        },
        error: function () {
            alert("Failed to retrieve data");
        },
    });
}

/* ADVISOR/COLLECTOR APPROVAL */
function getAdvisorApproval() {
  var input = {
    branchName: document.getElementById("branchName").value,
    fDate: document.getElementById("fDate").value,
    tDate: document.getElementById("tDate").value,
  };
  //console.log("Input:", input);
  $.ajax({
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(input),
    url: '/advisorApproval',
    success: function (data) {
      var tableData = "";
      for (let i = 0; i < data.length; i++) {
        const value = data[i];
        var j = i + 1;
        tableData += `<tr>
          <td>${j}</td>
          <td>${value.memberName}</td>
          <td>${value.dob}</td>
          <td>${value.age}</td>
          <td>${value.address}</td>
          <td>${value.education}</td>
          <td>${value.mobileNo}</td>
          <td>${value.occupation}</td>
          <td>${value.joiningDate}</td>
          <td>${value.paymentBy}</td>
        </tr>`;
      }
      const tableBody = document.querySelector("#tableBody");
      tableBody.innerHTML = tableData;

      // Additional code to handle when no data is returned
      if (data.length === 0) {
        tableBody.innerHTML = "<tr><td colspan='10'>No data found.</td></tr>";
      }
    },
    error: function () {
      alert("Failed to retrieve data");
    },
  });
}

/* BRANCH CASH TRANSFER APPROVAL */
function getCSPCashTransferApproval(){
    var input = {
        branchName: document.getElementById("branchName").value,
        fromDate: document.getElementById("fromDate").value,
        toDate: document.getElementById("toDate").value,
    };
	console.log("Input:", input);
    const myJson = JSON.stringify(input);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        data: myJson,
        url: 'cspCashTransferApproval',
        async: false,
        success: function (data) {
            var tableData = "";
            for (let i = 0; i < data.length; i++) {
                const value = data[i];
                var j = i + 1;
                tableData += `<tr>
                    <td>${j}</td>
                    <td>${value.ledgerName}</td>
                    <td>${value.memberCode}</td>
                    <td>${value.accountNo}</td>
                    <td>${value.payment}</td>
                    <td>${value.received}</td>
                    <td>${value.section}</td>
                    <td>${value.txnDate}</td>
                </tr>`;
            }
            const tableBody = document.querySelector("#tableBody");
            tableBody.innerHTML = tableData;
        },
        error: function () {
            alert("Failed to retrieve data");
        },
    });
}