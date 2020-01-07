package com.alice.photo.service;


import com.alice.photo.model.TInfomation;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface IInfoService extends IService<TInfomation> {
	
	List<TInfomation> getAllInfo();
}
