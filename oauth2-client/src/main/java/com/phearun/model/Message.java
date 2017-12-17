package com.phearun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Integer id;
    private String text;

    public Message(String text) {
        this.text = text;
    }
}
