<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">게시글 수정</h1>
    </div>
    <!--/.col-lg-12 : 타이틀-->
</div>
<!--/.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel-default panel">
            <div class="panel-heading"> ~~Modify~~</div><!-- /.panel-heading -->
        </div>
        <div class="panel-body">
            <form action="/board/modify" role="form" method="post">
                <div class="form-group">
                    <label>글 번호<input class="form-control" name="bno" readonly="readonly"
                                      value='<c:out value="${board.bno}"/>'/> </label>
                </div> <!--/번호-->
                <div class="form-group">
                    <label>제목<input class="form-control" name="title"
                                value='<c:out value="${board.title}"/>'/></label>
                </div><!--/제목-->
                <div class="form-group">
                    <label>글 내용</label>
                    <textarea class="form-control" rows="3" style="resize: none"
                              name="content"><c:out value="${board.content}"/></textarea>
                </div><!--/글내용-->
                <div class="form-group">
                    <label>작성자<input class="form-control" name="writer"
                                     value='<c:out value="${board.writer}"/>'/></label>
                </div><!--/작성자-->

                <input type="hidden" name="regdate" readonly="readonly"
                       value="<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}"/>"/>
                <input type="hidden" name="updateDate" readonly="readonly"
                       value="<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}"/>"/>

                <button type="submit" data-oper="modify" class="btn btn-default" > 수정 </button>
                <button type="submit" data-oper="remove" class="btn btn-danger" > 삭제 </button>
                <button type="submit" data-oper="list" class="btn btn-info" > 목록 </button>

            </form>
        </div><!--/. end panel body-->
    </div><!--/. end panel-->
</div>
<!--/. row-->
<%@ include file="../includes/footer.jsp" %>

<script>
    $(document).ready(function () {
        var formObj = $("form");

        $('button').on("click", function (e) {

            e.preventDefault();

            var operation = $(this).data("oper");

            console.log(operation); //data- 속성을 읽어 다르게 동작하는 버튼을 작성합니다(속성은 모두 submit)

            if(operation === 'remove'){
                formObj.attr("action","/board/remove");
                console.log("넘어가는 주소"+formObj.attr("action"));
            }else if (operation === 'list'){
                formObj.attr("action","/board/list").attr("method","get");
                formObj.empty();
            }//if end
            formObj.submit();
        })//$on.click fn
    });//$document.ready
</script>