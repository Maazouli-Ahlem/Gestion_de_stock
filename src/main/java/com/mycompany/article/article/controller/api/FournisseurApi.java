package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.APP_ROOT;

public interface FournisseurApi {

    @PostMapping(value = APP_ROOT + "/fournisseur/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save (FournisseurDto fournisseurDto);

    @GetMapping(value = APP_ROOT+ "/fournisseur/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(Integer id);

    @GetMapping(value = APP_ROOT+ "/fournisseur/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/fournisseur/delete/{idFournisseur}")
    void delete (Integer id);
}
