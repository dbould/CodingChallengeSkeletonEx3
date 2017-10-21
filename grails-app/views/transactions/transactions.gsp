
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Secret Escapes</title>
    <meta name="layout" content="main"/>
</head>

<body>
<table>
    <tr>
        <th>
            Name
        </th>
        <th>
            Balance
        </th>
    </tr>

<g:each var="account" in="${accounts}">
    <tr>
        <td>
            <a href="http://localhost:8080/seCodingChallenge/account?id=${account.id}">${account.name}</a>
        </td>
        <td>
            ${account.balance}
        </td>
    </tr>
</g:each>
</table>
</body>
</html>