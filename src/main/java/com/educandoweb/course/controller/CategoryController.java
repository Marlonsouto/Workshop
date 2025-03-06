package com.educandoweb.course.controller;


import com.educandoweb.course.entities.Category;
import com.educandoweb.course.service.CategoryService;
import jakarta.validation.Valid;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //teste
    @GetMapping
    public Optional<ResponseEntity<List<Category>>> findAllCategories(){
        var category = categoryService.findAllCategories();
        return Optional.of(ResponseEntity.ok().body(category));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable @Valid Long id){
        var categoryId = categoryService.findCategoryById(id);
        return ResponseEntity.ok().body(categoryId);
    }
}
