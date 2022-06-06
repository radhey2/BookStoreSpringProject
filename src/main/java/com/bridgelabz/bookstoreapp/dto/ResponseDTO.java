package com.bridgelabz.bookstoreapp.dto;

import antlr.Token;
import com.bridgelabz.bookstoreapp.modal.UserData;
import lombok.Data;

public @Data  class ResponseDTO {
    private String message;
    private Object data;

 //   public String token;


    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
        //this.token = token;

    }

    public ResponseDTO() {

    }
}
