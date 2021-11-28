package com.project3.tpbooking.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DfResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public DfResponse() {
        code = 200;
        message = "OK";
    }

    public DfResponse(String message) {
        this.code = 200;
        this.message = message;
    }

    public DfResponse(String message, T data) {
        this.code = 200;
        this.message = message;
        this.data = data;
    }

    public DfResponse(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public DfResponse(String message, Integer code, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseEntity<DfResponse<T>> okEntity(T data) {
        return ResponseEntity.ok(ok(data));
    }

    public static <T> DfResponse<T> ok(T data) {
        DfResponse<T> response = new DfResponse<>();
        response.setData(data);
        return response;
    }

    public static <T> DfResponse<T> badRequest(String message) {
        return new DfResponse<>(message, HttpStatus.BAD_REQUEST.value());
    }
}

