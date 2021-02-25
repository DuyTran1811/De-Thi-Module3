<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<div style="text-align: center">
    <h1>List Product</h1>
    <h2><a href="/products?action=create">Create Product</a></h2>
    <form action="/products?action=search" method="post">
        <input type="text" name="name" placeholder="Search">
        <input type="submit" value="Search">
    </form>

</div>
<div align="center">
    <table border="1">
        <caption><h2>List Product</h2></caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Price</td>
            <td>Quantity</td>
            <td>Color</td>
            <td>Category</td>
            <td>Actions</td>
        </tr>
        <c:forEach items="${list}" var="lists">
            <tr>
                <td>${lists.getId()}</td>
                <td>${lists.getName()}</td>
                <td>${lists.getPrice()}</td>
                <td>${lists.getQuantity()}</td>
                <td>${lists.getColor()}</td>
                <td>${lists.getCategory()}</td>
                <td>
                    <a href="/products?action=edit&id=${lists.getId()}">Edit</a>
                    <a href="/products?action=delete&id=${lists.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
