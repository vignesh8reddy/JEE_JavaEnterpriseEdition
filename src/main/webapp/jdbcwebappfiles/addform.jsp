<!DOCTYPE html>
<html>
<head>
<title>Add Form</title>
</head>
<body bgcolor="lightblue">
		<form method="post" action="${pageContext.request.contextPath}/controller/addform">
			<table align='center'>
				<tr>
					<td>SAGE</td>
					<td><input type="text" name='sage' /></td>
				</tr>
				<tr>
					<td>SNAME</td>
					<td><input type="text" name='sname' /></td>
				</tr>
				<tr>
					<td>SADDR</td>
					<td><input type="text" name='saddr' /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value='save' /></td>
				</tr>
			</table>
		</form>

</body>
</html>