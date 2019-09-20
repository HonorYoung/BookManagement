<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2019/7/12
  Time: 11:22
  To change this template use File | Settings | File Templates.
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

    <link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
    <link rel="stylesheet" href="css/fileinput.css">
    <title>书籍列表</title>
</head>
<body>
<%--模态框开始--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">类别详情</h4>
            </div>
            <input type="hidden" name="method">
            <div class="form-group">
                <label class="col-sm-2 control-label">图片</label>
                <div class="col-sm-10" id="pics"></div>
            </div>

            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">图书名称</label>
                <div class="col-sm-9">
                    <input type="text" required class="form-control"
                           id="name" name="name" placeholder="请输入图书名称">
                </div>
            </div>

            <div class="form-group">
                <label for="author" class="col-sm-3 control-label">作者</label>
                <div class="col-sm-9">
                    <input type="text" required class="form-control" id="author" name="author" placeholder="请输入作者">
                </div>
            </div>

            <div class="form-group">
                <label for="price" class="col-sm-3 control-label">价格</label>
                <div class="col-sm-9">
                    <input type="number" required class="form-control" id="price" name="price" placeholder="请输入价格">
                </div>
            </div>

            <div class="form-group">
                <label for="publishdate" class="col-sm-3 control-label">出版日期</label>
                <div class="col-sm-9">
                    <div class="input-group date form_date" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                        <input class="form-control" id="publishdate" name="publishdate" size="16" type="text" value="" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="sl" class="col-sm-3 control-label">数量</label>
                <div class="col-sm-9">
                    <input type="number" required class="form-control" id="sl" name="sl" placeholder="请输入数量">
                </div>
            </div>

            <div class="form-group">
                <label for="categoryid" class="col-sm-3 control-label">类别</label>
                <div class="col-sm-9">
                    <select class="form-control" name="category" id="categoryid"></select>
                </div>
            </div>

            <div class="form-group">
                <label for="gysid" class="col-sm-3 control-label">供应商</label>
                <div class="col-sm-9">
                    <select class="form-control" name="gys" id="gysid"></select>
                </div>
            </div>

            <div class="form-group">
                <label for="status" class="col-sm-3 control-label">状态</label>
                <div class="col-sm-9">
                    <select class="form-control" name="status" id="status">
                        <option value='-1'>请选择状态</option>
                        <option value='1'>上架</option>
                        <option value='0'>下架</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="pic" class="col-sm-3 control-label">添加图片</label>
                <div class="col-sm-7">
                    <input type="file" class="form-control" id="pic" name="pic" multiple="true">
                </div>
                <div class="col-sm-2"><button type="button" class="btn btn-primary" onclick="addPic()">添加</button></div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-12">
                    <button type="submit" class="btn btn-primary glyphicon glyphicon-saved" >提交</button>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info glyphicon glyphicon-eye-close" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<%--模态框结束--%>
<%--折叠框开始--%>
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingOne">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                   aria-expanded="true" aria-controls="collapseOne">
                    条件查询
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
            <div class="panel-body">
                <form class="form-inline" role="form">
                    <div class="form-group col-sm-4">
                        <label for="q_bookname">图书名</label>
                        <input type="text" name="q_bookname" id="q_bookname" class="form-control" placeholder="请输入图书名">
                    </div>

                    <div class="form-group col-sm-4">
                        <label for="q_category">所属类别</label>
                        <select class="form-control" name="q_category" id="q_category"></select>
                    </div>

                    <div class="form-group col-sm-4">
                        <label for="q_gys">所属供应商</label>
                        <select class="form-control" name="q_gys" id="q_gys"></select>
                    </div>
                    <div class="form-group">
                        <label>价格区间</label>
                        <input type="number" required class="form-control" id="q_price_min"
                               name="price_min" placeholder="请输入最低价格">
                        <span>至</span></span>
                        <input type="number" required class="form-control" id="q_price_max"
                               name="price_max" placeholder="请输入最高价格">
                    </div>
                    <div class="form-group ">
                        <label>出版日期</label>
                        <div class="input-group date form-date" id="start" data-date="" data-date-format="yyyy-mm-dd"
                             data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                            <input class="form-control" id="publishdate_start" name="q_publishdate_start"
                                   size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>

                        </div>
                        至
                        <div class="input-group date form-date" id="end" data-date="" data-date-format="yyyy-mm-dd"
                             data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                            <input class="form-control" id="publishdate_end" name="q_publishdate_end"
                                   size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                    <br>
                    <button type="button" onclick="queryByTj()" class="btn btn-primary">查询</button>
                    <button type="button" onclick="del()" class="btn btn-danger">批量删除</button>
                    <button type="button" onclick="export2Excel()" class="btn btn-success">导出到Excel</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
<%--折叠框结束--%>
<table id="table"></table>

<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-table-locale-all.js"></script>

