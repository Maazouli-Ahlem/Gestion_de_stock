package com.mycompany.article.article.controller;

import com.mycompany.article.article.controller.api.FournisseurApi;
import com.mycompany.article.article.dto.FournisseurDto;
import com.mycompany.article.article.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class Fournisseurcontroller implements FournisseurApi {

    private FournisseurService fournisseurService;

    @Autowired
    public Fournisseurcontroller(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
         fournisseurService.delete(id);
    }
}
