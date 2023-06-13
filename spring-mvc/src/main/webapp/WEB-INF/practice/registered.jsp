<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registered</title>
</head>
<body>
    <h1>
        Hello, ${name}
    </h1>

    <form method="get" action="get-users">
        <button type="submit">Show all</button>
    </form>
</body>
</html>