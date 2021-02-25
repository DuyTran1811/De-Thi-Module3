
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<div align="center">
    <h1>Edit Product</h1>
    <form method="post">
        <table border="1">
            <caption>Add New Product</caption>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name" value="${sp.getName()}"></td>
            </tr>
            <tr>
                <th>Price</th>
                <td><input type="number" name="price" value="${sp.getPrice()}"></td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td><input type="number" name="quantity" value="${sp.getQuantity()}"></td>
            </tr>
            <tr>
                <th>Color</th>
                <td><input type="text" name="color" value="${sp.getColor()}"></td>
            </tr>
            <tr>
                <th>Category</th>
                <td><input type="text" name="category" value="${sp.getCategory()}"></td>
            </tr>
            <tr>
                <th></th>
                <td colspan="2" align="center"><input type="submit" name="submit"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
