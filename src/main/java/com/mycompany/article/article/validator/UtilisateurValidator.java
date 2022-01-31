package com.mycompany.article.article.validator;

import com.mycompany.article.article.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate (UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("ajouter le nom d'utilisateur ");
            errors.add("ajouter le prenom d'utilisateur ");
            errors.add("ajouter l'email d'utilisateur ");
            errors.add("ajouter le Mot De Pass d'utilisateur ");
            errors.add("ajouter l'addresse d'utilisateur ");
            errors.add("ajouter la Date De Naissance d'utilisateur ");
           return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("ajouter le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("ajouter l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("ajouter le Mot De Passe d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("ajouter le Prenom d'utilisateur");
        }
        if (utilisateurDto.getDateDeNaissance() == null ){
            errors.add("ajouter la Date De Naissance d'utilisateur");
        }

        if (utilisateurDto.getAdresse() == null ){
            errors.add("ajouter l'addresse d'utilisateur");
        } else {
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAddress1())){
                errors.add("l'addresse 1 est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getAddress2())){
                errors.add("l'addresse 2 est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("le Code Postale est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("la Pays est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("la ville est obligatoire");
            }
        }


        return errors;
    }
}
