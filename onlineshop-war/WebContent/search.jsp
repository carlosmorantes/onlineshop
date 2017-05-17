<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link rel="stylesheet" href="resources/css/style.css">
<title>Onlineshop</title>
</head>
<body>
	<header>
		<hgroup>
			<h1 class="title">Onlineshop</h1>
		</hgroup>
		<nav>
			<a href="index.jsp">Home</a> <a href="register.jsp">Registrieren</a>
			<a href="signin.jsp">Einloggen</a> <a href="sell.jsp">Verkaufen</a>
			<a href="search.jsp">Suchen</a>
			<a href="example.jsp">Example</a>
		</nav>
	</header>
	<article>
		<section>
			<form action="buy" method="post">
				<fieldset>
					<legend>Suchen</legend>
					<table>
						<tbody>
							<tr>
								<th><label for="search">Suche:</label></th>
								<td><input type="text" name="search" size="40"
									maxlength="40" title="Suchtext" placeholder="Suchtext eingeben">
								</td>
								<td><input type="reset"> <input type="submit">
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</form>
		</section>
	</article>
	<footer> Copyright </footer>
</body>
</html>