
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<div align="center">
    <h1>Create Product</h1>
    <h2><a href="/products?action=smartphones">List Product</a></h2>
    <form method="post">
        <table border="1">
            <caption>Add New Product</caption>
            <tr>
                <th>Name</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <th>Price</th>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td><input type="number" name="quantity"></td>
            </tr>
            <tr>
                <th>Color</th>
                <td><input type="text" name="color"></td>
            </tr>
            <tr>
                <th>Category</th>
                <td><input type="text" name="category"></td>
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
