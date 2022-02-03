package com.mycompany.article.article.dto;

import com.mycompany.article.article.model.Article;
import com.mycompany.article.article.model.MvtStk;
import com.mycompany.article.article.model.SourceMvtStk;
import com.mycompany.article.article.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {

    private Integer id;
    private ArticleDto articlev;
    private Instant dateMvt;
    private BigDecimal quantite;
    private TypeMvtStk typeMvtStk;
    private SourceMvtStk sourceMvt;
    private Integer idEntreprise;


    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .typeMvtStk(mvtStk.getTypeMvtStk())
                .idEntreprise(mvtStk.getIdEntreprise())
                .sourceMvt(mvtStk.getSourceMvt())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setTypeMvtStk(dto.getTypeMvtStk());
        mvtStk.setIdEntreprise(dto.getIdEntreprise());
        mvtStk.setSourceMvt(dto.getSourceMvt());

        return mvtStk;
    }
}
