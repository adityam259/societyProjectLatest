<jsp:include page="../header.jsp" />
<%@page import="java.util.List"%>
<%@page import="com.society.application.model.GroupMaster"%>
<%@page import="com.society.application.model.BranchMaster"%>
<body class="skin-blue sidebar-mini"
	style="height: auto; min-height: 100%; background-color: rgba(36, 105, 92, 0.15);"
	cz-shortcut-listen="true">
	<form method="post"
		action="http://admin:eqfi%23123@eqfinidhi.eadmin.in/Admin/GoldLoanSearch.aspx"
		id="form1">
<%
				List<GroupMaster> allGroupMaster = (List<GroupMaster>) request.getAttribute("allGroupMaster");
				%>
				<%
				List<BranchMaster> branchListList = (List<BranchMaster>) request.getAttribute("branchList");
				%>
		<div
			style="height: auto; min-height: 100%; border-radius: 30px; margin: 15px; background: url(dist/img/back.jpg);">
			<!-- Header Start-->
			<jsp:include page="../menu.jsp" />
			<!-- Header End -->
			<!-- Left side column. contains the logo and sidebar -->
			<!-- Aside Menu Start-->
			<jsp:include page="../asideMenu.jsp" />
			<!-- Aside Menu end -->
			<script type="text/javascript">
//<![CDATA[
Sys.WebForms.PageRequestManager._initialize('ctl00$ScriptManager1', 'form1', [], [], [], 90, 'ctl00');
//]]>
</script>
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper" style="min-height: 1105.75px;">
				<section class="content-header">
					<h1 id="ContentPlaceHolder1_IdHeader">Group Loan Search</h1>
					<ol class="breadcrumb">
						<li><a href="Home.html"><i class="fa fa-dashboard"></i>Home</a></li>
						<li><a href="#">Dashboard</a></li>
						<li class="active">Search</li>
					</ol>
				</section>
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
											<label>Branch :</label> <select
												name="ctl00$ContentPlaceHolder1$ddlBranch"
												id="ContentPlaceHolder1_ddlBranch"
												class="form-control select2" style="width: 100%;">
												<option selected="selected" value=""></option>
														<%
													if (branchListList != null && !branchListList.isEmpty()) {
														for (BranchMaster group : branchListList) {
													%>
													<option value="<%=group.getId()%>"><%=group.getName()%></option>
													<%
													}
													}
													%>
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
												<input name="ctl00$ContentPlaceHolder1$txtFDate" type="text"
													value="01/08/2022" id="ContentPlaceHolder1_txtFDate"
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
												<input name="ctl00$ContentPlaceHolder1$txtTDate" type="text"
													value="01/08/2022" id="ContentPlaceHolder1_txtTDate"
													class="form-control"
													data-inputmask="&#39;alias&#39;: &#39;dd/mm/yyyy&#39;"
													data-mask="" />
											</div>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Applicant Name :</label> <input
												name="ctl00$ContentPlaceHolder1$txtApplicantName"
												type="text" id="ContentPlaceHolder1_txtApplicantName"
												class="form-control" Placeholder="Enter Applicant Name"
												autocomplete="off" />
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Loan ID :</label> <select name="ctl00$ContentPlaceHolder1$ddlSearchLoanID"
													id="searchGroupID1"
													
													
													class="form-control select2" style="width: 100%;">
													<option selected="selected" value=""></option>
														<%
													if (allGroupMaster != null && !allGroupMaster.isEmpty()) {
														for (GroupMaster group : allGroupMaster) {
													%>
													<option value="<%=group.getId()%>"><%=group.getId()%></option>
													<%
													}
													}
													%>
												</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Member Code :</label> <input
												name="ctl00$ContentPlaceHolder1$txtMemberCode" type="text"
												id="ContentPlaceHolder1_txtMemberCode" class="form-control"
												Placeholder="Enter Member Code" autocomplete="off" />
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Plan Name :</label> <select
												name="ctl00$ContentPlaceHolder1$ddlPlanName"
												id="ContentPlaceHolder1_ddlPlanName" class="form-control"
												style="width: 100%;">
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Advisor Code :</label> <input
												name="ctl00$ContentPlaceHolder1$txtAdvisorCode" type="text"
												id="ContentPlaceHolder1_txtAdvisorCode" class="form-control"
												Placeholder="Enter Advisor Code" autocomplete="off" />
										</div>
									</div>
									<div class="clearfix margin-bottom-10"></div>
									<div class="text-center">
										<a id="ContentPlaceHolder1_btnSearch" class="btn btn-success"
										href="javascript:displayGroupLoanApplicationDetailsShowTable()"><span
											class="fa fa-search"
											></span> SEARCH</a> 
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
									<table id="tableId" style="width:100%">
        <tr>
            <th>Group Name</th>
            <th>Leader Name</th>
            <th>Mobile</th>
            <th>Address</th>
            <th>Employee</th>
            <th>Day</th>
            <th>Time</th>
        </tr>
    </table>
									<div></div>
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
            $(function () {
                //Initialize Select2 Elements
                $('.select2').select2();
                //Datemask dd/mm/yyyy
                $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
                //Datemask2 mm/dd/yyyy
                $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
                //Date range picker
                $('#reservation').daterangepicker()
                //Date range picker with time picker
                $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, locale: { format: 'MM/DD/YYYY hh:mm A' } })
                $('#daterange-btn').daterangepicker(
                 {
                     ranges: {
                         'Today': [moment(), moment()],
                         'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                         'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                         'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                         'This Month': [moment().startOf('month'), moment().endOf('month')],
                         'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                     },
                     startDate: moment().subtract(29, 'days'),
                     endDate: moment()
                 },
                 function (start, end) {
                     $('#daterange-btn span').html(start.format('DD/MM/YYYY') + ' - ' + end.format('DD/MM/YYYY'))
                 }
               )
                //Date picker
                $('#datepicker').datepicker({
                    autoclose: true
                })
                //Money Euro
                $('[data-mask]').inputmask()

                //iCheck for checkbox and radio inputs
                $('span[type="checkbox"].minimal').iCheck({
                    checkboxClass: 'icheckbox_minimal-blue',
                    radioClass: 'iradio_minimal-blue'
                })
            })
        </script>
	</form>
</body>

<!-- Dk/Admin/GoldLoanSearch.aspx EDB D 09:27:12 GMT -->
</html>
