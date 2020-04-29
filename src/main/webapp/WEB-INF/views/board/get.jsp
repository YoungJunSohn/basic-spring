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
            <div class="panel-heading"> ~~Read~~ </div><!-- /.panel-heading -->
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


<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">

            <div class="panel-heading">
                <i class="fa fa-comments fa-fw"></i> 댓 글
                <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">새 댓글 작성</button>
            </div><!--/.panel-heading-->

            <div class="panel-body">
                <ul class="chat">
                    <%--댓글 시작!--%>
                    <li class="left clearfix" data-rno="12">
                        <div class="header">
                            <strong class="primary-font">user00</strong>
                            <small class="pull-right text-muted">2020-04-27 21:27</small>
                        </div>
                        <p>잘해쓰!</p>
                    </li>
                    <%--댓글 끝--%>
                </ul>
            </div><!--/.panel-body-->
        </div><!--/.panel panel-default-->
    </div><!--/.col-lg-12-->
</div>
<!--/.row-->


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">댓글 모달창!</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>댓글</label>
                    <input class="form-control" name="reply" value="새 댓글입니다!"/>
                </div>

                <div class="form-group">
                    <label>작성자</label>
                    <input class="form-control" name="replyer" value="작성자!!"/>
                </div>

                <div class="form-group">
                    <label>댓글</label>
                    <input class="form-control" name="replyDate" value=""/>
                </div>
            </div>


            <div class="modal-footer">
                <button id="modalModBtn" type="button" class="btn btn-warning">수정</button>
                <button id="modalRemoveBtn" type="button" class="btn btn-danger">삭제</button>
                <button id="modalRegisterBtn" type="button" class="btn btn-primary">등록</button>
                <button id="modalCloseBtn" type="button" class="btn btn-default">취소</button>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<%--****************************  scrpit  *****************************--%>
<script type="text/javascript" src="/resources/js/reply.js"></script><%--댓글 모듈--%>
<script type="text/javascript">
    var bnoValue = '<c:out value="${board.bno}"/>';//게시글 번호를 받아와 전역변수에 저장합니다.
    // console.log("선택된 게시글 번호 :" + bnoValue);

    //댓글 추가 테스트
    /* replyService.add(
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
    /*var testNum = 42;
    replyService.remove(testNum, function (count) {
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
<!--테스트-->

<script><%--페이지 준비완료 시 이벤트--%>
$(document).ready(function () {

    var operForm = $("#operForm");

    $("button[data-oper='modify']").on("click", function () {
        <%--console.log("bno = " + '<c:out value="${board.bno}"/>');--%>
        <%--console.log("pageNum = " + '<c:out value="${cri.pageNum}"/>');--%>
        <%--console.log("amount = " + '<c:out value="${cri.amount}"/>');--%>
        <%--console.log("keyword = " + '<c:out value="${cri.keyword}"/>');--%>
        <%--console.log("type = " + '<c:out value="${cri.type}"/>');--%>
        /*var url = "/board/modify?bno="+$("#bno").val();
        operForm.attr("action",url); //case 1*/
        // console.log(operForm.attr("action"));
        operForm.submit();
    });//button modify click

    $("button[data-oper='list']").on("click", function () {
        //list의 경우 get방식 파라미터로 넘겨줄때 bno가 추가되지 않아야 하므로 제거합니다.
        operForm.find("bno").remove();
        operForm.attr("action", "/board/list");
        operForm.submit();
    });//button list click


    var replyUL = $(".chat");

    showList(1);

    function showList(page) {
        replyService.getList({bno: bnoValue, page: page || 1}, function (list) {
            var str = "";

            if (list == null || list.length == 0) {
                replyUL.html("");
                return
            }//if

            for (var i = 0, len = list.length || 0; i < len; i++) {
                var timeValue = list[i].replyDate;

                // console.log("댓글 시간 "+timeValue+" 입니다");

                str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";
                str += "<div><div class='header'><strong class='primary-font'>" + list[i].replyer + "</strong>";

                str += "<small class='pull-right text-muted'>"
                    + replyService.timeFormat8601(timeValue)
                    + "</small></div>";

                str += "<p>" + list[i].reply + "</p></div></li>";
            }//for

            replyUL.html(str);
        })//reply getList
    }//fn showList

    //modal start
    var modal = $(".modal");
    var modalInputReply = modal.find("input[name='reply']");
    var modalInputReplyer = modal.find("input[name='replyer']");
    var modalInputReplyDate = modal.find("input[name='replyDate']");

    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");

    $("#addReplyBtn").on("click", function () {
        modal.find("input").val("");
        modalInputReplyDate.closest("div").hide();
        modal.find("button[id!='modalCloseBtn']").hide();

        modalRegisterBtn.show();
        $(".modal").modal("show");
    });//addReply click fn

    modalRegisterBtn.on("click", function () {
        var reply = {
            reply:modalInputReply.val(),
            replyer:modalInputReplyer.val(),
            bno: bnoValue
        };//reply

        replyService.add(reply, function (result) {
            alert(result);
            modal.find("input").val();//입력한 정보가 replyService로 넘어감
            modal.modal("hide");
            showList(1);//댓글 추가, 완료시 목록 갱신이 필요함
        })//replyService.add fn
    });//modalRegister click fn


    $(".chat").on("click","li", function () { //이벤트의 위임 ul > li
        var rno = $(this).data("rno");
        // console.log(rno);

        replyService.get(rno, function (reply) {
            modalInputReply.val(reply.reply);
            modalInputReplyer.val(reply.replyer);
            modalInputReplyDate.val(replyService.timeFormat8601(reply.replyDate)).attr("readonly", "readonly");
            modal.data("rno", reply.rno);

            modal.find("button[id!='modalCloseBtn']").hide();
            modalModBtn.show();
            modalRemoveBtn.show();

            $(".modal").modal("show");
        })//replyService.get
    })//.chat click fn


    modalModBtn.on("click", function (e) {
        var reply = {
            rno:modal.data("rno"),
            reply:modalInputReply.val(),
            replyer:modalInputReplyer.val()
        };//reply declaration

        replyService.update(reply, function (result) {
            console.log(reply);
            alert(result);//수정 결과 success 출력
            modal.modal("hide");
            showList(1);//댓글 리스트 재출력
        });
    });//modalModBtn click fn


    modalRemoveBtn.on("click", function (e) {
        var rno = modal.data("rno");

        replyService.remove(rno, function (result) {
            alert(result);
            modal.modal("hide");
            showList(1);
        });//replyService.remove
    });//modalRemoveBtn click fn
});//document.ready
</script>
<%@ include file="../includes/footer.jsp" %>
