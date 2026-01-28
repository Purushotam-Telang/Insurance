package com.purushotam.Insurance.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.ZonedDateTime;


@Data
public class ApiResponse<T> {
    private T body;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss z")
    private ZonedDateTime timestamp;
    private ApiError apiError;

    public ApiResponse(){
        this.timestamp = ZonedDateTime.now();
    }
    public ApiResponse(T body){
        this();
        this.body = body;
    }
    public ApiResponse(ApiError apiError){
        this();
        this.apiError = apiError;
    }
}
