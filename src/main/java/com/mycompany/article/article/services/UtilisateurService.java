package com.mycompany.article.article.services;


import com.mycompany.article.article.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDto save (UtilisateurDto utilisateurDto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete (Integer id);
}
