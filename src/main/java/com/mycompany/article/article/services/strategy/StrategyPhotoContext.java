package com.mycompany.article.article.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.mycompany.article.article.exception.ErrorCodes;
import com.mycompany.article.article.exception.InvalidOperationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

public class StrategyPhotoContext {


     private BeanFactory beanFactory;
     private Strategy strategy;

     private String context;
    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object savePhoto(String context, Integer id, InputStream photo, String title ) throws FlickrException {
        determinContext(context);
        return strategy.savePhoto(id, photo,title);
    }


    private void determinContext(String context){
        final String beanName = context + "Strategy";
        switch (context) {
            case "article":
                strategy = beanFactory.getBean(beanName,SaveArticlePhoto.class);
                break;
            case "client":
                strategy = beanFactory.getBean(beanName,SaveClientPhoto.class);
                break;
            case "entreprise":
                strategy = beanFactory.getBean(beanName,SaveEntreprisePhoto.class);
                break;
            case "fournisseur":
                strategy = beanFactory.getBean(beanName,SaveEntreprisePhoto.class);
                break;
            case "utilisateur":
                strategy = beanFactory.getBean(beanName,SaveUtilisateurPhoto.class);
                break;
            default: throw new InvalidOperationException("context inconnue", ErrorCodes.UNKNOWN_CONTEXT);

        }
    }
}
