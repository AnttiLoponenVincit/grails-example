
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1><g:message code="user.list"/></h1>
<g:link action="create"><g:message code="user.create"/></g:link>
<table>
    <tr>
        <th><g:message code="user.firstName"/></th>
        <th><g:message code="user.lastName"/></th>
        <th><g:message code="user.SSN"/></th>
        <th><g:message code="user.department"/></th>
    </tr>
<g:each in="${users}" var="user">
    <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.ssn}</td>
        <td><g:message code="Department.${user.department}"/></td>

    </tr>
</g:each>
</table>
</body>
</html>