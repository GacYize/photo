package com.alice.photo.dao;

import com.alice.photo.common.BaseMapper;
import com.alice.photo.model.TComment;
import com.alice.photo.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author hzc 2017年3月1日
 *
 */
public interface ICommentDao extends BaseMapper<TComment> {

    List<CommentVo> findByPhotographerId(@Param("pid") Integer pid);
}