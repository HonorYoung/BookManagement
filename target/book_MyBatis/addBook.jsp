<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>书籍管理系统</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.css" rel="stylesheet">
    <link href="css/fileinput.css" rel="stylesheet">
</head>
<body>
<div class="thumbnail">
        <form class="form-horizontal" action="addBook_book.action" method="POST"
              role="form" enctype="multipart/form-data">

            <div class="form-group">
                <label for="pic" class="col-sm-2 control-label">图片:</label>
                <div class="col-sm-7">
                    <input type="file" class="form-control"
                           id="pic" name="pic" multiple="true">
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">名字:</label>
                <div class="col-sm-7">
                    <input type="text" class="form-control"
                           id="name" name="b.name"
                           placeholder="请输入名字">
                </div>
                <div class="col-sm-3">
                    <div id="info"   role="alert"></div>
                </div>
            </div>
            <div class="form-group">
                <label for="author" class="col-sm-2 control-label">作者:</label>
                <div class="col-sm-7">
                    <input type="text"  class="form-control"
                           id="author" name="b.author"
                           placeholder="请输入作者">
                </div>

            </div>
            <div class="form-group">
                <label for="price" class="col-sm-2 control-label">价格:</label>
                <div class="col-sm-7">
                    <input type="number"  class="form-control"
                           id="price" name="b.price">
                </div>
            </div>
            <div class="form-group">
                <label for="publishdate" class="col-sm-2 control-label">出版日期:</label>
                <div class="col-sm-7">
                    <div class="input-group date form_date col-md-5"
                         data-date=""
                         data-date-format="yyyy-mm-dd"
                         data-link-field="dtp_input2"
                         data-link-format="yyyy-mm-dd">
                        <input class="form-control" name="publishdate" id="publishdate" size="16" type="text" value="" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>
                    <input type="hidden" id="dtp_input2" name="b.publishdate" value="" /><br/>
                </div>
            </div>
            <div class="form-group">
                <label for="sl" class="col-sm-2 control-label">数量:</label>
                <div class="col-sm-7">
                    <input type="number"  class="form-control"
                           id="sl" name="b.sl">
                </div>
            </div>
            <div class="form-group">
                <label for="categoryid" class="col-sm-2 control-label">所在类别:</label>
                <div class="col-sm-7">
                    <select class="form-control"
                            id="categoryid" name="b.categoryid"></select>
                </div>
            </div>
            <div class="form-group">
                <label for="gysid" class="col-sm-2 control-label">供应商:</label>
                <div class="col-sm-7">
                    <select class="form-control"
                            id="gysid" name="b.gysid"></select>
                </div>
            </div>
            <div class="form-group">
                <label for="status" class="col-sm-2 control-label">状态:</label>
                <div class="col-sm-7">
                    <select class="form-control"
                            id="status" name="b.status">
                        <option value="0">下架</option>
                        <option value="1">上架</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" onclick="checkAll()"  class="btn btn-primary">提交</button>

                </div>
            </div>
        </form>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.10.2.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.js"></script>
<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="js/fileinput.js"></script>
<script>
    function checkAll(){
        let name = $.trim($("#name").val());
        let author = $.trim($("#author").val());
        let price = $.trim($("#price").val());
        let publishdate = $("#publishdate").val();
        console.log(publishdate);
        let sl = $.trim($("#sl").val());
        let cate = $.trim($("#categoryid").val());
        let gys = $.trim($("#gysid").val());
        if (name == '' || name == null){
            alert("请输入图书名");
            return;
        }else
        if (author == '' || author == null){
            alert("请输入作者");
            return;
        }else
        if (price == '' || price == null){
            alert("请输入价格");
            return;
        }else
        if (publishdate == '' || publishdate == null){
            alert("请选择出版日期");
            return;
        }else
        if (sl == '' || sl == null){
            alert("请输入数量");
            return;
        }else
        if (cate == '0'){
            alert("请选择类别");
            return;
        }else
        if (gys == '0'){
            alert("请选择供应商");
            return;
        }else {
            $("form").submit();
        }
    }
    //初始化 文件上传控件的
    $("#pic").fileinput({
        allowedFileExtensions : ['jpg', 'png','gif','jpeg'],
        showUpload: false,
        //showRemove:false,
        //uploadUrl:"##",
        showCaption: false,
        browseClass: "btn btn-success ",
        maxFileCount:2
    });
    //初始化日期控件的
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    $(function(){
        //查询供应商和类别
        queryGys();
        queryCa();
    });
    
    function queryGys() {
        $.post('queryAllSupplier_gys.action','',function (data) {
            let opts = "<option value='0'>请选择供应商</option>";
            $.each(data.gys,function (i,gys) {
                opts += "<option value='"+ gys.id +"'>"+ gys.name +"</option>";
            });
            $("#gysid").html(opts);
        },'json');
    }
    function queryCa() {
        $.post('queryAllCategory_cate.action','',function (data) {
            let opts = "<option value='0'>请选择类别</option>";
            $.each(data.cate,function (i,cate) {
                opts += "<option value='"+ cate.id +"'>"+ cate.name +"</option>";
            });
            $("#categoryid").html(opts);
        },'json');
    }
</script>
</body>
</html>

