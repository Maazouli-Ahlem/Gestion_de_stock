package com.mycompany.article.article.services.impl;


import com.mycompany.article.article.Repository.ClientRepository;
import com.mycompany.article.article.dto.ClientDto;
import com.mycompany.article.article.exception.EntityNotFoundException;
import com.mycompany.article.article.exception.ErrorCodes;
import com.mycompany.article.article.exception.InvalidEntityException;
import com.mycompany.article.article.model.Client;
import com.mycompany.article.article.services.ClientService;
import com.mycompany.article.article.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
      List<String> errors = ClientValidator.validate(clientDto);
      if(!errors.isEmpty()){
          log.error("Client is not valid {}", clientDto);
          throw new InvalidEntityException("La client n'est pas valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
      }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null){
                log.error("Client ID is null");
                return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        ClientDto clientDto = ClientDto.fromEntity(client.get());
        return Optional.of(clientDto).orElseThrow(() -> new EntityNotFoundException("Aucun client avec l'ID = "+id+ "n'est trouvee dans la BDD",ErrorCodes.CLIENT_NOT_FOUND));

    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Client ID is null");
            return ;
        }
        clientRepository.deleteById(id);
    }
}
