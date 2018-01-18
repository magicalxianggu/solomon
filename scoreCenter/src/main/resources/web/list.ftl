<!DOCTYPE html>
<html lang="en">
<body>
<#import "paging.ftl" as paging_macro/>
<#assign ctx=request.getContextPath()>

<#list pagingDealList.rows as row>

  值：${row}
           <br>
</#list>
<#if pagingDealList??>
    <@paging_macro.paging pagingList=pagingDealList url="${ctx}/listView"/>
</#if>




</body>
</html>