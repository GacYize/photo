package com.alice.photo.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "t_photo_path")
@Data
public class PhotoPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 照片类型 1：产品照片，2：门店照片
     */
    private Integer type;

    /**
     * 图片地址
     */
    private String path;
    /**
     * 文件名
     */
    @Column(name = "file_name")
    private String fileName;
    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", path=").append(path);
        sb.append(", locationId=").append(productId);
        sb.append("]");
        return sb.toString();
    }
}