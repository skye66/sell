<html>
    <#include "../common/header.ftl">
<body>
<#--包裹层-->
<div id="wrapper" class="toggled">
<#--边栏SiderBar-->
            <#include "../common/nav.ftl">
<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" action="/sell/seller/category/save" method="post">
                        <div class="form-group">
                            <label >名字</label>
                            <input name="categoryName" type="text" class="form-control" value="${(category.categoryName)!""}" />
                        </div>
                        <div class="form-group">
                            <label >type</label>
                            <input name="categoryType" type="text" class="form-control" value="${(category.categoryType)!""}" />
                        </div>
                        <input type="text" hidden name="categoryId" value="${(category.categoryId)!""}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
