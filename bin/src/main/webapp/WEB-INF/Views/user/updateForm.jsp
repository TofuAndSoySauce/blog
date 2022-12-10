<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../layout/header.jsp" %>
<div class="container">
	<form>
	<input type="hidden" id="id" value="${principal.user.id}"/>
		<div class="form-group">
			<label for="username">Username</label>
			<input id="username" type="text" class="form-control" placeholder="Enter Username" value="${principal.user.username}" readonly>
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input id="email" type="email" class="form-control" placeholder="Enter Email" value="${principal.user.email}">
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input id="password" type="password" class="form-control" placeholder="Enter password">
			<!-- value="${principal.user.password}" 안함 해쉬코드는 가지고 올수없음 -->
		</div>
	</form>
	<button class="btn btn-btn-primary" id="btn-update">회원정보 수정 완료</button>

</div>
<script src="/js/user.js"></script>
<br/>
<%@ include file="../layout/footer.jsp" %>
