package com.alice.photo.service.impl;


import com.alice.photo.model.TLabel;
import com.alice.photo.service.ILabelService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Service(value = "labelService")
public class LabelServiceImpl extends BaseService<TLabel> implements ILabelService {

	@Override
	public List<TLabel> getAllLabel() {
		Example example = new Example(TLabel.class);
		example.createCriteria().andCondition("status=",0);
		return mapper.selectByExample(example);
	}

}