<script src="js/bootstrap-datetimepicker.js"></script>
<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="js/fileinput.js"></script>
<script src="js/ajaxfileupload.js"></script>
<script>
    $(function () {
        queryData();
        queryCa();
        queryGys();
    });

    $("#pic").fileinput({
        showUpload: false,
        allowedFileExtensions: ['jpg','png','gif','jpeg'],
        browseClass: "btn btn-success",
        maxFileCount: 3
    });

    $('#start').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    $("#start").on('changeDate',function(ev){
        $("#end").datetimepicker("setStartDate", $("#start").val());
    });

    $('#end').datetimepicker({
        language:"zh-CN",
        todayBtn : "true",
        autoclose : true,
        todayHighlight : true,
        minView: "month",
        pickerPosition: "bottom-left",
        //startDate:new Date(new Date()-1000 * 60 * 60 * 24 * 365),
        endDate : new Date()
    });

    function queryByTj() {
        $("#table").bootstrapTable("refresh");
    }

    //打开本页面时查询数据用到本方法-----bootstrapTable表格
    function queryData() {
        $("#table").bootstrapTable({
            url:'querySomeBook_book.action',
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
            queryParams:function (param) {
                start = (param.pageNumber - 1) * param.pageSize;
                let q_bookname = $.trim($("#q_bookname").val());
                let q_price_min = $("#q_price_min").val();
                let q_price_max = $("#q_price_max").val();
                let q_category = $("#q_category").val();
                let q_gys = $("#q_gys").val();
                let q_publishdate_start = $("#publishdate_start").val();
                let q_publishdate_end = $("#publishdate_end").val();
                let newParam = {
                    pageNumber: param.pageNumber,
                    pageSize: param.pageSize,
                };
                if (q_bookname != null &&q_bookname != ''){
                    newParam.bookname = q_bookname;
                }
                if (q_category != null &&q_category != 0){
                    newParam.category = q_category;
                }
                if (q_gys != null &&q_gys != 0){
                    newParam.gys =q_gys;
                }
                if (q_price_min != null &&q_price_min != ''){
                    newParam.price_min =q_price_min;
                }
                if (q_price_max != null &&q_price_max != ''){
                    newParam.price_max =q_price_max;
                }
                if (q_publishdate_start != null &&q_publishdate_start != ''){
                    newParam.publishdate_start =q_publishdate_start;
                }
                if (q_publishdate_end != null &&q_publishdate_end != ''){
                    newParam.publishdate_end =q_publishdate_end;
                }
                return newParam;
            },
            columns:[
                {field:'id',title:'序号',formatter: function (value,row,index) {
                        return index + 1 + start;
                    },align:'center'},
                {field:'name',title:'图书名',align:'center'},
                {field:'author',title:'作者',align:'center'},
                {field:'sl',title:'数量',align:'center'},
                {field:'price',title:'价格',align:'center'},
                {field:'gys.name',title:'供应商',align:'center'},
                {field:'publishdate',title:'出版日期',align:'center'},
                {field:'ca.name',title:'类别',align:'center'},
                {field:'del',title:'删除',formatter:function (value,row,index) {
                        return (value == 1?"已删除":"未删除");
                    },align:'center'},
                {field:'status',title:'状态',formatter:function (value,row,index) {
                        return (value == 1?"上架":"下架");
                    },align:'center'},
                {title:'操作',formatter:function (value,row,index) {
                        let info = "<a id='info' class='btn btn-primary' href='javascript:void(0)'>详情</a>";
                        let ud = "<a id='ud' class='btn btn-"+ (row.status == 0?"success":"danger") +"' " +
                            "href='javascript:void(0)'>"+ (row.status == 0?"上架":"下架") +"</a>";
                        return info + "&nbsp;" + ud;
                    },events:lyevents,align:'center'}
            ]
        });
    }
    //将表格中的文字转换为简体中文
    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);
    //注册点击事件
    window.lyevents = {
        //上架下架的点击事件
        'click #ud':function (event,value,row,index) {
            $.post("changeStatus_book.action","id="+row.id,function (data) {
                if (data.flag == "success"){
                    $("#table").bootstrapTable("refresh");
                }
            },'json');
        },
        //详情的点击事件
        'click #info':function (event,value,data,index) {
            queryPicById(data.id);
            $("#name").val(data.name);
            $("#author").val(data.author);
            $("#price").val(data.price);
            $("#publishdate").val(data.publishdate);
            $("#sl").val(data.sl);
            $("#status").val(data.status);
            //匹配对应的供应商和类别
            $("#gysid").val(data.gysid);
            $("#categoryid").val(data.categoryid);
            $("#myModal").modal("show");
        }
    };
    let bookid = "";
    //根据图书id查询相应的图片
    function queryPicById(id) {
        $.post('queryPicsByPid_book.action','bookid='+id,function (data) {
            let div = "";
            if (data.bps != null){
                $.each(data.bps,function (i,bps) {
                    div += "<div class='col-sm-6 col-md-4'><div class='thumbnail'>"+
                        "<img src='"+ bps.savepath +"'><div class='caption'>" +
                        "<button type='button' class='btn btn-"+ (bps.fm == 0?"primary":"success") +"' "
                        + (bps.fm == 1?'disabled':'') +" onclick='setPicAsFM(\""+bps.id+"\")'>"
                        + (bps.fm == 0 ?"设置封面":"当前封面") +"</button>"+
                        "<button type='button' class='btn btn-danger' onclick='delPic(\""+bps.id+"\")'>" +
                        "删除</button></div></div> </div>";
                });
            }
            bookid = "";
            bookid = id;
            //将选择框中的图片清空
            $("#pic").val("");
            $("#pics").html(div);
        },'json');
    }
    //添加图片
    function addPic(){
        $.ajaxFileUpload({
            type:'post',
            url:'addPic_book.action',
            fileElementId:'pic',
            data:{"bookid":bookid},
            dataType:'json',
            success:function (data) {
                if (data.flag == "success"){
                    console.log("jieshu");
                    $(".fileinput-remove-button").click();
                    queryPicById(bookid);
                }
            }
        });
    }
    //删除图片
    function delPic(bpid) {
        $.post('delPic_book.action','bookid='+bookid+'&bpid='+bpid,function (data) {
            if (data.bps == "success"){
                queryPicById(bookid);
            }
        },'json');
    }
    //将图片设置为封面
    function setPicAsFM(bpid) {
        $.post('setPicAsFm_book.action','bookid='+bookid+'&bpid='+bpid,function (data) {
            if (data.flag == "success"){
                queryPicById(bookid);
            }
        },'json');
    }
    //页面初始化时为模态框中类别选择框赋值
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
