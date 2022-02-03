package com.mycompany.article.article.controller.api;
import com.mycompany.article.article.dto.ArticleDto;
import com.mycompany.article.article.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mycompany.article.article.utils.Constants.APP_ROOT;

@Api
public interface ClientApi {

    @PostMapping(value = APP_ROOT + "clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un client", notes = "Cette methode permet d'enregistrer ou de modifier un client", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client cree"),
            @ApiResponse(code = 400, message = "L'objet client n'est pas valide")

    })
    ClientDto save (@RequestBody ClientDto clientDto);

    @GetMapping(value = APP_ROOT + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un client par ID", notes = "Cette methode permet de rechercher un client par son ID", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun client n'existe dans la BDD avec l'ID fournit")
    })
    ClientDto findById(@PathVariable("idClient") Integer id);


    @GetMapping(value = APP_ROOT + "/clients/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des clients", notes = "Cette methode permet de chercher et renvoyer la liste des clients", responseContainer = "List<ClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des clients / une liste vide")
    })
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}")
    @ApiOperation(value = "Renvoi la liste des clients", notes = "Cette methode permet de supprimer un client par ID", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le client a ete supprimee")
    })
    void delete (@PathVariable("idClient") Integer id);

}
