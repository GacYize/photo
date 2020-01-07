package com.alice.photo.service;


import com.alice.photo.model.TUser;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface IUserService extends IService<TUser> {
	
	TUser login(TUser user);

	int register(TUser user);
	
	boolean checkUserByName(String name);
	
	int updatePassword(TUser user);
}
