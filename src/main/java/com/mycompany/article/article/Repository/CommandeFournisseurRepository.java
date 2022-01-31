package com.mycompany.article.article.Repository;

import com.mycompany.article.article.model.CommandeFournisseur;
import java.util.List;
import java.util.Optional;

import com.mycompany.article.article.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

  Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

  List<CommandeClient> findAllByFournisseurId(Integer id);
}
