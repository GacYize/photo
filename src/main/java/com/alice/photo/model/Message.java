package com.alice.photo.model;

import lombok.Data;

/**
 * @author ghj
 * @Description
 * @date 2020/1/9 17:01
 */
@Data
public class Message {
    private String id;
    private String msg;
    private String from;
    private String to;
}
