<%--
  Created by IntelliJ IDEA.
  User: sohny
  Date: 2020-03-30
  Time: 오전 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>업로드 페이지입니다~~~~~하핳ㅎ핳핫</title>
</head>
<body>
<%-- action 속성으로 지정된 경로가 exUploadPost 이므로, Controller에서 받아줘야 합니다. >> 메소드 필요!! --%>
    <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="file" name="files"/>
        </div>
        <div>
            <input type="submit"/>
        </div>
    </form>
</body>
</html>
