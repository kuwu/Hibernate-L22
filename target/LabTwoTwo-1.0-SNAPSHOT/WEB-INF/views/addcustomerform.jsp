<%--
  Created by IntelliJ IDEA.
  User: kuwu
  Date: 2017/07/31
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Customers</title>
</head>
<body>

<form action="addNewCustomer" method="post">
    User Name: <input type="text" name="userId" required> <br>
    First Name: <input type="text" name="firstName" required> <br>
    Last Name: <input type="text" name="lastName"> <br>
    Email: <input type="email" name="email"> <br>
    Phone Number: <input type="tel" name="phoneNumber"> <br>
    Password: <input type="password" name="password"> <br>
    <input type="submit" value="Add Customer">

</form>
</body>
</html>