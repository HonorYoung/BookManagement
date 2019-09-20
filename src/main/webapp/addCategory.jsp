<%--
  Created by IntelliJ IDEA.
  User: 李洋
  Date: 2019/7/24 16:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form class="form-horizontal" role="form" method="post" action="addCategory_cate.action">
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">类别名称</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" id="name" onblur="checkName()"
                   name="name" placeholder="请输入类别名称">
        </div>
    </div>



    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="reset" class="btn btn-default">重置</button>
            <button type="button" class="btn btn-primary" onclick="checkAll()">提交</button>
        </div>
    </div>
</form>

<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    //查询名称是否存在
    function checkName() {
        $.post('queryCategory_cate.action','name='+$.trim($("#name").val()),function (data) {
            $.each(data.cate,function (i,ca) {
                if (ca != null){
                    alert("类别已存在");
                    return;
                }
            })
        },'json');
    }

    //提交时调用此函数检查输入内容的合法性
    function checkAll() {
        if (checkName()){
            alert("类别已存在");
            return;
        } else if ($.trim($("#name").val()) == null || $.trim($("#name").val()) == ""){
            alert("请输入类别名称");
            return;
        }else {
            $("form").submit();
        }
    }

</script>
</body>
</html>
