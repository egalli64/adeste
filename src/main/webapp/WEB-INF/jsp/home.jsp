<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">

<head>
<title>Adeste</title>
<link rel="icon" href="data:;base64,=">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >
</head>

<body>
    <h1 class="display-4 text-center">
        <c:if test="${course ne null}">Welcome to<br>${course}</c:if>
    </h1>
</body>

</html>