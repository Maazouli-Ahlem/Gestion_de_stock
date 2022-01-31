package com.mycompany.article.article.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.article.article.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategoryDto {

    private Integer id;
    private String code;
    private String designation;
    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> articlesDto;

    public static CategoryDto fromEntity(Category category){
        if (category == null){
            return null;
            //TODO throw an exception
        }
        //Mapping de Category->Categorydto
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }
    //Mapping de CategoryDto -> Category
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
            //TODO throw an exception
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());

        return category;


    }

}
