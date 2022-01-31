package com.mycompany.article.article.services.impl;

import com.mycompany.article.article.Repository.ArticleRepository;
import com.mycompany.article.article.dto.ArticleDto;
import com.mycompany.article.article.exception.EntityNotFoundException;
import com.mycompany.article.article.exception.ErrorCodes;
import com.mycompany.article.article.exception.InvalidEntityException;
import com.mycompany.article.article.model.Article;
import com.mycompany.article.article.services.ArticleService;
import com.mycompany.article.article.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("L'article n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        ArticleDto articleDto= ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow(() -> new EntityNotFoundException("Aucun article avec l'ID = "+id+ "n'est trouvee dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)){
            log.error("Article Code is null");
            return null;
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        ArticleDto articleDto= ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow(() -> new EntityNotFoundException("Aucun article avec le code = "+codeArticle+ "n'est trouvee dans la BDD",ErrorCodes.ARTICLE_NOT_FOUND));

    }

    @Override
    public List<ArticleDto> findAll() {

        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return ;
        }
        articleRepository.deleteById(id);
    }
}
