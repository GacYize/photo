package com.alice.photo.service.impl;



import com.alice.photo.model.TSpots;
import com.alice.photo.service.ISpotsService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Service(value = "spotsService")
public class SpotsServiceImpl extends BaseService<TSpots> implements ISpotsService {

	@Override
	public List<TSpots> getAllSpots() {
		Example example = new Example(TSpots.class);
		example.createCriteria().andCondition("status=",0);
		
		return mapper.selectByExample(example);
	}

	
}
