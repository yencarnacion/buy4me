<%--
  Created by IntelliJ IDEA.
  User: yamir
  Date: 12/14/13
  Time: 1:45 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<li class="controller"><g:link controller="needItem" action="create"><g:message code="b4m.need" default="Need Person" /></g:link></li>

<g:if test="${needItemInstanceList?.list?.size > 0}">
<table>
    <thead>
    <tr>
        <g:sortableColumn property="needyUser.username" title="${message(code: 'needItem.needyUser.username.label', default: 'Needy User')}"/>

        <g:sortableColumn property="what" title="${message(code: 'needItem.what.label', default: 'What')}"/>

        <g:sortableColumn property="whereFrom"
                          title="${message(code: 'needItem.whereFrom.label', default: 'Where From')}"/>

    </tr>
    </thead>
    <tbody>
    <g:each in="${needItemInstanceList}" status="i" var="needItemInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <td><g:link action="show" controller="needItem"
                        id="${needItemInstance.id}">${fieldValue(bean: needItemInstance, field: "needyUser.username")}</g:link></td>

            <td>${fieldValue(bean: needItemInstance, field: "what")}</td>

            <td>${fieldValue(bean: needItemInstance, field: "whereFrom")}</td>

        </tr>
    </g:each>
    </tbody>
</table>

<div class="pagination">
    <g:paginate total="${needItemInstanceCount ?: 0}"/>
</div>
</g:if>

</body>
</html>