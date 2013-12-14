<%@ page import="buy4me.ContentMaterial" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'contentMaterial.label', default: 'ContentMaterial')}" />
    <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
<a href="#show-contentMaterial" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="show-contentMaterial" class="content scaffold-show" role="main">

    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:form action="webflow" method="post" >

        <table>
        <g:each in="${contentMaterialList}" status="i" var="contentMaterialInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>${fieldValue(bean: contentMaterialInstance, field: "content")}</td>

            </tr>
        </g:each>
        </table>


        <fieldset class="buttons">
            <g:submitButton name="back" value="${message(code: 'default.button.back.label', default: 'Back')}"></g:submitButton>
            <g:submitButton name="cancel" value="${message(code: 'default.button.cancel.label', default: 'Cancel')}"></g:submitButton>

            <span class="alignRight"><g:submitButton class="save" name="save" value="${message(code: 'default.button.save.label', default: 'Save')}"></g:submitButton></span>

        </fieldset>
    </g:form>
</div>
</body>
</html>