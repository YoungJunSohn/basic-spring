<%--
  Created by IntelliJ IDEA.
  User: sohny
  Date: 2020-04-07
  Time: 오후 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp"%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시글 등록</h1>
    </div>
    <!--/.col-lg-12 : 타이틀-->
</div>
<!--/.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel-default panel">
            <div class="panel-heading"> ~~Register~~ </div><!-- /.panel-heading -->
        </div>
        <div class="panel-body">
            <form role="form" action="/board/register" method="post">
                <div class="form-group">
                    <label>제목<input class="form-control" name="title"/></label>
                </div><!--/제목-->
                <div class="form-group">
                    <label>글 내용</label>
                    <textarea class="form-control" rows="3" style="resize: none" name="content"></textarea>
                </div><!--/글내용-->
                <div class="form-group">
                    <label>작성자<input class="form-control" name="writer"/></label>
                </div><!--/작성자-->
                <button type="reset" class="btn btn-default"> 취소 </button>
                <button type="submit" class="btn-default btn"> 등록 </button>
            </form>
        </div><!--/. end panel body-->
    </div><!--/. end panel-->
</div><!--/. row-->
<%@ include file="../includes/footer.jsp"%>