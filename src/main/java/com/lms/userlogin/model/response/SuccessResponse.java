package com.lms.userlogin.model.response;

import lombok.Getter;
import lombok.ToString;

/**
 * Success response model class.
 * 
 * @author Deepak Mandal
 *
 */
@Getter
@ToString
public class SuccessResponse extends Response {
    private Object data;
    
    public SuccessResponse(int status) {
        super(status);
    }
    
    public SuccessResponse(Object data, int status) {
        super(status);
        this.data = data;
    }
}    
