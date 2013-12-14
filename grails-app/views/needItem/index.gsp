<%@ page import="buy4me.NeedItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'needItem.label', default: 'NeedItem')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-needItem" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-needItem" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <th><g:message code="needItem.needyUser.label" default="Needy User"/></th>

            <g:sortableColumn property="what" title="${message(code: 'needItem.what.label', default: 'What')}"/>

            <g:sortableColumn property="whereFrom"
                              title="${message(code: 'needItem.whereFrom.label', default: 'Where From')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${needItemInstanceList}" status="i" var="needItemInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${needItemInstance.id}">${fieldValue(bean: needItemInstance, field: "needyUser")}</g:link></td>

                <td>${fieldValue(bean: needItemInstance, field: "what")}</td>

                <td>${fieldValue(bean: needItemInstance, field: "whereFrom")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${needItemInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
