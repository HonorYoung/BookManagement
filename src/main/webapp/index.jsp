<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">图书管理系统</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">选项 <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="col-sm-2">
            <ul class="nav nav-pills nav-stacked" role="tablist">
                <li role="presentation" class="active"><a href="welcome.html" target="show">图书管理系统</a></li>
                <li role="presentation"><a href="listBooks.jsp" target="show">图书列表</a></li>
                <li role="presentation"><a href="addBook.jsp" target="show">新增图书</a></li>
                <li role="presentation"><a href="listCategory.jsp" target="show">图书类别列表</a></li>
                <li role="presentation"><a href="addCategory.jsp" target="show">新增图书类别</a></li>
                <li role="presentation"><a href="listSupplier.jsp" target="show">图书供应商列表</a></li>
                <li role="presentation"><a href="addSupplier.jsp" target="show">新增图书供应商</a></li>

            </ul>
        </div>
        <div class="col-sm-10">
            <iframe src="welcome.html" frameborder="1" name="show" id="show" width='100%' height="500px"></iframe>
        </div>

        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
