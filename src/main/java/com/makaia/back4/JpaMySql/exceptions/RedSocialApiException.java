package com.makaia.back4.JpaMySql.exceptions;

import org.springframework.http.HttpStatusCode;

public class RedSocialApiException extends RuntimeException {

    private HttpStatusCode code;

    public RedSocialApiException(String message) {
        super(message);
    }

    public RedSocialApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedSocialApiException(String message, Throwable cause, HttpStatusCode code) {
        super(message, cause);
        this.code = code;
    }

    public RedSocialApiException(String message, HttpStatusCode code) {
        super(message);
        this.code = code;
    }

    public HttpStatusCode getCode() {
        return code;
    }
}
