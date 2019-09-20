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
    <link rel="stylesheet" href="css/bootstrap-table.css">
</head>
<body>

<table id="data"></table>

<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-table-locale-all.js"></script>
<script src="js/bootstrap-table-zh-CN.js"></script>
<script>
    $(function () {
        queryCategory();
    });

    function queryCategory() {
        $("#data").bootstrapTable({
            url:'querySomeCategory_cate.action',
            pagination: true,
            pageNumber:1,
            pageSize:3,
            showRefresh:true,
            showToggle:true,
            toolbarAlign:'left',
            showPaginationSwitch:true,
            pageList: [3,4,5],
            sidePagination: 'server',
            queryParamsType: 'undefined',
            queryParams:function(param){
                let name = $("#q_name").val();
                let address = $("#q_address").val();
                let newParam = {
                    pageNumber: param.pageNumber,
                    pageSize: param.pageSize,
                };
                if (name != null && $.trim(name) != ''){
                    newParam.name = name;
                }
                if (address != null && $.trim(address) != ''){
                    newParam.address = address;
                }
                return newParam;
            },
            columns:[[
                {field:'name',title:'类别名称',align:'center'},
            ]]
        });
    }

</script>
</body>
</html>
