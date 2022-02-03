package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.UTILISATEUR_ENDPOINT;

@Api("/utilisateurs")
public interface UtilisateurApi {

    @PostMapping(value = UTILISATEUR_ENDPOINT + "/create")
    UtilisateurDto save (@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value = UTILISATEUR_ENDPOINT + "/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping(value = UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    void delete (@PathVariable("idUtilisateur") Integer id);
}
