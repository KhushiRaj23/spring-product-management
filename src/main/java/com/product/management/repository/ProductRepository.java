package com.product.management.repository;

import com.product.management.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private  final List<Product> products=new ArrayList<>();
    private long currId = 1;


    public Product save(Product product){
        product.setId(currId++);
        products.add(product);
        return product;
    }

    public Optional<Product> findById(Long id){
        return  products.stream().filter(p->p.getId().equals(id)).findFirst();
    }
    public List<Product> findAll(){
        return  new ArrayList<>(products);
    }
}
