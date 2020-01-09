package com.alice.photo.dao;

import com.alice.photo.common.BaseMapper;
import com.alice.photo.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao extends BaseMapper<Product> {
    /**
     * 根据类型获取
     * @param type
     * @return
     */
    List<Product> findByType(@Param("type") Integer type);
}