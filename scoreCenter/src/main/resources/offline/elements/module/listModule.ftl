<div id="">
    <#list studentList as student>
        这是第${student_index+1}个人，叫做：<label style="color:#6bff2b">${student}</label>
        if判断：
        <br/>
        <#if (student=="陈靖仇")>
            他的武器是: 十五~~
            <#elseif (student=="宇文拓")>       <#--注意这里没有返回而是在最后面-->
                他的武器是: 轩辕剑~·
                <#else>
                    她的绝招是：蛊毒~~
        </#if>
        <br/>
    </#list>
</div>