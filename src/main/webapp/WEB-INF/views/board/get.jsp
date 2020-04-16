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
<%--            <button data-oper="modify" class="btn btn-default"--%>
<%--                    onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'"> 수정 </button>--%>
<%--            <button data-oper="list" class="btn-default btn"--%>
<%--                    onclick="location.href='/board/list'"> 목록 </button>--%>
            <%--다양한 상황 처리를 위한 수정(form 요소 추가 > input type hidden으로 은닉처리)--%>
            <button data-oper="modify" class="btn btn-default"> 수정 </button>
            <button data-oper="list" class="btn-default btn"> 목록 </button>

            <form id="operForm" action="/board/modify" method="get">
                <input type="hidden" id="bno" name="bno" value="<c:out value="${board.bno}"/>"/>
                <input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}'/>"/>
                <input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>"/>
                <input type="hidden" name="keyword" value="<c:out value='${cri.keyword}'/>"/>
                <input type="hidden" name="type" value='<c:out value='${cri.type}'/>'/>
            </form>
        </div><!--/. end panel body-->
    </div><!--/. end panel-->
</div>
<!--/. row-->
<script>
    $(document).ready(function () {

        var operForm = $("#operForm");

        $("button[data-oper='modify']").on("click",function () {
            console.log("수정버튼누름, 파라미터 = "+'<c:out value="${board.bno}"/>');
            /*var url = "/board/modify?bno="+$("#bno").val();
            operForm.attr("action",url); //case 1*/
            console.log(operForm.attr("action"));
            operForm.submit();
        });//button modify click

        $("button[data-oper='list']").on("click",function () {
            //list의 경우 get방식 파라미터로 넘겨줄때 bno가 추가되지 않아야 하므로 제거합니다.
            operForm.find("bno").remove();
            operForm.attr("action","/board/list");
            operForm.submit();
        });//button list click
    });//document.ready
</script>
<%@ include file="../includes/footer.jsp" %>
