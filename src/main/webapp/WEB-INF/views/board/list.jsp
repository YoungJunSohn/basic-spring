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
            <td>
                <a class="move" href="<c:out value="${board.bno}"/>">
                <c:out value="${board.title}"/></a>
            </td>
            <td><c:out value="${board.content}"/></td>
            <td><c:out value="${board.writer}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
        </tr>
    </c:forEach>
</table>

<div class="row"><!--검색 시작-->
    <div class="col-lg-12">
        <form id="searchForm" action="/board/list" method="get">
            <select name="type">
                <option value=""
                    <c:out value="${pageMaker.cri.type == null?'selected':''}"/>>선택하세요!</option>
                <option value="T"
                    <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
                <option value="C"
                    <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
                <option value="W"
                    <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
                <option value="TC"
                    <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목 or 내용</option>
                <option value="TW"
                    <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목 or 작성자</option>
                <option value="TWC"
                    <c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>제목 or 작성자 or 내용</option>
            </select>
            <input type="text" name="keyword"
                value="<c:out value="${pageMaker.cri.keyword}"/>"/>
            <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"/>
            <input type="hidden" name="amount" value="${pageMaker.cri.amount}"/>
            <button class="btn btn-default">검색!</button>
        </form>
    </div><!--/.col-lg-12-->
</div><!--검색 끝-->

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
    <input type="text" name="pageNum" value="${pageMaker.cri.pageNum}"/>
    <input type="text" name="amount" value="${pageMaker.cri.amount}"/>
    <input type="text" name="type" value="<c:out value='${pageMaker.cri.type}'/>">
    <input type="text" name="keyword" value="<c:out value='${pageMaker.cri.keyword}'/>">
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
        var actionForm = $("#actionForm");
        var $this = $(this);


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


        $(".move").on("click",function (e) {
            e.preventDefault();
            actionForm.append("<input type='hidden' name='bno' value='"+$this.attr("href")+"'>");
            actionForm.attr("action","/board/get");
            actionForm.submit();
        });//게시글로 이동(/board/get?bno=.....)

        /*String 형으로 입력이되어 controller에서 파라미터를 받아오지 못하는 에러를 확인, 왜그럴까?

           append("") 안에 요소를 넣을 때, 줄바꿈연결은 ""이 맞지만,
           이때 value값에 ""가 포함되는 경우 String으로 값이 바뀌어 버린다!

         */

        $("#regBtn").on("click",function () {
            self.location = "/board/register"; //클릭시 페이지 이동
        });//#regBtn click


        $(".paginate_button a").on("click",function (e) {
            e.preventDefault();
            console.log('click');
            actionForm.find('input[name="pageNum"]').val($(this).attr("href"));
            actionForm.submit();
        })//paginate button click fn

        var searchForm = $('#searchForm');
        $('#searchForm button').on("click",function (e) {
            if(!searchForm.find("option:selected").val()){
                alert("검색 종류를 선택하세요");
                return false;
            }//if()

            if(!searchForm.find("input[name='keyword']").val()){
                alert("키워드를 입력하세요");
                return false;
            }//if()
            searchForm.find("input[name='pageNum']").val("1");
            e.preventDefault();
            searchForm.submit();

        });//searchForm.button.click
    });//document.ready
</script>



<%@ include file="../includes/footer.jsp"%>