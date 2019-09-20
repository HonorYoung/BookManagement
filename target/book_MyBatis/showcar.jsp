<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2019/7/17 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title></title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <div style="width: 100%;margin: 0 auto">
        <table class="table table-hover table-bordered table-condensed table-striped">
            <thead>
            <tr>
                <th>序号</th>
                <th>书名</th>
                <th>作者</th>
                <th>价格</th>
                <th>数量</th>
                <th>总价</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="hj" value="0"></c:set>
            <c:forEach items="${sessionScope.car}" var="kv" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${kv.value.book.name}</td>
                    <td>${kv.value.book.author}</td>
                    <td>${kv.value.book.price}</td>
                    <td>
                        <button type="button" onclick="removeOne('${kv.value.book.id}')"
                                class="btn btn-primary glyphicon glyphicon-minus"></button>
                        ${kv.value.count}
                        <button type="button" onclick="addOne('${kv.value.book.id}')"
                                class="btn btn-primary glyphicon glyphicon-plus"></button>
                    </td>
                    <td>${kv.value.sum}</td>
                </tr>
                <c:set var="hj" value="${kv.value.sum + hj}"></c:set>
            </c:forEach>
            <tr>
                <td colspan="6">合计:${hj}</td>
            </tr>
            </tbody>
        </table>
    </div>

    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        function removeOne(id) {
            $.post("removeOne_shop.action","id="+id,function (data) {
                if (data.flag == "success"){
                    window.location.reload();
                }
            },'json');
        }
        function addOne(id) {
            $.post("addOne_shop.action","id="+id,function (data) {
                if (data.flag == "success"){
                    window.location.reload();
                }
            },'json');
        }
    </script>
    </body>
</html>
