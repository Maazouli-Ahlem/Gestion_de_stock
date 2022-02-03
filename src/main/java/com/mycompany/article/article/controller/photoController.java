package com.mycompany.article.article.controller;

import com.flickr4java.flickr.FlickrException;
import com.mycompany.article.article.controller.api.PhotoApi;
import com.mycompany.article.article.services.strategy.StrategyPhotoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class photoController implements PhotoApi {

    private StrategyPhotoContext strategyPhotoContext;

    @Autowired
    public photoController(StrategyPhotoContext strategyPhotoContext) {
        this.strategyPhotoContext = strategyPhotoContext;
    }

    @Override
    public Object savePhoto(String context, Integer id, MultipartFile photo, String title) throws IOException, FlickrException {
        return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);

    }
}
