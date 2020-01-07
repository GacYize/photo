package com.alice.photo.service;


import com.alice.photo.model.TLevel;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface ILevelService extends IService<TLevel> {

	List<TLevel> getAllLevel();

}
