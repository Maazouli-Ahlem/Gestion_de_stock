package com.mycompany.article.article.validator;

import com.mycompany.article.article.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate (ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("Ajouter le nom du client");
            errors.add("Ajouter le prenom du client");
            errors.add("Ajouter l'email' du client");
            errors.add("Ajouter le num tel du client");
        return errors;
        }

        if(StringUtils.hasLength(clientDto.getNom())){
            errors.add("Ajouter le nom du client");
        }
        if(StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Ajouter le prenom du client");
        }
        if(StringUtils.hasLength(clientDto.getEmail())){
            errors.add("Ajouter l'email' du client");
        }
        if(StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("Ajouter le num tel du client");
        }

         return errors;
    }
}
