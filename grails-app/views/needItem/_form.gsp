<%@ page import="buy4me.NeedItem" %>



<div class="fieldcontain ${hasErrors(bean: needItemInstance, field: 'needyUser', 'error')} required">
    <label for="needyUser">
        <g:message code="needItem.needyUser.label" default="Needy User"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select id="needyUser" name="needyUser.id" from="${buy4me.auth.B4mUser.list()}" optionKey="id" optionValue="username" required=""
              value="${needItemInstance?.needyUser?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: needItemInstance, field: 'what', 'error')} ">
    <label for="what">
        <g:message code="needItem.what.label" default="What"/>

    </label>
    <g:textField name="what" value="${needItemInstance?.what}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: needItemInstance, field: 'whereFrom', 'error')} ">
    <label for="whereFrom">
        <g:message code="needItem.whereFrom.label" default="Where From"/>

    </label>
    <g:textField name="whereFrom" value="${needItemInstance?.whereFrom}"/>
</div>

