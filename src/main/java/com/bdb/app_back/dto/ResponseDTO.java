package com.bdb.app_back.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {
    private String status;
    private T data;
}
