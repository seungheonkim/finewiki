<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<%@ include file="../../include/head.jsp"%>
<body class="hold-transition sidebar-mini layout-boxed">
	<div class="wrapper">

		<!-- Navbar -->
		<%@ include file="../../include/main_header.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../../include/left_navi.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Starter Page</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Starter Page</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">글제목 : ${board.title}</h3>
								</div>
								<div class="card-body" style="height: 700px">
									${board.content}</div>
								<div class="card-footer">
									<div class="user-block">
										<img class="img-circle img-bordered-sm"
											src="${path}/dist/img/user1-128x128.jpg" alt="user image">
										<span class="username"> <a href="#">${board.mem_nick}</a>
										</span> <span class="description"><fmt:formatDate
												pattern="yyyy-MM-dd" value="${board.regDate}" /></span>
									</div>
								</div>
								<div class="card-footer">
									<form role="form" method="post">
										<input type="hidden" name="data_no" value="${board.data_no}">
										<input type="hidden" name="page" value="${criteria.page}">
										<input type="hidden" name="perPageNum"
											value="${searchCriteria.perPageNum}"> <input
											type="hidden" name="searchType"
											value="${searchCriteria.searchType}"> <input
											type="hidden" name="keyword"
											value="${searchCriteria.keyword}">
									</form>
									<button type="submit" class="btn btn-primary listBtn">
										<i class="fa fa-list"></i> 목록
									</button>
									<div class="pull-right">
										<button type="submit" class="btn btn-warning modBtn">
											<i class="fa fa-edit"></i> 수정
										</button>
										<button type="submit" class="btn btn-danger delBtn">
											<i class="fa fa-trash"></i> 삭제
										</button>
									</div>
								</div>
							</div>
						</div>
						<!-- /.col-md-6 -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
			<div class="p-3">
				<h5>Title</h5>
				<p>Sidebar content</p>
			</div>
		</aside>
		<!-- /.control-sidebar -->

		<!-- Main Footer -->
		<%@ include file="../../include/footer.jsp"%>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->
	<script type="text/javascript">
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);
			$(".modBtn").on("click", function() {
				formObj.attr("action", "${path}/board/paging/search/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});
			$(".delBtn").on("click", function() {
				formObj.attr("action", "${path}/board/paging/search/remove");
				formObj.submit();
			});
			$(".listBtn").on("click", function() {
				formObj.attr("action", "${path}/board/paging/search/list");
				formObj.attr("method", "get");
				formObj.submit();
			});
		});
	</script>
</body>
</html>
