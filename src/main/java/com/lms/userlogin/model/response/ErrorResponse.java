package com.lms.userlogin.model.response;

import lombok.Getter;
import lombok.ToString;

/**
 * Error response model class.
 * 
 * @author Deepak Mandal
 *
 */
@Getter
@ToString
public class ErrorResponse extends Response {
    private String error;

    public ErrorResponse(String error, int status) {
        super(status);
        this.error = error;
    }
}
