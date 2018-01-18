<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css" />
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.cxcolor.css" />
    <script src="js/jquery.min.js"></script>
</head>
<body>
<div id="{decorID}" class="decor-wrap decor001">
    <div class="decor-header">
        <h3 class="decor-title"></h3>
        <a class="decor-more" href="#here" target="_blank"></a>
    </div>
    <div class="decor-body">


            <h4>我的好友：</h4>
       <#list friends as item>
               姓名：${item.name} , 年龄${item.age}
           <br>
       </#list>

    </div>
    <div class="decor-footer"></div>
</div>
</body>
</html>