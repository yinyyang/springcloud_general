package com.springcloud.auth.exception;

import com.springcloud.auth.ajax.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

@Component
public class AuthResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) {

        if (e instanceof InvalidGrantException) {

            return new ResponseEntity(e.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }
}