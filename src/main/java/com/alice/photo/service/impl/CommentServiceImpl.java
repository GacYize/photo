package com.alice.photo.service.impl;


import com.alice.photo.dao.ICommentDao;
import com.alice.photo.model.TComment;
import com.alice.photo.service.ICommentService;
import com.alice.photo.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hzc 2017年3月1日
 */
@Service(value = "commentService")
public class CommentServiceImpl extends BaseService<TComment> implements ICommentService {
    @Autowired
    private ICommentDao commentDao;

    @Override
    public List<CommentVo> getByPhotographerId(Integer pid) {
        return commentDao.findByPhotographerId(pid);
    }
}
