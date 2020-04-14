<%--
  Created by IntelliJ IDEA.
  User: sohny
  Date: 2020-04-07
  Time: 오후 7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="../includes/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="panel-heading">~~게시판 페이지~~
    <button id="regBtn" type="button" class="btn btn-xs pull-right">새글 등록하기</button>
</div>
<table class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th>#번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>작성된 날짜</th>
        <th>최근수정된 날짜</th>
    </tr>
    </thead>
    <c:forEach items="${list}" var="board">
        <tr>
            <td><c:out value="${board.bno}"/></td>
            <td><a target="_blank" href="/board/get?bno=<c:out value="${board.bno}"/>"></a><c:out value="${board.title}"/></td>
            <td><c:out value="${board.content}"/></td>
            <td><c:out value="${board.writer}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
        </tr>
    </c:forEach>
</table>



<div class="pull-right"><!--페이징 처리 시작-->
    <ul class="pagination">
        <c:if test="${pageMaker.prev}">
            <li class="paginate_button previous">
                <a href="${pageMaker.startPage -1}">이전</a>
            </li>
        </c:if><!--이전페이지로-->

        <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
            <li class="paginate_button ${pageMaker.cri.pageNum == num ? "active" : ""}">
                <a href="${num}">${num}</a>
            </li>
        </c:forEach><!--페이지번호목록-->

        <c:if test="${pageMaker.next}">
            <li class="paginate_button next">
                <a href="${pageMaker.endPage +1}">다음</a>
            </li>
        </c:if><!--다음페이지로-->
    </ul><!--/.pagination-->
</div><%--/.paginate--%>
<form action="/board/list" method="get" id="actionForm">
    <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"/>
    <input type="hidden" name="amount" value="${pageMaker.cri.amount}"/>
</form><!--/페이징 처리 완료-->


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">감사합니다</h4>
            </div>
            <div class="modal-body">
                처리가 완료되었습니다.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">끄기</button>
                <button type="button" class="btn btn-primary">확인</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>



<script type="text/javascript">
    $(document).ready(function () {
        <%--상황에 따른 메시지 확인 방법 (새로운 게시글이 등록될 때 modal 창이 팝업됩니다.)--%>
        var result = '<c:out value="${result}"/>';
        checkModal(result); //checkModal 함수 호출

        history.replaceState({},null,null);

        function checkModal(result) {
            // alert("확인!");
            if(result===''){
                console.log("리스트 페이지입니다.");
                return;
            }else if(result===history.state){
                console.log(history.state.location);
                return;
            }//if(result)
            if(parseInt(result)>0){
                $(".modal-body").html(parseInt(result)+"번 게시글이 등록되었습니다.");
            }//if(parseInt)
            $("#myModal").modal("show");
        }//checkModal(result)


        $("#regBtn").on("click",function () {
            self.location = "/board/register"; //클릭시 페이지 이동
        });//#regBtn click

        var actionForm = $("#actionForm");
        $(".paginate_button a").on("click",function (e) {
            e.preventDefault();
            console.log('click');
            actionForm.find('input[name="pageNum"]').val($(this).attr("href"));
            actionForm.submit();
        })//paginate button click fn
    });
</script>



<%@ include file="../includes/footer.jsp"%>