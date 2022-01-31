package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import static com.mycompany.article.article.utils.Constants.APP_ROOT;

public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateur/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save (UtilisateurDto utilisateurDto);

    @GetMapping(value = APP_ROOT+ "/utilisateur/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(Integer id);

    @GetMapping(value = APP_ROOT+ "/utilisateur/{all}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/utilisateur/delete/{idUtilisateur}")
    void delete (Integer id);
}
