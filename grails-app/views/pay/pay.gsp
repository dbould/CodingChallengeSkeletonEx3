<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Secret Escapes</title>
    <meta name="layout" content="main"/>
</head>

<body>
<g:form name="myForm" url="[action:'Transfer', controller:'Pay']">
    <label for="fromAccount">From Account: </label>
    <g:select id="fromAccount"
              name="fromAccount"
              from="${accounts}"
              optionValue="name"
              optionKey="id"
    />
    <br />
    <label for="toAccount">To Account: </label>
    <g:select id="toAccount"
              name="toAccount"
              from="${accounts}"
              optionValue="name"
              optionKey="id"
    />
    <br />
    <label for="amount">Amount: </label>
    <input id="amount" name="amount" type="number" min="0.01" step="0.01" value="00.00" />
    <br />
    <input type="submit" />
</g:form>

</body>
</html>