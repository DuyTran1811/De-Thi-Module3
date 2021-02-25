package service;

import java.util.List;

public interface IGeneralService <T> {
    List<T> selectAllProduct();
    void insertProduct(T t);
    boolean deleteProduct(int id);
    boolean editProduct(T t);
    T getById(int id);
    List<T> searchProduct(String name);
}
