package com.alice.photo.service;


import com.alice.photo.model.TAdmin;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface IAdminService extends IService<TAdmin> {
	
	TAdmin login(TAdmin admin);

}
