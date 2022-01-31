package com.mycompany.article.article.services;


import com.mycompany.article.article.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDto save (EntrepriseDto entrepriseDto);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete (Integer id);
}
