<%@ page import="buy4me.ContentMaterial" %>



<div class="fieldcontain ${hasErrors(bean: contentMaterialInstance, field: 'content', 'error')} required">
    <label for="contentMaterialInstance.content">
        <g:message code="contentMaterialInstance.content.label" default="Content" />
        <span class="required-indicator">*</span>
    </label>
    <g:textArea name="contentMaterialInstance.content" cols="40" rows="5" maxlength="1000000000" required="" value="${contentMaterialInstance.content}"/>
</div>