<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="baseUri" value="${pageContext.request.contextPath }"
	scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书管理系统</title>
<link rel="stylesheet" href="${baseUri}/static/layui/css/layui.css">
</head>
<script type="text/javascript">
	function showPreview(source) {
		var file = source.files[0];
		if (window.FileReader) {
			var fr = new FileReader();
			console.log(fr);
			var portrait = document.getElementById('portrait');
			fr.onloadend = function(e) {
				portrait.src = e.target.result;
			};
			fr.readAsDataURL(file);
			portrait.style.display = 'block';
		}
	}
</script>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<!-- 引入头部导航 -->
		<c:import url="nav/titlenav.jsp"></c:import>

		<!-- 引入左边导航 -->
		<c:import url="nav/leftnav.jsp"></c:import>



		<div class="layui-body">
			<!-- 内容主体区域 -->
			<!-- 内容主体区域 -->
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 20px;">
				<legend>最近上架的图书(两个月内)</legend>
			</fieldset>

			<div class="layui-form">
				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="150">
						<col width="100">
						<col width="80">
						<col width="80">
						<col width="350">
						<col width="130">
						<col width="60">
						<col width="50">
						<col width="50">
						<col width="50">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th>ISBN</th>
							<th>书名</th>
							<th>作者</th>
							<th>类型</th>
							<th>价格(元)</th>
							<!-- <th>简介</th>
							<th>图片</th> -->
							<th>上架时间</th>
							<th>查看</th>
							<th>编辑</th>
							<th>下架</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.newBookList}" var="book">
							<tr>
								<td>${book.isbn }</td>
								<td>${book.title }</td>
								<td>${book.author }</td>
								<td>${book.categoryId }</td>
								<td>${book.price }</td>
								<%-- <td>${book.introduction }</td>
								<td><img src="${baseUri}/static/images/${book.image }"
									alt="" width="80px" height="100px;"></td> --%>
								<td>
								<fmt:formatDate value="${book.createTime }" pattern="yyyy年MM月"/>	
								</td>
								<td><a class="layui-btn"
									style="background-color: #B69A50" href="bookDetail?id=${book.id }">查看</a></td>
								<td><a class="layui-btn"
									style="background-color: #B69A50" href="toUpdateBook?id=${book.id }">编辑</a></td>
								<td><a class="layui-btn"
									style="background-color: #B69A50" href="deleteBookNewList?id=${book.id }">下架</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
		<!-- 引入底部导航 -->
		<c:import url="nav/bottom.jsp"></c:import>
	</div>

	<script src="${baseUri}/static/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
</html>