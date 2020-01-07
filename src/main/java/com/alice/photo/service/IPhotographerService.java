package com.alice.photo.service;


import com.alice.photo.model.TPhotographer;

import java.text.ParseException;
import java.util.List;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface IPhotographerService extends IService<TPhotographer> {

	List<String> selectByStartEnd(String start, String end) throws IllegalArgumentException, ParseException;
}
