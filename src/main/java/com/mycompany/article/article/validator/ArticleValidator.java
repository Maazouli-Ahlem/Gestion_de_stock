package com.mycompany.article.article.validator;

import com.mycompany.article.article.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate (ArticleDto articleDto){
        List<String> errors = new ArrayList<>();

        if (articleDto == null){
            errors.add("ajouter le code de l'article'");
            errors.add("ajouter la Designation de l'article'");
            errors.add("ajouter le Prix Unitaire HT de l'article'");
            errors.add("ajouter le Taux Tva de l'article'");
            errors.add("ajouter le Prix Unitaire Ttc de l'article'");
            errors.add("ajouter une categorie pour l'article'");
            return errors;
        }
        if (!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("ajouter le code de l'article'");
        }
        if (!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("ajouter la Designation de l'article'");
        }
        if (articleDto.getPrixUnitaireHt() == null){
            errors.add("ajouter le Prix Unitaire HT de l'article'");
        }
        if (articleDto.getTauxTva() == null){
            errors.add("ajouter le Taux Tva de l'article'");
        }
        if (articleDto.getPrixUnitaireTtc() == null){
            errors.add("ajouter le Prix Unitaire Ttc de l'article'");
        }
        if (articleDto.getCategory() == null){
            errors.add("ajouter une categorie pour l'article'");
        }

        return errors;
    }
}
