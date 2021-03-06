<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/27
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>志峰房产</title>
    <link rel="stylesheet" href="/static/css/css.css">
</head>
<body>

<form:form method="post" commandName="resource">
    <form:hidden path="id"/>
    <form:hidden path="available"/>
    <form:hidden path="parentId"/>
    <form:hidden path="parentIds"/>

    <c:if test="${not empty parent}">
        <div class="form-group">
            <label>父节点名称：</label>
                ${parent.name}
        </div>
    </c:if>

    <div class="form-group">
        <form:label path="name"><c:if test="${not empty parent}">子</c:if>名称：</form:label>
        <form:input path="name"/>
    </div>
    <div class="form-group">
        <form:label path="type">类型：</form:label>
        <form:select path="type" items="${types}" itemLabel="info"/>
    </div>

    <div class="form-group">
        <form:label path="url">URL路径：</form:label>
        <form:input path="url"/>
    </div>


    <div class="form-group">
        <form:label path="permission">权限字符串：</form:label>
        <form:input path="permission"/>
    </div>

    <form:button>${op}</form:button>

</form:form>

</body>
</html>
