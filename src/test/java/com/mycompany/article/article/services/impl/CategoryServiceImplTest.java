package com.mycompany.article.article.services.impl;

import com.mycompany.article.article.dto.CategoryDto;
import com.mycompany.article.article.exception.EntityNotFoundException;
import com.mycompany.article.article.exception.ErrorCodes;
import com.mycompany.article.article.exception.InvalidEntityException;
import com.mycompany.article.article.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void shouldThrowInvalidEntityExeption(){
        CategoryDto expectedCategory = CategoryDto.builder().build();

        InvalidEntityException expectedException = assertThrows(InvalidEntityException.class, ()-> service.save(expectedCategory));

        assertEquals(ErrorCodes.CATEGORY_NOT_VALID, expectedException.getErrorCode());
        assertEquals(1,expectedException.getErrors().size());
        assertEquals("ajouter le code de la categorie", expectedException.getErrors().get(0));
    }

    @Test
    public void shouldThrowNotFoundEntityExeption(){


        EntityNotFoundException expectedException = assertThrows(EntityNotFoundException.class, ()-> service.findById(0));

        assertEquals(ErrorCodes.CATEGORY_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("Aucune categorie avec l'ID = 0 n'est trouvee dans la BD", expectedException.getMessage());
    }


    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowNotFoundEntityExeption2() {
        service.findById(0);
    }

    @Test
    public void shouldSaveCategoryWithSuccess(){
      CategoryDto expectedCategory = CategoryDto.builder()
                .code("cat test")
                .designation("designation test")
                .idEntreprise(1)
                .build();

        CategoryDto savedCategory = service.save(expectedCategory);

        assertNotNull(savedCategory);
        assertNotNull(savedCategory.getId());
        assertEquals(expectedCategory.getCode(), savedCategory.getCode());
        assertEquals(expectedCategory.getIdEntreprise(), savedCategory.getIdEntreprise());
        assertEquals(expectedCategory.getDesignation(), savedCategory.getDesignation());


    }

    @Test
    public void shouldUpdateCategoryWithSuccess(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .code("cat test")
                .designation("designation test")
                .idEntreprise(1)
                .build();

        CategoryDto savedCategory = service.save(expectedCategory);

        CategoryDto categoryToUpdate = savedCategory;
        categoryToUpdate.setCode("cat update");

        savedCategory = service.save(categoryToUpdate);

        assertNotNull(categoryToUpdate);
        assertNotNull(categoryToUpdate.getId());
        assertEquals(categoryToUpdate.getCode(), savedCategory.getCode());
        assertEquals(categoryToUpdate.getIdEntreprise(), savedCategory.getIdEntreprise());
        assertEquals(categoryToUpdate.getDesignation(), savedCategory.getDesignation());


    }
}