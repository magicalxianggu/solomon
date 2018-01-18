<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>xueyuanxinxi</title>
</head>
<body>

<table id="bs-table" class="table fixed-size">
    <thead>
    <tr>
        <th data-width="80" class="text-center">操作</th>
        <th class="text-center">课程名称</th>
        <th data-width="150" class="text-center">上课教员</th>
        <th data-width="180" class="text-center">工作部门</th>
        <th data-width="150" class="text-center">听查课人</th>
        <th data-width="120" class="text-center">上课时间</th>
        <th data-width="100" class="text-center">上课节次</th>
        <th data-width="100" class="text-center">评价等级</th>
        <th data-width="100" class="text-center">评价结果</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${evaluateResultList}" var="result">
        <tr>
            <td class="text-center">
                <a href="javascript:viewExpertEvaluteResult('${result.evaluationResultID}')">
                    <img height=16 width=16 border="0" src="<%=(String) gdsGuiWebThemeMap.get("gdsGuiWebTheme_domain")%>/media/images/operation/view.png" title="查看">
                </a>
                <a href="javascript:modifyExpertEvaluteResult('${result.evaluationResultID}')">
                    <img height=16 width=16 border="0" src="<%=(String) gdsGuiWebThemeMap.get("gdsGuiWebTheme_domain")%>/media/images/operation/modify.png" title="修改">
                </a>
                <a href="javascript:deleteExpertEvaluteResult('${result.evaluationResultID}')">
                    <img height=16 width=16 border="0" src="<%=(String) gdsGuiWebThemeMap.get("gdsGuiWebTheme_domain")%>/media/images/operation/delete.png" title="删除">
                </a>
            </td>
            <td class="text-left">${result.itsEvaluationTarget.courseName}</td>
            <td class="text-left">${result.itsEvaluationTarget.teacherName}</td>
            <td class="text-left">
                <c:set var="depID" value="${result.itsEvaluationTarget.depID}"/>
                <%=gds.application.common.department.service.CacheService.getInstance().getDepartmentName((String)pageContext.getAttribute("depID")) %>
            </td>
            <td class="text-left">
                <c:set var="employeeID" value="${result.evaluationPartyID}"/>
                <%=gds.application.common.employee.service.CacheService.getInstance().getEmployeeName((String)pageContext.getAttribute("employeeID")) %>
            </td>
            <td class="text-center">${result.itsEvaluationTarget.classDate}</td>
            <td class="text-center">${result.itsEvaluationTarget.starNode}-${result.itsEvaluationTarget.endNode}节</td>
            <td class="text-center">${aHashMap[result.evaluationResultID]}</td>
            <td class="text-right">${result.evaluationResult}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>