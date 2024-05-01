package com.educandoweb.course.service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }

    //@SuppressWarnings("OptionalGetWithoutIsPresent")
    public Category findCategoryById(Long id){
       //return Oder.findById(id);
       Optional<Category> category = categoryRepository.findById(id);
        validator(category);
        return category.get();
    }

    private void validator(Optional<Category> category) {
        if (category.isEmpty()) {
            throw new NoSuchElementException("User not found ");
        }
    }

}
