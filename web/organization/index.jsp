<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/9/23
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>志峰系统</title>
    <link rel="stylesheet" href="/static/css/layout-default-latest.css">
</head>
<body>
<iframe name="content" class="ui-layout-center"
        src="" frameborder="0" scrolling="auto"></iframe>

<iframe name="tree" class="ui-layout-west"
        src="/organization/tree" frameborder="0" scrolling="auto"></iframe>

<script src="/static/js/jquery-1.11.0.min.js"></script>
<script src="/static/js/jquery.layout-latest.min.js"></script>
<script>
    $(function () {
        $(document).ready(function () {
            $('body').layout({ applyDemoStyles: true });
        });
    });
</script>
</body>
</html>
