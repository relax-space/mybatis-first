package com.example.demo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData<T>  implements Serializable {
    private static final long serialVersionUID = -3744972816344015035L;
    private T data;
    private int code;
    private String message;

    public ResponseData() {
    }

    public ResponseData(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
