package com.mycompany.article.article.services.impl;

import com.mycompany.article.article.Repository.MvtStkRepository;
import com.mycompany.article.article.dto.MvtStkDto;
import com.mycompany.article.article.services.ArticleService;
import com.mycompany.article.article.services.MvtStkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

    private MvtStkRepository repository;
    private ArticleService articleService;

    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        return null;
    }

    @Override
    public List<MvtStkDto> mvtStkArticle(Integer idArticle) {
        return null;
    }

    @Override
    public MvtStkDto entreeStock(MvtStkDto dto) {
        return null;
    }

    @Override
    public MvtStkDto sortieStock(MvtStkDto dto) {
        return null;
    }

    @Override
    public MvtStkDto correctionStockPos(MvtStkDto dto) {
        return null;
    }

    @Override
    public MvtStkDto correctionStockNeg(MvtStkDto dto) {
        return null;
    }
}
