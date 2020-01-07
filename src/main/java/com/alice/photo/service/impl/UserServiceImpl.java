package com.alice.photo.service.impl;


import com.alice.photo.common.util.Md5CryptUtil;
import com.alice.photo.model.TUser;
import com.alice.photo.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Service(value = "userService")
public class UserServiceImpl extends BaseService<TUser> implements IUserService {

	@Override
	public TUser login(TUser user) {
		if (StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword()))
			return null;
		user.setPassword(Md5CryptUtil.getMD5String(user.getPassword()));
		Example example = new Example(TUser.class);
		example.createCriteria().andCondition("name = ", user.getName()).andCondition("password = ",
				user.getPassword());
		List<TUser> list = mapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

	@Override
	public int register(TUser user) {
		if (StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword()))
			return 0;
		user.setPassword(Md5CryptUtil.getMD5String(user.getPassword()));
		user.setCreatetime(new Date());
		return mapper.insert(user);
	}

	@Override
	public boolean checkUserByName(String name) {
		Example example = new Example(TUser.class);
		example.createCriteria().andCondition("name = ", name);
		List<TUser> list = mapper.selectByExample(example);
		if (list.isEmpty() || list == null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int updatePassword(TUser user) {
		user.setPassword(Md5CryptUtil.getMD5String(user.getPassword()));
		Example example = new Example(TUser.class);
		example.createCriteria().andCondition("name=",user.getName()).andCondition("tel=",user.getTel());
		return mapper.updateByExampleSelective(user, example);
	}

}
