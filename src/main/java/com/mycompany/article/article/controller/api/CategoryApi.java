package com.mycompany.article.article.controller.api;
import com.mycompany.article.article.dto.ArticleDto;
import com.mycompany.article.article.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.mycompany.article.article.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {
    @PostMapping(value = APP_ROOT + "/categorie/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une categorie", notes = "Cette methode permet d'enregistrer ou de modifier une categorie", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet categorie cree"),
            @ApiResponse(code = 400, message = "L'objet categorie n'est pas valide")

    })
    CategoryDto save (@RequestBody CategoryDto categoryDto);


    @ApiOperation(value = "Rechercher une categorie par ID", notes = "Cette methode permet de rechercher un categorie par son ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune categorie n'existe dans la BDD avec l'ID fournit")
    })
    @GetMapping(value= APP_ROOT + "/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(Integer id);



    @ApiOperation(value = "Rechercher une categorie par code", notes = "Cette methode permet de rechercher une categorie par son code", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune categorie n'existe dans la BDD avec le code fournit")
    })
    @GetMapping(value = APP_ROOT+ "/category/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCodeCategory(String codeCategory);




    @ApiOperation(value = "Renvoi la liste des categories", notes = "Cette methode permet de chercher et renvoyer la liste des categories", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des Categories / une liste vide")
    })
    @GetMapping(value = APP_ROOT+ "/category/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();




    @ApiOperation(value = "Renvoi la liste des categories", notes = "Cette methode permet de supprimer une categorie par ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la categorie a ete supprimee")
    })
    @DeleteMapping(value = APP_ROOT+ "/category/delete/{idCategory}")
    void delete (Integer id);
}
