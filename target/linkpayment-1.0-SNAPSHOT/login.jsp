<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <form action="login" method="post">
        <label for="username">username</label>
        <input placeholder="Enter username" type="text" name="username" value=""/>
        <br>
        <label for="password">password</label>
        <input placeholder="Enter password" type="text" name="password" value=""/>
        <br>
        <input type="submit" name="submit" value="Save"/>
    </form>
</div>
</body>
</html>
