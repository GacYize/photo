package com.alice.photo.service.impl;


import com.alice.photo.model.TLevel;
import com.alice.photo.service.ILevelService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Service(value = "levelService")
public class LevelServiceImpl extends BaseService<TLevel> implements ILevelService {

	@Override
	public List<TLevel> getAllLevel() {
		Example example = new Example(TLevel.class);
		example.createCriteria().andCondition("status=",0);
		return mapper.selectByExample(example);
	}

}
