package com.mycompany.article.article.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ligneCommandeFournisseur")
public class LigneCommandeFournisseur extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "commandeFournisseur_id")
    private CommandeFournisseur commandeFournisseur;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

}
