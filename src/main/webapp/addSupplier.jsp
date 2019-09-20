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
        <form class="form-horizontal" role="form" method="post" action="addSupplier_gys.action">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">供应商名称</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="name" onblur="checkName()"
                           name="sup.name" placeholder="请输入供应商名称">
                </div>
            </div>

            <div class="form-group">
                <label for="contact" class="col-sm-2 control-label">联系人</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="contact" name="sup.lxr" placeholder="请输入联系人">
                </div>
            </div>

            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">联系电话</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="phone" name="sup.phone" placeholder="请输入联系电话">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">地址</label>
                <div class="col-sm-2">
                    <select class="form-control" name="province" id="province" onchange="queryCity(this.value)"></select>
                </div>
                <div class="col-sm-2">
                    <select class="form-control" name="city" id="city">
                        <option value='0'>请选择先省份</option>
                    </select>
                </div>
                <div class="col-sm-4">
                    <input class="form-control" type="text" name="street" id="address" placeholder="请输入详细地址">
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
            $(function () {
                queryProvince();
            });
            //查询名称是否存在
            function checkName() {
                $.post('querySupplier_gys.action','name='+$.trim($("#name").val()),function (data) {
                    $.each(data.gys,function (i,ca) {
                        if (ca != null){
                            alert("供应商已存在");
                            return;
                        }
                    })
                },'json');
            }
            //查询全部省份
            function queryProvince() {
                $.post('queryProvince_add.action','',function (data) {
                    let opts = "<option value='0'>请选择省份</option>";
                    $.each(data.province,function (i,pro) {
                        opts += "<option value='"+ pro.name +"'>"+ pro.name +"</option>";
                    });
                    $("#province").html(opts);
                },'json');
            }
            //根据省份的ID查询所对应的城市
            function queryCity(name) {
                $.post('queryCity_add.action?provinceName=' + name,'',function (data) {
                    let opts = "<option value='0'>请选择城市</option>";
                    $.each(data.city,function (i,city) {
                        opts += "<option value='"+ city.name +"'>"+ city.name +"</option>";
                    });
                    $("#city").html(opts);
                },'json');
            }
            //提交时调用此函数检查输入内容的合法性
            function checkAll() {
                if (checkName()) {
                    alert("供应商已存在");
                    return;
                }else if ($.trim($("#name").val()) == null || $.trim($("#name").val()) == ""){
                    alert("请输入供应商名称");
                    return;
                }else if ($.trim($("#contact").val()) == null || $.trim($("#contact").val()) == ""){
                    alert("请输入供应商联系人");
                    return;
                }else if ($.trim($("#phone").val()) == null || $.trim($("#phone").val()) == ""){
                    alert("请输入供应商联系方式");
                    return;
                }else if ($("#province").val() == 0 || $("#city").val() == 0 ||
                    $.trim($("#address").val()) == "" || $.trim($("#address").val()) == null){
                    alert("请输入供应商详细地址");
                    return;
                }else {
                    $("form").submit();
                }

            }

        </script>
    </body>
</html>
