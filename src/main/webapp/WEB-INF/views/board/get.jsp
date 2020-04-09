<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시글 조회</h1>
    </div>
    <!--/.col-lg-12 : 타이틀-->
</div>
<!--/.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel-default panel">
            <div class="panel-heading"> ~~Read~~</div><!-- /.panel-heading -->
        </div>
        <div class="panel-body">
            <div class="form-group">
                <label>글 번호<input class="form-control" name="bno" value='<c:out value="${board.bno}"/>'
                                  readonly="readonly"/></label>
            </div><!--/번호-->
            <div class="form-group">
                <label>제목<input class="form-control" name="title" readonly="readonly"
                                value='<c:out value="${board.title}"/>'/></label>
            </div><!--/제목-->
            <div class="form-group">
                <label>글 내용</label>
                <textarea class="form-control" rows="3" style="resize: none" readonly="readonly"
                          name="content" ><c:out value="${board.content}"/></textarea>
            </div><!--/글내용-->
            <div class="form-group">
                <label>작성자<input class="form-control" name="writer" readonly="readonly"
                                 value='<c:out value="${board.writer}"/>'/></label>
            </div><!--/작성자-->
            <button data-oper="modify" class="btn btn-default"
                    onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'"> 수정 </button>
            <button data-oper="list" class="btn-default btn"
                    onclick="location.href='/board/list'"> 목록 </button>
        </div><!--/. end panel body-->
    </div><!--/. end panel-->
</div>
<!--/. row-->
<%@ include file="../includes/footer.jsp" %>