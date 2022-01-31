package com.mycompany.article.article.services.impl;

import com.mycompany.article.article.Repository.UtilisateurRepository;
import com.mycompany.article.article.dto.UtilisateurDto;
import com.mycompany.article.article.exception.EntityNotFoundException;
import com.mycompany.article.article.exception.ErrorCodes;
import com.mycompany.article.article.exception.InvalidEntityException;
import com.mycompany.article.article.model.Utilisateur;
import com.mycompany.article.article.services.UtilisateurService;
import com.mycompany.article.article.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is not valid {}", utilisateurDto);
            throw new InvalidEntityException("L'utilisateur n'est pas valid", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto)));

    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null){
            log.error("Utilisateur ID is null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        UtilisateurDto utilisateurDto = UtilisateurDto.fromEntity(utilisateur.get());
        return Optional.of(utilisateurDto).orElseThrow(()-> new EntityNotFoundException("Aucun utilisateur avec l'ID = "+id+ "n'est trouvee dans la BDD", ErrorCodes.UTILISATEUR_NOT_FOUND));

    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("utilisateur ID is null");
            return ;
        }
        utilisateurRepository.deleteById(id);
    }
}
