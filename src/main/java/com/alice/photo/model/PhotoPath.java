package com.alice.photo.model;

import javax.persistence.*;

@Table(name = "t_photo_path")
public class PhotoPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 照片类型 1：样片，2：客片，3：旅拍
     */
    private Integer type;

    /**
     * 图片地址
     */
    private String path;

    /**
     * 旅拍地址id
     */
    @Column(name = "location_id")
    private Integer locationId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取照片类型 1：样片，2：客片，3：旅拍
     *
     * @return type - 照片类型 1：样片，2：客片，3：旅拍
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置照片类型 1：样片，2：客片，3：旅拍
     *
     * @param type 照片类型 1：样片，2：客片，3：旅拍
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取图片地址
     *
     * @return path - 图片地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置图片地址
     *
     * @param path 图片地址
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取旅拍地址id
     *
     * @return location_id - 旅拍地址id
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * 设置旅拍地址id
     *
     * @param locationId 旅拍地址id
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", path=").append(path);
        sb.append(", locationId=").append(locationId);
        sb.append("]");
        return sb.toString();
    }
}