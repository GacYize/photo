package com.alice.photo.service;


import com.alice.photo.model.TSchedule;
import com.alice.photo.model.dto.ReserveOrderDto;
import com.alice.photo.vo.ScheduleVO;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
public interface IScheduleService extends IService<TSchedule> {

	ScheduleVO getScheduleByPhotographerId(Integer photoer_id, String year, String month);

    /**
     * 保存预订信息
     * @param reserveOrderDto
     * @return
     */
    Boolean saveOrderInfo(ReserveOrderDto reserveOrderDto);
}
