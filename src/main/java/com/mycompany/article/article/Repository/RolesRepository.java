package com.mycompany.article.article.Repository;

import com.mycompany.article.article.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
