package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.APP_ROOT;

public interface EntrepriseApi {

    @PostMapping(value = APP_ROOT + "/entreprise/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save (EntrepriseDto entrepriseDto);

    @GetMapping(value = APP_ROOT+ "/entreprise/{idEntreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(Integer id);

    @GetMapping(value = APP_ROOT+ "/entreprise/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/entreprise/delete/{idEntreprise}")
    void delete (Integer id);
}
