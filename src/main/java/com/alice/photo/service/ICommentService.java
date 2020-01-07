package com.alice.photo.service;


import com.alice.photo.model.TComment;
import com.alice.photo.vo.CommentVo;

import java.util.List;

/**
 * 
 * @author hzc 2017年3月1日
 *
 */
public interface ICommentService extends IService<TComment> {

    List<CommentVo> getByPhotographerId(Integer pid);
}
