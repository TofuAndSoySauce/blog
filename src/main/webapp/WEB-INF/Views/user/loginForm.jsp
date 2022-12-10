<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container">
	<form action="/auth/loginProc" method="POST">
		<div class="form-group">
			<label for="username">Username</label>
			<input id="username" type="text" class="form-control" placeholder="Enter Username" name="username">
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input id="password" type="password" class="form-control" placeholder="Enter password" name="password">
		</div>
		<div class="form-group form-check">
			<label for="form-check-label"><input class="form-check-input" type="checkbox" name="remember">Remember me</label>			
		</div>
		<button id="btn-login" type="submit" class="btn btn-btn-primary">로그인</button>
	</form>
	
</div>
<!-- <script src="/js/user.js"></script> -->

<%@ include file="../layout/footer.jsp" %>