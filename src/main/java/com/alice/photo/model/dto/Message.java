package com.alice.photo.model.dto;

import lombok.Data;

/**
 * @author ghj
 * @Description
 * @date 2020/1/10 15:50
 */
@Data
public class Message {
    private String id;
    private String msg;
    private String from;
    private String to;
}
