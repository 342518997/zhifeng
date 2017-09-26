<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/9/26
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>志峰房产</title>
    <link rel="stylesheet" href="/static/css/css.css">
</head>
<body>
<form:form id="form" method="post" commandName="child">
    <form:hidden path="id"/>
    <form:hidden path="available"/>
    <form:hidden path="parentId"/>
    <form:hidden path="parentIds"/>

    <div class="form-group">
        <label>父节点名称：</label>
            ${parent.name}
    </div>

    <div class="form-group">
        <form:label path="name">子节点名称：</form:label>
        <form:input path="name"/>
    </div>

       <form:button>新增子节点</form:button>
 </form:form>
</body>
</html>
