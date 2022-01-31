package com.mycompany.article.article.validator;

import com.mycompany.article.article.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto commandeClientDto) {
        List<String> errors = new ArrayList<>();
        if (commandeClientDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(commandeClientDto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (commandeClientDto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }

        if (commandeClientDto.getClient() == null || commandeClientDto.getClient().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }
}
