package com.alice.photo.service;


import com.alice.photo.model.TLabel;

import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface ILabelService extends IService<TLabel> {
	
	List<TLabel> getAllLabel();

}
