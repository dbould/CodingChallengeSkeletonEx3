<!DOCTYPE html>
	<head>
        <asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>
	<div id="fixedheader">
        <g:img class="site-logo" dir="images" file="logo.svg" />
        <div class="main-menu">
            <a href="http://localhost:8080/seCodingChallenge/transactions">TRANSACTIONS</a>
            <a href="http://localhost:8080/seCodingChallenge/pay">PAY</a>
        </div>
	</div>
		<div id="main-content">
			<g:layoutBody/>
		</div>
	</body>
</html>
