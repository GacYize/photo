package com.alice.photo.vo;

import com.alice.photo.common.util.DateFormater;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.format.DataFormatDetector;
import lombok.Data;

import java.util.Date;

/**
 * @author ghj
 * @Description
 * @date 2020/1/7 11:46
 */
@Data
public class CommentVo {
    private String comment;
    @JsonFormat(pattern = DateFormater.FORMART1)
    private Date createTime;
    private String name;

}
