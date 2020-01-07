package com.alice.photo.service;


import com.alice.photo.model.TSpots;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface ISpotsService extends IService<TSpots> {
	
	List<TSpots> getAllSpots();
}
