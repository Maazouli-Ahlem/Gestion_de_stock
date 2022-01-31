package com.mycompany.article.article.dto;

import com.mycompany.article.article.model.Address;
import com.mycompany.article.article.model.CommandeFournisseur;
import com.mycompany.article.article.model.Fournisseur;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private String photo;
    private String email;
    private String numTel;
    private List<CommandeFournisseurDto> commandeFournisseursDto;
    private AddressDto address;
    private Integer idEntreprise;


    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .address(AddressDto.fromEntity(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .email(fournisseur.getEmail())
                .numTel(fournisseur.getNumTel())
                .idEntreprise(fournisseur.getIdEntreprise())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setAdresse(AddressDto.toEntity(dto.getAddress()));
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setEmail(dto.getEmail());
        fournisseur.setNumTel(dto.getNumTel());

        return fournisseur;
    }
}
