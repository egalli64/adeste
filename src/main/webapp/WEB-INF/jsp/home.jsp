<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">

<head>
<title>Adeste</title>
<link rel="icon" href="data:;base64,=">
</head>

<body>
    <h1>
        Course manager <c:if test="${course ne null}">for ${course}</c:if>
    </h1>
</body>

</html>