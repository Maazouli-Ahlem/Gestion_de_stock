package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.APP_ROOT;
import static com.mycompany.article.article.utils.Constants.FOURNISSEUR_ENDPOINT;

@Api("/fournisseurs")
public interface FournisseurApi {

    @PostMapping(value = FOURNISSEUR_ENDPOINT + "/create")
    FournisseurDto save (@RequestBody FournisseurDto fournisseurDto);

    @GetMapping(value = FOURNISSEUR_ENDPOINT + "/{idFournisseur}")
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(value = FOURNISSEUR_ENDPOINT + "/all")
    List<FournisseurDto> findAll();

    @DeleteMapping(value = FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
    void delete (@PathVariable("idFournisseur") Integer id);
}
