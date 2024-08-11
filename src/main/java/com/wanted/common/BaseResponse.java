package com.wanted.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseResponse {

    private String message;

    public BaseResponse() {
        this.message = "success";
    }
}
