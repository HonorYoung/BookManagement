<%--
  Created by IntelliJ IDEA.
  User: LiYang
  Date: 2019/7/17 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <div class="row" id="books">
    </div>

    <div style="text-align: center">
        共 <span id="total"></span> 条记录
        当前是第 <span id="pageNumber"></span> 页
        共 <span id="pageCount"></span> 页
        跳转到 <select id="pn" name="pn" onchange="jump(this.value)"></select> 页<br><br>
        <button type="button" class="btn btn-info glyphicon glyphicon-backward" id="first"></button>
        <button type="button" class="btn btn-info glyphicon glyphicon-chevron-left" id="pre"></button>
        <button type="button" class="btn btn-info glyphicon glyphicon-chevron-right" id="next"></button>
        <button type="button" class="btn btn-info glyphicon glyphicon-forward" id="last"></button>
    </div>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        let pn = 1;
        let ps = 4;
        $(function () {
            queryBooks(pn,ps);
            $("#first").on('click',function () {
                queryBooks(1,ps);
            });

            $("#pre").on('click',function () {
                console.log(pre);
                queryBooks(pre,ps);
            });

            $("#next").on('click',function () {
                console.log(next);
                queryBooks(next,ps);
            });

            $("#last").on('click',function () {
                queryBooks(last,ps);
            });
        });

/*"<button class='btn btn-success' onclick='showInfos(\""+ bk.id +"\")' '>查看详情</button>" +*/

        function queryBooks(pn,ps) {
            $.ajax({
                type:'post',
                dataType:'json',
                url:'showBooksToCustomer_shop.action?pageNumber='+ pn +'&pageSize=' + ps,
                success:function (data) {
                    pre = data.pre;
                    next = data.next;
                    last = data.pageCount;
                    $("#total").text(data.total);
                    $("#pageNumber").text(data.pageNumber);
                    $("#pageCount").text(data.pageCount);
                    let op = "";
                    $.each(data.rows,function (i,bk) {
                        op += "<div class='col-sm-3 col-md-3'><div class='thumbnail'>"+
                                "<img src='"+ bk.bp.savepath +"'><div class='caption'>"+
                                "<h3>"+ bk.name +"</h3><h4>￥"+ bk.price +"</h4><h6>"+ bk.gys.name +"</h6>" +
                            "<button class='btn btn-danger' onclick='addShoppingCar(\""+ bk.id +"\")'>加入购物车</button>&nbsp;&nbsp;" +

                            "</div></div></div>";
                    });
                    $("#books").html(op);

                    let ops = "";
                    for (let i = 1;i <= data.pageCount;i++){
                        ops += "<option value='"+i+"' "+(i==data.pageNumber?"selected":"")+">"+i+"</option>";
                    }
                    $("#pn").html(ops);
                }
            });
        }

        function addShoppingCar(value) {
            $.post("addCar_shop.action","method=addCar&bid="+value,function (data) {
                if (data.flag == "success"){
                    alert("添加成功");
                }
            },"json");

        }

        function jump(value) {
            queryBooks(value,ps);
        }
    </script>
    </body>
</html>
