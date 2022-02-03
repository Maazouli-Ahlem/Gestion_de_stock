package com.mycompany.article.article.services;

import com.mycompany.article.article.dto.ArticleDto;
import com.mycompany.article.article.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
