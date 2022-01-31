package com.mycompany.article.article.services;

import com.mycompany.article.article.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save (FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    void delete (Integer id);
}
