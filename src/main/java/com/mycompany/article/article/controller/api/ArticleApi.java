package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.ArticleDto;
import com.mycompany.article.article.dto.LigneCommandeClientDto;
import com.mycompany.article.article.dto.LigneCommandeFournisseurDto;
import com.mycompany.article.article.dto.LigneVenteDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.APP_ROOT;
@Api("/articles")
public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet d'enregistrer ou de modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree"),
            @ApiResponse(code = 400, message = "L'objet article n'est pas valide")

    })
    ArticleDto save (@RequestBody ArticleDto articleDto);




    @GetMapping(value = APP_ROOT+ "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par ID", notes = "Cette methode permet de rechercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec l'ID fournit")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);




    @GetMapping(value = APP_ROOT+ "/articles/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article par code", notes = "Cette methode permet de rechercher un article par son code", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'existe dans la BDD avec le code fournit")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);




    @GetMapping(value = APP_ROOT+ "/articles/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "Cette methode permet de chercher et renvoyer la liste des articles", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des articles / une liste vide")
    })
    List<ArticleDto> findAll();


    @GetMapping(value = APP_ROOT+ "/articles/historique/vente/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT+ "/articles/historique/CommandeCLient/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeClientDto> findHistoriqueCommandeCLient(@PathVariable("idArticle") Integer idArticle);


    @GetMapping(value = APP_ROOT+ "/articles/historique/CommandeFournisseur/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT+ "/articles/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAllArticleByIdCategory(@PathVariable("idCategory") Integer idCategory);


    @DeleteMapping(value = APP_ROOT+ "/articles/delete/{idArticle}")
    @ApiOperation(value = "Supprimer un article", notes = "Cette methode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article a ete supprimee")
    })
    void delete (@PathVariable("idArticle") Integer id);
}
