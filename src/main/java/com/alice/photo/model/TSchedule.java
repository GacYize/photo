package com.alice.photo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Table(name = "t_schedule")
@Data
public class TSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer userid;

	private Integer photographerid;

	private Date start;

	private Date end;

	private Date createtime;

	private String status;
	
	private String name;
	
	private String sex;
	
	private String tel;
	
	private String qq;
	
	private String remarks;
	/**
	 * 风格类型
	 */
	@Column(name = "style_type")
	private Integer styleType;

	/**
	 * 套数
	 */
	private Integer amount;

	/**
	 * 档期
	 */
	private String calendar;

	/**
	 * 拍摄地点id
	 */
	@Column(name = "location_id")
	private Integer locationId;

	/**
	 * 到店时间
	 */
	@Column(name = "arrival_time")
	private Date arrivalTime;


	@Override
	public String toString() {
		return "TSchedule [id=" + id + ", userid=" + userid + ", photographerid=" + photographerid + ", start=" + start
				+ ", end=" + end + ", createtime=" + createtime + ", status=" + status + ", name=" + name + ", sex="
				+ sex + ", tel=" + tel + ", qq=" + qq + ", remarks=" + remarks + "]";
	}

	
	
}