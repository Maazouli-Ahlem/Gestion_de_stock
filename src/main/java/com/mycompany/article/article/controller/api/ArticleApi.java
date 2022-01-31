package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.APP_ROOT;
@Api(APP_ROOT + "/articles")
public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/article/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou de modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide")

    })
    ArticleDto save (@RequestBody ArticleDto articleDto);




    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de rechercher un article par son ID", response = ArticleDto.class)
    @GetMapping(value = APP_ROOT+ "/article/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fournit")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);




    @ApiOperation(value = "Rechercher un article par code", notes = "Cette methode permet de rechercher un article par son code", response = ArticleDto.class)
    @GetMapping(value = APP_ROOT+ "/article/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le code fournit")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);




    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de chercher et renvoyer la liste des articles", responseContainer = "List<ArticleDto>")
    @GetMapping(value = APP_ROOT+ "/article/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des articles / une liste vide")
    })
    List<ArticleDto> findAll();


    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de supprimer un article par ID", response = ArticleDto.class)
    @DeleteMapping(value = APP_ROOT+ "/article/delete/{idArticle}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article a ete supprimee")
    })
    void delete (@PathVariable("idArticle") Integer id);
}
