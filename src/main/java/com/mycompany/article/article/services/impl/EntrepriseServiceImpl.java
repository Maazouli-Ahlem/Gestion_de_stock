package com.mycompany.article.article.services.impl;

import com.mycompany.article.article.Repository.EntrepriseRepository;
import com.mycompany.article.article.dto.ClientDto;
import com.mycompany.article.article.dto.EntrepriseDto;
import com.mycompany.article.article.exception.EntityNotFoundException;
import com.mycompany.article.article.exception.ErrorCodes;
import com.mycompany.article.article.exception.InvalidEntityException;
import com.mycompany.article.article.model.Entreprise;
import com.mycompany.article.article.services.EntrepriseService;
import com.mycompany.article.article.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("Entreprise is not valid {}", entrepriseDto);
            throw new InvalidEntityException("L'entreprise n'est pas valid", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null){
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);
        EntrepriseDto entrepriseDto = EntrepriseDto.fromEntity(entreprise.get());
        return Optional.of(entrepriseDto).orElseThrow(()-> new EntityNotFoundException("Aucune Entreprise avec l'ID = "+id+ "n'est trouvee dans la BDD", ErrorCodes.ENTREPRISE_NOT_FOUND));

    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Client ID is null");
            return ;
        }
        entrepriseRepository.deleteById(id);
    }
}
