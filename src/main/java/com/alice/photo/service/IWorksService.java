package com.alice.photo.service;



import com.alice.photo.model.TWorks;
import com.alice.photo.vo.WorksVO;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface IWorksService extends IService<TWorks> {

	List<Map<String,Object>> getWorksByPhotographerId(Integer id);

	WorksVO getWorks(Integer id);
	

	
}
