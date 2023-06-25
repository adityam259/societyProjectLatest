<jsp:include page="../header.jsp" />
<body class="skin-blue sidebar-mini" onload="getAllPolicyNumber1();"
	style="height: auto; min-height: 100%; background-color: rgba(36, 105, 92, 0.15);"
	cz-shortcut-listen="true">
	<!--     <form method="post" action="" id="form1" modelAttribute="user">
 -->
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
				<h1 id="ContentPlaceHolder1_IdHeader">Interest Statement</h1>
				<ol class="breadcrumb">
					<li><a href="Home.html"><i class="fa fa-dashboard"></i>Home</a></li>
					<li><a href="#">Dashboard</a></li>
					<li class="active">Statement</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box box-warning">
							<div class="box-header with-border">
								<h3 class="box-title">Search Box</h3>
							</div>
							<div class="form-horizontal">
								<div class="box-body">
									<div class="col-md-3">
										<div class="form-group">
											<label>Select by Policy No.<strong
												style="color: Red">*</strong></label> <select
												name="searchbyPolicyNo" id="searchbyPolicyNo"
												onchange="javascript:getByAddInvesmentCode1()"
												class="form-control select2" style="width: 100%;">
												<option value=""></option>
											</select>
										</div>
									</div>
									<div class="col-md-9">
										<div class="form-group">
											<label></label> <input type="submit"
												onclick="getDataByInterestDetails()"
												name="ctl00$ContentPlaceHolder1$btnSave" value="Search"
												id="ContentPlaceHolder1_btnSave"
												class="btn btn-success pull-right margin-r-5 margin-20" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="box box-success"
							style="box-shadow: none; overflow: auto !important;">
							<div class="box-header with-border">
								<div class="box-tools pull-right"></div>
							</div>
							<div class="box-body">
								<div class="clearfix margin-bottom-10"></div>
								<table cellspacing="0" cellpadding="3" rules="all"
									class="display nowrap table table-hover table-striped table-bordered"
									border="1" style="width: 100%; border-collapse: collapse;">
									<tr style="color: White; background-color: #008385;">
										<th scope="col">Name</th>
										<th scope="col">Policy Date</th>
										<th scope="col">Phone Number</th>
										<th scope="col">Scheme Name</th>
										<th scope="col">mIs Interest</th>
										<th scope="col">Last Interest Paid</th>
										<th scope="col">Due Date</th>
										<th scope="col">Late Fine</th>
										<th scope="col">No. Of Interest Paid</th>
									</tr>
									<tbody id="investmentInterestTable">
									</tbody>
								</table>
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
	<script src="dist/js/investmentSection .js"></script>
	<!-- Select2 -->
	<script src="bower_components/select2/dist/js/select2.full.min.js"></script>
	
</body>

<!-- Dk/Admin/InvestmentInterestDetails.aspx EDB D 09:27:03 GMT -->
</html>
