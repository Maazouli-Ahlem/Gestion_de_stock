package com.mycompany.article.article.services.impl;

import com.mycompany.article.article.Repository.CategoryRepository;
import com.mycompany.article.article.dto.CategoryDto;
import com.mycompany.article.article.exception.EntityNotFoundException;
import com.mycompany.article.article.exception.ErrorCodes;
import com.mycompany.article.article.exception.InvalidEntityException;
import com.mycompany.article.article.model.Category;
import com.mycompany.article.article.services.CategoryService;
import com.mycompany.article.article.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
     private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if (!errors.isEmpty()){
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("La categorie n'est pas valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null){
            log.error("Categorie ID is null");
            return null;
        }

        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune categorie avec l'ID = "+ id +
                        "n'est trouvee dans la BD", ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {

        if (!StringUtils.hasLength(code)){
            log.error("Categorie code is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoryByCode(code);
        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(() -> new EntityNotFoundException("Aucun category avec le code = "+code+ "n'est trouvee dans la BDD",ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Category ID is null");
            return ;
        }
        categoryRepository.deleteById(id);
    }
}
