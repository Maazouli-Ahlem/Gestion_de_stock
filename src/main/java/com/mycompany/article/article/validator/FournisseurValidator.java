package com.mycompany.article.article.validator;

import com.mycompany.article.article.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate (FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();
        if(fournisseurDto == null){
            errors.add("Ajouter le nom du fournisseur");
            errors.add("Ajouter le prenom du fournisseur");
            errors.add("Ajouter l'email' du fournisseur");
            errors.add("Ajouter le num tel du fournisseur");
            return errors;
        }

        if(StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Ajouter le nom du fournisseur");
        }
        if(StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Ajouter le prenom du fournisseur");
        }
        if(StringUtils.hasLength(fournisseurDto.getEmail())){
            errors.add("Ajouter l'email' du fournisseur");
        }
        if(StringUtils.hasLength(fournisseurDto.getNumTel())){
            errors.add("Ajouter le num tel du fournisseur");
        }

        return errors;
    }
}
