<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<title>Welcome</title>

<meta name="EA Project" content="width=device-width, initial-scale=1.0">
<meta name="responxive project mandan" content="">
<meta name="madan EA" content="">


<link rel="shortcut icon" href="favicon.ico">

<!-- Web Fonts -->
<link rel='stylesheet' type='text/css'
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/headers/header-default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/footers/footer-v1.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/parallax-slider/css/parallax-slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/owl-carousel/owl-carousel/owl.carousel.css">

<!-- CSS Customization -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">
</head>

<body>
	<div class="wrapper">
		<jsp:include page="header.jsp" />




		<!--=== Breadcrumbs ===-->
		<div class="">
			<div class="container">
				<!-- <h1 class="pull-left">New Appointments</h1> -->
				<ul class="pull-right breadcrumb">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li class="active">Add Appointments</li>
				</ul>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->

		<!--=== Content Part ===-->
		<div class="container content">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<form:form method="POST" class="reg-page" commandName="appoinment"
						action="${action}">
						<div class="reg-header">
							<h2>Create New Appointments</h2>

						</div>

						<label>Building Name</label>
						<form:input path="buildingName"
							class="form-control margin-bottom-20" name="buildingName"
							placeholder="Building Name" />

						<label>Room Number</label>
						<form:input path="roomNo" class="form-control margin-bottom-20"
							name="roomNo" placeholder="Room No" />

						<label>Date</label>
						<input type="datetime-local" path="tempdate"
							class="form-control margin-bottom-20" name="tempdate"
							placeholder="Date" />

						<label>Type of Meditation</label>
						<form:select path="type" onChange="check()"
							class="form-control margin-bottom-20">
							<form:options items="${type}" />
						</form:select>

						<div id="hide" style="display: none;">
							<label>Total Student</label>
							<form:input id="total" path="total"
								class="form-control margin-bottom-20" name="total"
								placeholder="No of student" />
						</div>
						<hr>

						<div class="row">

							<div class="col-lg-6 text-right">
								<input type="submit" class="btn-u" value="Add New Appointment" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<!--/container-->
		<!--=== End Content Part ===-->




		<jsp:include page="footer.jsp" />

	</div>
	<!--/wrapper-->

	<!-- JS Global Compulsory -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/back-to-top.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/smoothScroll.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/parallax-slider/js/modernizr.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/parallax-slider/js/jquery.cslider.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<!-- JS Customization -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
	<!-- JS Page Level -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/plugins/parallax-slider.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/plugins/datepicker.js"></script>
	<script type="text/javascript">
		$('#total').val(1);
		function check() {
			var a = $('#type').val();
			if (a == 'INDIVIDUAL') {
				$('#total').val(1);
				$("#hide").css({
					display : "none"
				});
			} else {
				$('#total').val(0);
				$("#hide").css({
					display : "block"
				});
			}
		}
	</script>
</body>
</html>