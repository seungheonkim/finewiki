<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<%@ include file="../include/head.jsp"%>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<!-- Navbar -->
		<%@ include file="../include/main_header.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@ include file="../include/left_navi.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="col-lg-12">
						<form role="form" id="writeForm" method="post"
							action="${path}/board/modify">
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">게시글 작성</h3>
								</div>
								<div class="card-body">
									<input type="hidden" name="data_no"
										value="${board.data_no}">
									<div class="form-group">
										<label for="title">제목</label> <input class="form-control"
											id="title" name="title" placeholder="제목을 입력해주세요"
											value="${board.title}">
									</div>
									<div class="form-group">
										<label for="content">내용</label>
										<textarea class="form-control" id="content" name="content"
											rows="30" placeholder="내용을 입력해주세요" style="resize: none;">${board.content}</textarea>
									</div>
									<div class="form-group">
										<label for="mem_nick">작성자</label> <input class="form-control"
											id="mem_nick" name="mem_nick" value="${board.mem_nick}" readonly>
									</div>
								</div>
								<div class="card-footer">
									<button type="button" class="btn btn-primary">
										<i class="fa fa-list"></i> 목록
									</button>
									<div class="float-right">
										<button type="button" class="btn btn-warning cancelBtn">
											<i class="fa fa-trash"></i> 취소
										</button>
										<button type="submit" class="btn btn-success modBtn">
											<i class="fa fa-save"></i> 수정 저장
										</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">ê²ìê¸ ëª©ë¡</h3>
							</div>
							<div class="card-body">
								<table class="table table-bordered">
									<tbody>
										<tr>
											<th style="width: 30px">#</th>
											<th>ì ëª©</th>
											<th style="width: 100px">ìì±ì</th>
											<th style="width: 150px">ìì±ìê°</th>
											<th style="width: 60px">ì¡°í</th>
										</tr>
										<c:forEach items="${articles}" var="article">
											<tr>
												<td>${article.article_no}</td>
												<td><a
													href="${path}/article/read?article_no=${article.article_no}">${article.title}</a></td>
												<td>${article.writer}</td>
												<td><fmt:formatDate value="${article.regDate}"
														pattern="yyyy-MM-dd a HH:mm" /></td>
												<td><span class="badge bg-red">${article.viewCnt}</span></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="card-footer">
								<div class="float-right">
									<button type="button" class="btn btn-success btn-flat"
										id="writeBtn">
										<i class="fa fa-pencil"></i> ê¸ì°ê¸°
									</button>
								</div>
							</div>
						</div>
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
			<%@ include file="../include/footer.jsp"%>
		</div>
		<!-- ./wrapper -->

		<!-- REQUIRED SCRIPTS -->
		<script type="text/javascript">
			var result = "${msg}";
			if (result == "regSuccess") {
				alert("ê²ìê¸ ë±ë¡ì´ ìë£ëììµëë¤.");
			} else if (result == "modSuccess") {
				alert("ê²ìê¸ ìì ì´ ìë£ëììµëë¤.");
			} else if (result == "delSuccess") {
				alert("ê²ìê¸ ì­ì ê° ìë£ëììµëë¤.");
			}
		</script>
</body>
</html>
