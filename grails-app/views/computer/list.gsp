<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>
    <h1><g:message code="computer.list"/></h1>
    <g:paginate total="${computerCount}"/>
    <table>
        <tr>
            <th><g:message code="computer.id"/></th>
            <th><g:message code="computer.serial"/></th>
            <th><g:message code="computer.manufacturer"/></th>
            <th><g:message code="computer.model"/></th>
            <th><g:message code="computer.type"/></th>
            <th><g:message code="computer.operatingSystem"/></th>
        </tr>
        <g:each in="${computers}" var="computer">
            <tr>
                <td>${computer.id}</td>
                <td>${computer.serial}</td>
                <td>${computer.model.manufacturer.name}</td>
                <td>${computer.model.name}</td>
                <td><g:message code="ComputerType.${computer.type}"/></td>
                <td><g:message code="OperatingSystemType.${computer.operatingSystem.type}"/> ${computer.operatingSystem.versionName}</td>
            </tr>
        </g:each>
    </table>
    <g:each in="${computers}">
        <p>
            <g:formatComputerInformation computer="${it}"/>
        </p>
    </g:each>
</body>
</html>