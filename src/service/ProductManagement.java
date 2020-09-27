package service;

import model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManagement implements IManagement<Product> {
    static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1L, "Iphone", 3000L));
        products.add(new Product(2L, "Samsung", 1500L));
        products.add(new Product(3L, "Xiaomi", 4200L));
        products.add(new Product(4L, "Oppo", 5600L));
        products.add(new Product(5L, "Asus", 2200L));
    }

    @Override
    public void add(Product object) {
        boolean flag = true;
        for (int i = 0; i < products.size(); i++) {
            if (object.getId() == products.get(i).getId()) {
                flag = false;
                break;
            }
        }
        if(flag) {
            products.add(object);
        }
    }

    @Override
    public void update(Long id, Product newObject) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.set(i, newObject);
            }
        }
    }

    @Override
    public void delete(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.remove(i);
            }
        }
    }

    @Override
    public Product findByID(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                return products.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (name.equals(product.getName())) {
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            productList.add(iterator.next());
        }
        return productList;
    }
}
