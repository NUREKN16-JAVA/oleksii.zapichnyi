<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<jsp:useBean id="user" class="ua.nure.kn.zapichnyi.usermanagement.User" scope="session"/>
<html>
<head><title>User management/Details</title></head>
<body>
<form action="<%=request.getContextPath()%>/details" method="post">
    <input type="hidden" value="${user.id}" name="id">
    <p>First Name: ${user.firstName}</p>
    <p>Last Name: ${user.lastName}</p>
    <p>Date Of Birth: ${user.dateOfBirth}</p>
    <p>Age: ${user.age}</p>
    <input type="submit" name="backButton" value="Back">
</form>
<c:if test="${requestScope.error != null}">
    <script>
        alert('${requestScope.error}');
    </script>
</c:if>
</body>
</html>