package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.APP_ROOT;
import static com.mycompany.article.article.utils.Constants.ENTREPRISE_ENDPOINT;

@Api("/entreprises")
public interface EntrepriseApi {

    @PostMapping(value = ENTREPRISE_ENDPOINT + "/create")
    EntrepriseDto save (@RequestBody EntrepriseDto entrepriseDto);

    @GetMapping(value = ENTREPRISE_ENDPOINT + "/{idEntreprise}")
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(value = ENTREPRISE_ENDPOINT + "/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}")
    void delete (@PathVariable("idEntreprise") Integer id);
}
