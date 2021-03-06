<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseUri" value="${pageContext.request.contextPath }"
	scope="request"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书管理系统</title>
<link rel="stylesheet" href="${baseUri}/static/layui/css/layui.css">
</head>
<style>
<!--
* {
	margin: 0;
	padding: 0;
}

.searchBar {
	height: 100px;
	background-color: #e1e7ed;
}

.hBar {
	height: 50px;
	line-height: 50px;
	position: relative;
	top: 25px;
	left: 100px;
}

label, input, button {
	font-size: 25px;
	font-family: "楷体";
}
-->
</style>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<!-- 引入头部导航 -->
		<c:import url="nav/titlenav.jsp"></c:import>

		<!-- 引入左边导航 -->
		<c:import url="nav/leftnav.jsp"></c:import>



		<div class="layui-body">
			<!-- 内容主体区域 -->
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 20px;">
				<legend>查询图书</legend>
			</fieldset>


			<!-- 模糊查询字段-->
			<div class="searchBar">
				<div class="hBar">
					<form action="searchBookPage" method="get">
						<label class="">图书标题</label> 
						<input type="text" name="title" class="" style="width: 200px;"> 
						<label class="">作者</label>
						<input type="text" name="author" class="" style="width: 200px;">
						<button type="submit" class="">搜索</button>
					</form>
				</div>
			</div>



			<div class="layui-form">
				<table class="layui-table">
					<colgroup>
						<col width="150">
						<col width="150">
						<col width="150">
						<col width="80">
						<col width="80">
						<col width="350">
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
							<th>简介</th>
							<th>查看</th>
							<th>编辑</th>
							<th>下架</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.pageMsg.lists}" var="book">
							<tr>
								<td>${book.isbn }</td>
								<td>${book.title }</td>
								<td>${book.author }</td>
								<td>${book.categoryId }</td>
								<td>${book.price }</td>
								<td>${book.introduction }</td>
								<td><a class="layui-btn"
									style="background-color: #B69A50" href="bookDetail?id=${book.id }">查看</a></td>
								<td><a class="layui-btn"
									style="background-color: #B69A50" href="toUpdateBook?id=${book.id }">编辑</a></td>
								<td><a class="layui-btn"
									style="background-color: #B69A50" href="deleteSearchBook?id=${book.id }">下架</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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
		layui.use([ 'form' ], function() {
			var form = layui.form;
		});
		layui.use('carousel', function() {
			var carousel = layui.carousel;
			//建造实例
			carousel.render({
				elem : '#test1',
				width : '100%' //设置容器宽度
				,
				arrow : 'always' //始终显示箭头
			//,anim: 'updown' //切换动画方式
			});
		});
	</script>
</body>
</html>