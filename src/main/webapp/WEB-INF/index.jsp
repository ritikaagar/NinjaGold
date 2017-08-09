 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
	<title>Ninja Gold</title>
	 <link rel="stylesheet" href="style.css" media="screen" title="no title"  charset="utf-8">
</head>
<body>
<h2>Your Gold: <input type="text" value="${gold}"></h2>
<fieldset>
	<h2>Farm</h2>
	<p>Earns 10-20 golds</p>
	<form action="/process" method="post">
		<input type="hidden" name="building" value="farm" />
		<input type="submit" value="Find Gold!"/>
	</form>
</fieldset>
<fieldset>
	<h2>Cave</h2>
	<p>Earns 5-10 golds</p>
	<form action="/process" method="post">
	
		<input type="hidden" name="building" value="cave" />
		<input type="submit" value="Find Gold!"/>
	</form>
</fieldset>
<fieldset>
	<h2>House</h2>
	<p>Earns 2-5 golds</p>
	<form action="/process" method="post">
	
		<input type="hidden" name="building" value="house" />
		<input type="submit" value="Find Gold!"/>
	</form>
</fieldset>
<fieldset>
	<h2>Casino</h2>
	<p>Earns -50-50 golds</p>
	<form action="/process" method="post">
	
		<input type="hidden" name="building" value="casino" />
		<input type="submit" value="Find Gold!"/>
	</form>
</fieldset>
<div>
	<h2>Activity Log:</h2>
		<c:forEach var = "message" items = "${messages}">
			<p class = "lost"><c:out value="${message}"/></p>
		</c:forEach>
</div>
</body>
</html>