package com.alice.photo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 
 * @author hzc 2017年2月12日
 *
 */
@Table(name = "t_user")
@Accessors(chain = true)
@Data
public class TUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    private String tel;

    private String email;

    private Date createtime;

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}