package com.alice.photo.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author ghj
 * @Description
 * @date 2020/1/7 15:46
 */
@Data
public class ReserveOrderDto {
    /**
     * 风格
     */
    private Integer styleType;

    /**
     * 套数
     */
    private Integer amount;

    /**
     * 档期
     */
    private String calendar;

    /**
     * 拍摄地点id
     */
    private Integer locationId;

    /**
     * 到店时间
     */
    private Date arrivalTime;
    /**
     * 手机
     */
    private String tel;
    /**
     * 姓名
     */
    private String name;
}
