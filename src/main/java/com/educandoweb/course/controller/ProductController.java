package com.educandoweb.course.controller;


import com.educandoweb.course.entities.Product;
import com.educandoweb.course.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    //teste
    @GetMapping
    public Optional<ResponseEntity<List<Product>>> findAllProducts(){
        var product= productService.findAllProducts();
        return Optional.of(ResponseEntity.ok().body(product));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductId(Long id){
        var productId = productService.findProductById(id);
        return ResponseEntity.ok().body(productId);
    }
}
