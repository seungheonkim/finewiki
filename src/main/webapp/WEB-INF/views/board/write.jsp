<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<%@ include file="../include/head.jsp"%>
<body class="hold-transition sidebar-mini layout-boxed">
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
							<form role="form" id="writeForm" method="post"
								action="${path}/board/write">
								<div class="card">
									<div class="card-header with-border">
										<h3 class="card-title">게시글 작성</h3>
									</div>
									<div class="card-body">
										<div class="form-group">
											<label for="title">제목</label> <input class="form-control"
												id="title" name="title" placeholder="제목을 입력해주세요">
										</div>
										<div class="form-group">
											<label for="content">내용</label>
											<textarea class="form-control" id="content" name="content"
												rows="30" placeholder="내용을 입력해주세요" style="resize: none;"></textarea>
										</div>
										<div class="form-group" hidden>
											<label for="mem_nick">작성자</label> <input class="form-control"
												id="mem_nick" name="mem_nick" value="${login.nick}"
												readonly>
										</div>
										<div class="form-group" hidden>
											<label for="regdate">게시일</label> <input class="form-control"
												id="regdate" name="regdate" value="${board.regdate}"
												readonly>
										</div>
										<%--첨부파일 영역 추가--%>
										<div class="form-group">
											<div class="fileDrop">
												<br /> <br /> <br /> <br />
												<p class="text-center">
													<i class="fa fa-paperclip"></i> 첨부파일을 드래그해주세요.
												</p>
											</div>
										</div>
										<%--첨부파일 영역 추가--%>

									</div>
									<div class="card-footer">
										<button type="button" class="btn btn-primary">
											<i class="fa fa-list"></i> 목록
										</button>
										<div class="float-right">
											<button type="reset" class="btn btn-warning">
												<i class="fa fa-reply"></i> 초기화
											</button>
											<button type="submit" class="btn btn-success">
												<i class="fa fa-save"></i> 저장
											</button>
										</div>
									</div>
								</div>
							</form>
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
		<%@ include file="../include/footer.jsp"%>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->
	<%@ include file="../include/plugin_js.jsp"%>
	<%--이미지--%>
	<script id="templatePhotoAttach" type="text/x-handlebars-template">
  										  <li>	
        									<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
       										 <div class="mailbox-attachment-info">
          										  <a href="{{getLink}}" class="mailbox-attachment-name" data-lightbox="uploadImages"><i class="fas fa-camera"></i> {{fileName}}</a>
          										  <a href="{{file_name}}" class="btn btn-default btn-xs float-right delBtn"><i class="far fa-trash-alt"></i></a>
       										 </div>
   										 </li>
										</script>
	<%--일반 파일--%>
	<script id="templateFileAttach" type="text/x-handlebars-template">
    									<li>
        									<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
        									<div class="mailbox-attachment-info">
           										<a href="{{getLink}}" class="mailbox-attachment-name"><i class="fas fa-paperclip"></i> {{file_name}}</a>
            									<a href="{{file_name}}" class="btn btn-default btn-xs float-right delBtn"><i class="far fa-trash-alt"></i></a>
        									</div>
    									</li>
										</script>
	<script type="text/javascript"
		src="${path}/resources/dist/js/upload.js"></script>

	<script>
		/*====================================================게시판 첨부파일 업로드 관련======================================*/
		$(document)
				.ready(
						function() {
							var fileDropDiv = $(".fileDrop");
							var templatePhotoAttach = Handlebars.compile($(
									"#templatePhotoAttach").html());
							var templateFileAttach = Handlebars.compile($(
									"#templateFileAttach").html());
							// 전체 페이지 파일 끌어 놓기 기본 이벤트 방지 : 지정된 영역외에 파일 드래그 드랍시 페이지 이동방지
							$(".content-wrapper").on("dragenter dragover drop",
									function(event) {
										event.preventDefault();
									});
							// 파일 끌어 놓기 기본 이벤트 방지
							fileDropDiv.on("dragenter dragover",
									function(event) {
										event.preventDefault();
									});
							// 파일 드랍 이벤트 : 파일 전송 처리, 파일 화면 출력
							fileDropDiv
									.on(
											"drop",
											function(event) {
												event.preventDefault();
												var files = event.originalEvent.dataTransfer.files;
												var file = files[0];
												var formData = new FormData();
												formData.append("file", file);
												$
														.ajax({
															url : "/finewiki/file/upload",
															data : formData,
															dataType : "text",
															processData : false,
															contentType : false,
															type : "POST",
															success : function(
																	data) {
																// 파일정보 가공
																var fileInfo = getFileInfo(data);
																// 이미지 파일일 경우
																if (data
																		.substr(
																				12,
																				2) == "s_") {
																	console
																			.log("This is Image");
																	var html = templatePhotoAttach(fileInfo);
																	// 이미지 파일이 아닐 경우
																} else {
																	html = templateFileAttach(fileInfo);
																}
																$(
																		".uploadedList")
																		.append(
																				html);
															}
														});
											});
							// 글 저장 버튼 클릭 이벤트 : 파일명 DB 저장 처리
							$("#writeForm")
									.submit(
											function(event) {
												event.preventDefault();
												var that = $(this);
												var str = "";
												$(".uploadedList .delBtn")
														.each(
																function(index) {
																	str += "<input type='hidden' name='files["
																			+ index
																			+ "]' value='"
																			+ $(
																					this)
																					.attr(
																							"href")
																			+ "'>"
																});
												that.append(str);
												that.get(0).submit();
											});
							// 파일 삭제 버튼 클릭 이벤트 : 파일삭제, 파일명 DB 삭제 처리
							$(document).on("click", ".delBtn", function(event) {
								event.preventDefault();
								var that = $(this);
								$.ajax({
									url : "/finewiki/file/delete",
									type : "post",
									data : {
										fileName : $(this).attr("href")
									},
									dataType : "text",
									success : function(result) {
										if (result == "DELETED") {
											alert("삭제되었습니다.");
											that.parents("li").remove();
										}
									}
								});
							});
						});
	</script>
</body>
</html>
