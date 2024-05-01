package com.educandoweb.course.service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
       //return Oder.findById(id);
       Optional<Product> product = productRepository.findById(id);
        validator(product);
        return product.get();
    }

    private void validator(Optional<Product> product) {
        if (product.isEmpty()) {
            throw new NoSuchElementException("Product not found ");
        }
    }

}
