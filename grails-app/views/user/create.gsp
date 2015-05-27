
<%@ page import="computer.inventory.demo.Department" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="plain"/>
    <title></title>
</head>

<body>
<h1><g:message code="user.create"/></h1>
<g:if test="${user.hasErrors()}">
    <g:message code="user.haserrors"/>
    <br/>
    <g:fieldError field="ssn" bean="${user}"/> <br/>
    <g:fieldError field="firstName" bean="${user}"/> <br/>
    <g:fieldError field="lastName" bean="${user}"/> <br/>
</g:if>
<g:form action="save">
    <label for="firstName"><g:message code="user.firstName"/></label>
    <input type="text" name="firstName" value="${user.firstName}" id="firstName"/>
    <br/>
    <label for="firstName"><g:message code="user.lastName"/></label>
    <input type="text" name="lastName" value="${user.lastName}" id="lastName"/>
    <br/>
    <label for="firstName"><g:message code="user.SSN"/></label>
    <input type="text" name="ssn" value="${user.ssn}" id="SSN"/>
    <br/>
    <label for="department"><g:message code="user.department"/></label>
    <g:select from="${Department.values()}" name="department" value="${user.department}"/>
    <input type="submit" value="${g.message(code: 'default.form.submit')}"/>
</g:form>
</body>
</html>