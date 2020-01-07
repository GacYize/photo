package com.alice.photo.service.impl;



import com.alice.photo.common.util.Md5CryptUtil;
import com.alice.photo.model.TAdmin;
import com.alice.photo.service.IAdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Service(value="adminService")
public class AdminServiceImpl extends BaseService<TAdmin> implements IAdminService {

	

	@Override
	public TAdmin login(TAdmin admin) {
		if(StringUtils.isBlank(admin.getName()) || StringUtils.isBlank(admin.getPassword())) return null;
		admin.setPassword(Md5CryptUtil.getMD5String(admin.getPassword()));
		Example example = new Example(TAdmin.class);
		example.createCriteria().andCondition("name = ", admin.getName()).andCondition("password = " , admin.getPassword());
		List<TAdmin> list = mapper.selectByExample(example);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
		
	}

	
}
