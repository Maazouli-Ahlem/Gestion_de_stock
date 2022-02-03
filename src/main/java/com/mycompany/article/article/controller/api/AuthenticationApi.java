package com.mycompany.article.article.controller.api;

import com.mycompany.article.article.dto.auth.AuthenticationRequest;
import com.mycompany.article.article.dto.auth.AuthenticationResponse;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.mycompany.article.article.utils.Constants.AUTHENTICATION_ENDPOINT;

@Api("authentication")
public interface AuthenticationApi {

  @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
   public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request);

}
