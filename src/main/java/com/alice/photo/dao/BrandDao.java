package com.alice.photo.dao;

import com.alice.photo.common.BaseMapper;
import com.alice.photo.model.Brand;

import java.util.List;

public interface BrandDao extends BaseMapper<Brand> {
    @Override
    List<Brand> selectAll();
}