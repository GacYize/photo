package com.alice.photo.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "t_brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 品牌名称
     */
    @Column(name = "brandName")
    private String brandname;

    /**
     * 介绍描述
     */
    private String describe;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandname=").append(brandname);
        sb.append(", describe=").append(describe);
        sb.append("]");
        return sb.toString();
    }
}