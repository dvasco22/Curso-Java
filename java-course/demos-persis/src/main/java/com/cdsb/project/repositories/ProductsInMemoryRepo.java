package com.cdsb.project.repositories;

import java.util.ArrayList;
import java.util.List;
import com.cdsb.project.entities.Product;

public class ProductsInMemoryRepo implements Repo<Integer, Product> {

    List<Product> products = new ArrayList<>();

    public int generateId() {

        if(products.isEmpty()) {return 1;}
        return products.getLast().getId() + 1;
    }

    @Override
    public List<Product> readAll() {
        return products;
    }

    @Override
    public Product readById(Integer id) throws Exception {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new Exception("Producto no encontrado al leer");
    }

    @Override
    public Product create(Product data) throws Exception {
        for (Product product : products) {
            if (product.getId() == data.getId()) {
                throw new Exception("Producto ya existente");
            }
        }
        products.add(data);
        return data;
    }

    @Override
    public Product deleteById(Integer id) throws Exception {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return product;
            }
        }

        throw new Exception("Producto no encontrado al borrar");
    }

    @Override
    public Product updateById(Product data) throws Exception {

        for (Product product : products) {
            if (product.getId() == data.getId()) {
                products.remove(product);
                products.add(data);
                return data;
            }
        }
        throw new Exception("Producto no encontrado al actualizar");
    }

}
