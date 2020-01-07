package com.alice.photo.service.impl;


import com.alice.photo.model.TInfomation;
import com.alice.photo.service.IInfoService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Service(value = "infoService")
public class InfoServiceImpl extends BaseService<TInfomation> implements IInfoService {

	@Override
	public List<TInfomation> getAllInfo() {
		Example example = new Example(TInfomation.class);
		example.createCriteria().andCondition("status=",0);
		return mapper.selectByExample(example);
	}

}
