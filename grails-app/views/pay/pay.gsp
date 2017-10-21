<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Secret Escapes</title>
    <meta name="layout" content="main"/>
</head>

<body>
<form>
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
    <input type="submit" />
</form>
</body>
</html>