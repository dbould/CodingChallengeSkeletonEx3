
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Secret Escapes</title>
    <meta name="layout" content="main"/>
</head>

<body>
    ${account.name}'s Transactions

<table>
    <tr>
        <th>
            To Account
        </th>
        <th>
            Amount
        </th>
    </tr>

    <g:each var="transaction" in="${transactions}">
        <tr>
            <td>
                ${names[transaction.toAccount]}
            </td>
            <td>
                £${transaction.amount}
            </td>
        </tr>
    </g:each>
</table>
</body>
</html>