package com.mycompany.article.article.Repository;

import com.mycompany.article.article.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
