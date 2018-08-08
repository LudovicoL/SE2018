<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<div id="users-list">
	
	<c:choose>
	

				<div>
					<c:out value="{user.name}"/> <c:out value="{user.surname}"/>
				</div>

	
	</c:choose>

</div>

</body>
</html>