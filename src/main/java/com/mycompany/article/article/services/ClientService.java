package com.mycompany.article.article.services;

import com.mycompany.article.article.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save (ClientDto clientDto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete (Integer id);
}
