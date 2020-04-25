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
                          name="content"><c:out value="${board.content}"/></textarea>
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
            <button data-oper="modify" class="btn btn-default"> 수정</button>
            <button data-oper="list" class="btn-default btn"> 목록</button>

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

<script type="text/javascript" src="/resources/js/reply.js"></script><%--댓글 모듈--%>
<script type="text/javascript">

    var bnoValue = '<c:out value="${board.bno}"/>';//게시글 번호를 받아와 전역변수에 저장합니다.
    console.log("선택된 게시글 번호 :" + bnoValue);

    //댓글 추가 테스트
    /*replyService.add(
        {reply:"JS test", replyer:"tester", bno:bnoValue},
        function (result) {
            alert("RESULT :"+ result );
        }//function (result)
    );//reply add test*/

    //댓글 리스트출력 테스트
    /*replyService.getList({bno:bnoValue,page:1}, function (list) {
        for(var i=0, len=list.length||0 ; i<len ; i++){
            console.log(list[i]);
        }//for
    })//reply getList test*/

    //num번 댓글삭제 테스트
    var testNum= 42;
    /*replyService.remove(testNum, function (count) {
        console.log(count);
        if (count=="success"){
            alert("선택하신 댓글이 삭제되었습니다!");
        }//if
    }, function (err) {
        alert('서버 점검중!!');
    });//remove*/

    //testNum 번 댓글수정 테스트
    /*replyService.update({
        rno: testNum,
        bno: bnoValue,
        reply: "수정될 댓글입니다아아아아아아아?",
        replyer: "손영준"
    }, function (result) {
        alert("댓글 수정이 완료되었습니다!");
    })//reply update test*/

    //testNum 번 댓글 출력 테스트
    /*replyService.get(testNum, function (data) {
        console.log(data);
    })//reply get test*/
</script>


<script><%--페이지 준비완료 시 이벤트--%>
$(document).ready(function () {

    var operForm = $("#operForm");

    $("button[data-oper='modify']").on("click", function () {
        console.log("bno = " + '<c:out value="${board.bno}"/>');
        console.log("pageNum = " + '<c:out value="${cri.pageNum}"/>');
        console.log("amount = " + '<c:out value="${cri.amount}"/>');
        console.log("keyword = " + '<c:out value="${cri.keyword}"/>');
        console.log("type = " + '<c:out value="${cri.type}"/>');
        /*var url = "/board/modify?bno="+$("#bno").val();
        operForm.attr("action",url); //case 1*/
        console.log(operForm.attr("action"));
        operForm.submit();
    });//button modify click

    $("button[data-oper='list']").on("click", function () {
        //list의 경우 get방식 파라미터로 넘겨줄때 bno가 추가되지 않아야 하므로 제거합니다.
        operForm.find("bno").remove();
        operForm.attr("action", "/board/list");
        operForm.submit();
    });//button list click
});//document.ready
</script>
<%@ include file="../includes/footer.jsp" %>
