<%@page import="com.cs544.mum.util.SecurityUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
	String username = SecurityUtil.getUsername();
%>
<!--=== Header ===-->
<div class="header" style="margin-top: -16px; margin-bottom: 30px;">
	<div class="container">
		<!-- Logo -->
		<a class="logo" href="${pageContext.request.contextPath}/"> <img
			src="${pageContext.request.contextPath}/resources/img/logo1.PNG"
			alt="Logo" class="img-responsive">
		</a>
		<!-- End Logo -->

		<!-- Topbar -->
		<div class="topbar">
			<ul class="loginbar pull-right" style="margin-top: 64px;">

				<li class="topbar-devider"></li>
				<li><a href="#">Help</a></li>
				<sec:authorize access="!hasAnyRole('ROLE_ANONYMOUS')">
					<li class="topbar-devider"></li>
					<li><a href="#">Username: <%=username%></a></li>

					<li class="topbar-devider"></li>
					<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
				</sec:authorize>
			</ul>
		</div>
		<!-- End Topbar -->

		<!-- End Toggle -->
	</div>
	<!--/end container-->
</div>