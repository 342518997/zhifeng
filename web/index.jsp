<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-9-20
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>志峰房产</title>
    <link rel="stylesheet" href="/static/css/layout-default-latest.css">
</head>
<body>

<iframe name="content" class="ui-layout-center"
        src="/welcome" frameborder="0" scrolling="auto"></iframe>

<div  class="ui-layout-north">欢迎[<shiro:principal/>]使用志峰系统，<a href="${pageContext.request.contextPath}/logout">退出</a> </div>
<div class="ui-layout-south">
    开发公司：<a href="https://github.com/342518997/ShiroTest1" target="_blank">https://github.com/342518997/ShiroTest1</a>
</div>
<div class="ui-layout-west">
    功能菜单<br/>
    <c:forEach items="${menus}" var="m">
        <a href="${m.url}" target="content">${m.name}</a><br/>
    </c:forEach>
</div>



<script src="/static/js/jquery-1.11.0.min.js"></script>
<script src="/static/js/jquery.layout-latest.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(document).ready(function () {
            $("body").layout({ applyDemoStyles: true });
        });
    });
</script>
</body>
</html>
