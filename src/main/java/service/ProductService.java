package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/productdb";
    private static final String jdbcUserName = "root";
    private static final String jdbcPassword = "duytran12";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
        } catch (ClassNotFoundException e) {
            System.err.println("Khong Co Driver");
        } catch (SQLException throwables) {
            System.err.println("Khong Ket Noi Duoc");
        }
        System.err.println("Ket Noi Thanh Cong");
        return connection;
    }


    @Override
    public List<Product> selectAllProduct() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM product")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float price = rs.getFloat(3);
                int quantity = rs.getInt(4);
                String color = rs.getString(5);
                String category = rs.getString(6);
                list.add(new Product(id, name, price, quantity, color, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insertProduct(Product product) {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement("INSERT INTO `product`(`name`,`price`,`quantity`,`color`,`category`)VALUES (?,?,?,?,?)")) {
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getCategory());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM `product` WHERE `id`=?")) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean editProduct(Product product) {
        boolean rowEdit = false;
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement("UPDATE `product` SET `name` = ?, `price` = ?, `quantity` = ?, `color` = ?, `category` = ? WHERE (`id` = ?)")) {
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getCategory());
            statement.setInt(6, product.getId());
            rowEdit = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowEdit;
    }

    @Override
    public Product getById(int id) {
        Product product = null;
        try (Connection conn = getConnection();
             PreparedStatement rs = conn.prepareStatement("SELECT * FROM `product` WHERE `id` = ?")) {
            rs.setInt(1, id);
            ResultSet resultSet = rs.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String category = resultSet.getString(6);
                product = new Product(name, price, quantity, color, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM `product` where `name` like ?")) {
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String names = rs.getString(2);
                float price = rs.getFloat(3);
                int quantity = rs.getInt(4);
                String color = rs.getString(5);
                String category = rs.getString(6);
                list.add(new Product(id, names, price, quantity, color, category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
