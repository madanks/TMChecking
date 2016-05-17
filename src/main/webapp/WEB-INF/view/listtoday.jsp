<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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




		<div class="container" style="height: 450px;">
			<!-- Begin Table Search Panel v1 -->
			<div class="table-search-v1 panel panel-dark margin-bottom-50">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-globe"></i> Today's Appointments
					</h3>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Student Name</th>
								<th class="hidden-sm">Email</th>
								<th>Phone</th>
								<th>Entry</th>
								<th>Stream</th>
								<th>Total Checking</th>


								<th>Approve</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="app" items="${list}">
								<tr>
									<td>${app.name}</td>
									<td>${app.email}</td>
									<td>${app.phoneNo}</td>
									<td>${app.entryDate}</td>
									<td>${app.stream}</td>
									<td>${app.count}</td>
									<td><ul class="list-inline table-buttons">
											<li><a href="${pageContext.request.contextPath}/approve/${app.userName}"<%-- onClick="send('${app.}')" --%>>
													<span class="glyphicon glyphicon-ok-sign"></span>

											</a></li>

										</ul></td>
								</tr>

							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>
			<!-- End Table Search Panel v1 -->
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
	<script type="text/javascript">
		function send(data) {
			var a = JSON.stringify(data);
			console.log(a);
		}
	</script>
</body>
</html>