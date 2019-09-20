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
        <h4>供应商列表</h4>
        <%--模态框开始--%>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="myModalLabel">供应商详情</h4>
                    </div>
                    <div class="modal-body">
                        <div>
                            <label class="col-sm-4">供应商名称</label>
                            <span id="name" class="col-sm-8"></span>
                        </div>
                        <div>
                            <label class="col-sm-4">供应商联系人</label>
                            <span id="contact" class="col-sm-8"></span>
                        </div>
                        <div>
                            <label class="col-sm-4">供应商联系电话</label>
                            <span id="phone" class="col-sm-8"></span>
                        </div>
                        <div>
                            <label class="col-sm-4">供应商地址</label>
                            <span id="address" class="col-sm-8"></span>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
        <%--模态框结束--%>
        <%--模糊查询开始--%>
        <div class="panel-group" role="tablist" aria-multiselectable="true">
            <div class="panel panel-default">
                <div class="panel-heading" role="tab" id="headingTwo">
                    <h4 class="panel-title">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            条件查询
                        </a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="panel-body">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">供应商名称</div>
                                <input type="text" class="form-control" name="name" id="q_name" placeholder="请输入供应商名称" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">供应商地址</div>
                                <input type="text" class="form-control" name="address" id="q_address" placeholder="请输入供应商名称" autocomplete="off">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="reset" class="btn btn-default">重置</button>
                            <button type="button" class="btn btn-primary" onclick="queryByTj()">提交</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <table id="data"></table>
        
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-table.js"></script>
        <script src="js/bootstrap-table-locale-all.js"></script>
        <script src="js/bootstrap-table-zh-CN.js"></script>
        <script>
            $(function () {
                querySupplier();
            });

            function queryByTj() {
                $("#data").bootstrapTable("refresh");
            }
            
            function querySupplier() {
                $("#data").bootstrapTable({
                    url:'querySomeSupplier_gys.action',
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
                        {field:'name',title:'供应商名称',align:'center'},
                        {field:'lxr',title:'联系人',align:'center'},
                        {field:'phone',title:'联系电话',align:'center'},
                        {field:'address',title:'联系地址',align:'center'}
                    ]]
                });
            }
            
        </script>
    </body>
</html>
