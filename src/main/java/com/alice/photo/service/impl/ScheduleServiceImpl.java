package com.alice.photo.service.impl;

import com.alice.photo.common.util.DateFormater;
import com.alice.photo.dao.ScheduleDao;
import com.alice.photo.model.TSchedule;
import com.alice.photo.model.dto.ReserveOrderDto;
import com.alice.photo.service.IScheduleService;
import com.alice.photo.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzc 2017年2月12日
 */
@Service(value = "scheduleService")
public class ScheduleServiceImpl extends BaseService<TSchedule> implements IScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public ScheduleVO getScheduleByPhotographerId(Integer photoer_id, String year, String month) {
        ScheduleVO scheduleVO = new ScheduleVO();
        Example example = new Example(TSchedule.class);
        example.createCriteria().andCondition("photographerId=", photoer_id)
                .andCondition("DATE_FORMAT(`start`,'%Y')=", year)
                .andCondition("DATE_FORMAT(`start`,'%c')=", month)
                .andCondition("status=", 1);
        example.or().andCondition("photographerId=", photoer_id)
                .andCondition("DATE_FORMAT(`end`,'%Y')=", year)
                .andCondition("DATE_FORMAT(`end`,'%c')=", month)
                .andCondition("status=", 1);
        List<TSchedule> attemptList = mapper.selectByExample(example);
        scheduleVO.setAttempt(listToMap(attemptList));

        Example e = new Example(TSchedule.class);
        e.createCriteria().andCondition("photographerId=", photoer_id)
                .andCondition("DATE_FORMAT(`start`,'%Y')=", year)
                .andCondition("DATE_FORMAT(`start`,'%c')=", month)
                .andCondition("status=", 2);
        e.or().andCondition("photographerId=", photoer_id)
                .andCondition("DATE_FORMAT(`end`,'%Y')=", year)
                .andCondition("DATE_FORMAT(`end`,'%c')=", month)
                .andCondition("status=", 2);
        List<TSchedule> scheduleList = mapper.selectByExample(e);
        List<TSchedule> list = new ArrayList<TSchedule>();
        for (TSchedule schedule : scheduleList) {
            schedule.setEnd(DateFormater.getNextUpdateDate(schedule.getEnd(), 1));
            list.add(schedule);
        }

        scheduleVO.setSchedule(listToMap(list));
        return scheduleVO;
    }

    public static List<Map<String, Object>> listToMap(List<TSchedule> list) {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        for (TSchedule schedule : list) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", DateFormater.dateToString(DateFormater.FORMART1, schedule.getStart()));
            map.put("end", DateFormater.dateToString(DateFormater.FORMART1, schedule.getEnd()));
            resultList.add(map);
        }
        return resultList;

    }

    @Override
    public Boolean saveOrderInfo(ReserveOrderDto dto) {
        try {
            TSchedule tSchedule = new TSchedule();
            tSchedule.setName(dto.getName());
            tSchedule.setTel(dto.getTel());
            tSchedule.setArrivalTime(dto.getArrivalTime());
            tSchedule.setStyleType(dto.getStyleType());
            tSchedule.setAmount(dto.getAmount());
            tSchedule.setCalendar(dto.getCalendar());
            tSchedule.setLocationId(dto.getLocationId());
            scheduleDao.insert(tSchedule);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
