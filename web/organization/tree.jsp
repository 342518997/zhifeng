<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/9/24
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>志峰系统</title>
    <link rel="stylesheet" href="/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css">
</head>
<body>
<ul id="tree" class="ztree"></ul>

<script src="/static/js/jquery-1.11.0.min.js"></script>
<script src="/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
<script>
    $(function () {
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback : {
                onClick : function(event, treeId, treeNode) {
                    parent.frames['content'].location.href = "/organization/"+treeNode.id+"/maintain";
                }
            }
        };

        var zNodes =[
            <c:forEach items="${organizationList}" var="o">
            { id:${o.id}, pId:${o.parentId}, name:"${o.name}", open:${o.rootNode}},
            </c:forEach>
        ];

        $(document).ready(function(){
            $.fn.zTree.init($("#tree"), setting, zNodes);
        });
    });
</script>
</body>
</html>
