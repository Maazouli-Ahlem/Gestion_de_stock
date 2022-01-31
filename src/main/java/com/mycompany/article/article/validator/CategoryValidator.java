package com.mycompany.article.article.validator;

import com.mycompany.article.article.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate (CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("ajouter le code de la categorie");
        }

        return errors;
    }

}
