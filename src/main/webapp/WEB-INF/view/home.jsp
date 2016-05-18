<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
		<div class="breadcrumbs">
			<div class="container">
				<sec:authorize access="hasAnyRole('ROLE_STAFF')">
					<ul class="pull-right breadcrumb">
						<li><a
							href="${pageContext.request.contextPath}/staff/addappointment">Add
								New Appointments</a></li>
						<li><a
							href="${pageContext.request.contextPath}/staff/todayslist">Today's
								Appointments</a></li>
						<li><a
							href="${pageContext.request.contextPath}/staff/weekelylist">Weekely
								Appointments</a></li>

					</ul>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_STUDENT')">

					<ul class="pull-left breadcrumb">
						<li><a href="${pageContext.request.contextPath}/student/availableappointment">Available
								Appointments</a></li>
						<li><a href="${pageContext.request.contextPath}/student/selectedappointment">My
								upcomming Appointments</a></li>
					</ul>
				</sec:authorize>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->


		<div class="container">
			<div class="row">
				<h1>Welcome to TM Checking Center</h1>
			</div>
		</div>




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
</body>
</html>