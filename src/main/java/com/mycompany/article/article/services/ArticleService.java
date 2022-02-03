package com.mycompany.article.article.services;

import com.mycompany.article.article.dto.ArticleDto;
import com.mycompany.article.article.dto.LigneCommandeClientDto;
import com.mycompany.article.article.dto.LigneCommandeFournisseurDto;
import com.mycompany.article.article.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {
    ArticleDto save (ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriqueCommandeCLient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    List<ArticleDto> findAll();

    void delete (Integer id);

}
