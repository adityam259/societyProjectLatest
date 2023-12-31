<%@page import="com.society.application.model.BranchMaster"%>
<%@page import="java.util.List"%>
<%@page import="com.society.application.model.LoanMaster"%>
<jsp:include page="../header.jsp" />
 <style>
    table {
      border-collapse: collapse;
      width: 100%;
    }

    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
  </style>
<body onload="getListOfLoanId()" class="skin-blue sidebar-mini"
	style="height: auto; min-height: 100%; background-color: rgba(36, 105, 92, 0.15);"
	cz-shortcut-listen="true">
	<div
		style="height: auto; min-height: 100%; border-radius: 30px; margin: 15px; background: url(dist/img/back.jpg);">
		<!-- Header Start-->
		<jsp:include page="../menu.jsp" />
		<!-- Header End -->
		<!-- Left side column. contains the logo and sidebar -->
		<!-- Aside Menu Start-->
		<jsp:include page="../asideMenu.jsp" />
		<!-- Aside Menu end -->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 1105.75px;">
			<section class="content-header">
				<h1 id="ContentPlaceHolder1_IdHeader">Gold Loan Search</h1>
				<ol class="breadcrumb">
					<li><a href="Home.html"><i class="fa fa-dashboard"></i>Home</a></li>
					<li><a href="#">Dashboard</a></li>
					<li class="active">Search</li>
				</ol>
			</section>
			<%
					List<BranchMaster> branchList = (List<BranchMaster>) request.getAttribute("branchList");
				%>
			<%
				List<LoanMaster> loanMasterList = (List<LoanMaster>) request.getAttribute("loanPlanMaster");
				%>
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-success">
							<div class="box-header with-border">
								<h3 class="box-title">Search Box</h3>
							</div>
							<div class="box-body">
								<div class="col-md-3">
									<div class="form-group">
										<label>Branch :</label> <select name="branch" id="branch"
											class="form-control select2" style="width: 100%;">
											<%
													if (branchList != null && !branchList.isEmpty()) {
														for (BranchMaster branch : branchList) {
													%>
											<option value="<%=branch.getId()%>"><%=branch.getName()%></option>
											<%
													}
													}%>
										</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>From Date :</label>
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input name="fDate" type="text" value="01/08/2022" id="fDate"
												class="form-control"
												data-inputmask="&#39;alias&#39;: &#39;dd/mm/yyyy&#39;"
												data-mask="" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>To Date :</label>
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input name="tDate" type="text" value="01/08/2022" id="tDate"
												class="form-control"
												data-inputmask="&#39;alias&#39;: &#39;dd/mm/yyyy&#39;"
												data-mask="" />
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Applicant Name :</label> <input name="applicantName"
											type="text" id="applicantName" class="form-control"
											Placeholder="Enter Applicant Name" autocomplete="off" />
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Loan ID :</label> <input name="loanID" type="text"
											id="loanID" class="form-control" Placeholder="Enter Loan ID"
											autocomplete="off" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Member Code :</label> <input name="memberCode"
											type="text" id="memberCode" class="form-control"
											Placeholder="Enter Member Code" autocomplete="off" />
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Plan Name :</label> <select name="planName"
											id="planName" class="form-control" style="width: 100%;">
											<%
														if (loanMasterList != null && !loanMasterList.isEmpty()) {
															for (LoanMaster loanPlan : loanMasterList) {
														%>
											<option value="<%=loanPlan.getId()%>"><%=loanPlan.getLoanName()%></option>
											<%
														}
														}
														%>
										</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label>Advisor Code :</label> <input name="advisorCode"
											type="text" id="advisorCode" class="form-control"
											Placeholder="Enter Advisor Code" autocomplete="off" />
									</div>
								</div>
								<div class="clearfix margin-bottom-10"></div>
								<div class="text-center">
									<a id="btnSearch" class="btn btn-success"
										href="javascript:sendFormData()"><span
										class="fa fa-search"></span> SEARCH</a> <a id="btnPrint"
										class="btn btn-warning"><span class="fa fa-print"></span>
										PRINT</a>
								</div>
							</div>
						</div>
						<div class="box box-success"
							style="box-shadow: none; overflow: auto !important;">
							<div class="box-header with-border">
								<h3 class="box-title">Search Result</h3>
								<div class="box-tools pull-right"></div>
							</div>
							<div class="box-body">
								<div class="clearfix margin-bottom-10"></div>
								  <table id="responseTable"></table>

							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- /.content-wrapper -->
		<div class="control-sidebar-bg"></div>
	</div>

	<script src="bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- InputMask -->
	<script src="plugins/input-mask/jquery.inputmask.js"></script>
	<script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<!-- date-range-picker -->
	<script src="bower_components/moment/min/moment.min.js"></script>
	<script
		src="bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap datepicker -->
	<script
		src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<!-- bootstrap color picker -->
	<script
		src="bower_components/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
	<!-- bootstrap time picker -->
	<script src="plugins/timepicker/bootstrap-timepicker.min.js"></script>
	<!-- SlimScroll -->
	<script
		src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- iCheck 1.0.1 -->
	<script src="plugins/iCheck/icheck.min.js"></script>
	<!-- FastClick -->
	<script src="bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="dist/js/demo.js"></script>
	<!-- Select2 -->
	<script src="bower_components/select2/dist/js/select2.full.min.js"></script>

	<script>
		function sendFormData() {
			  var branch = document.getElementById("branch").value;
			  var fDate = document.getElementById("fDate").value;
			  var tDate = document.getElementById("tDate").value;
			  var applicantName = document.getElementById("applicantName").value;
			  var loanID = document.getElementById("loanID").value;
			  var memberCode = document.getElementById("memberCode").value;
			  var planName = document.getElementById("planName").value;
			  var advisorCode = document.getElementById("advisorCode").value;
			  var url = 'searchLoanByCode'; // Replace with the actual URL of your Spring controller
			  var data = {
					    branch: branch,
					    fDate: fDate,
					    tDate: tDate,
					    applicantName: applicantName,
					    loanID: loanID,
					    memberCode: memberCode,
					    planName: planName,
					    advisorCode: advisorCode,
					  };
			  console.log(JSON.stringify(data));
			  var requestOptions = {
					    method: 'POST',
					    headers: {
					      'Content-Type': 'application/json'
					    },
					    body: JSON.stringify(data)
					  };
					  
					  fetch(url, requestOptions)
					    .then(function(response) {
					      if (response.ok) {
					        return response.json();
					      } else {
					        throw new Error('Error: ' + response.status);
					      }
					    })
					    .then(function(data) {
					      displayResponseData(data);
					    })
					    .catch(function(error) {
					      console.error(error);
					    });
					}

					function displayResponseData(data) {
					  var table = document.getElementById("responseTable");
					  table.innerHTML = ''; // Clear the table
					  console.log("data = "+data);
					  // Create table headers
					  var headers = ['Branch', 'Date', 'Applicant Name', 'Loan ID', 'Member Code'];
					  var headerRow = table.insertRow();
					  headers.forEach(function(header) {
					    var cell = headerRow.insertCell();
					    cell.textContent = header;
					  });
					  
					  // Create table rows with data
					  data.forEach(function(rowData) {
					    var row = table.insertRow();
					    
					    var values = [rowData.cspName, rowData.loanDate, rowData.searchMemberCode, rowData.id];
					    values.forEach(function(value) {
					      var cell = row.insertCell();
					      cell.textContent = value;
					    });
					  });
					}
		</script>
</body>
</html>
