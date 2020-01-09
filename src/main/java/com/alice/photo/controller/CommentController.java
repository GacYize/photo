package com.alice.photo.controller;

import com.alice.photo.dao.LeaveMessageDao;
import com.alice.photo.model.LeaveMessage;
import com.alice.photo.model.TComment;
import com.alice.photo.model.TUser;
import com.alice.photo.service.ICommentService;
import com.alice.photo.vo.PageVO;
import com.alice.photo.vo.ReturnCodeType;
import com.alice.photo.vo.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzc 2017年3月1日
 */
@Controller
@Scope("prototype")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    private ReturnResult returnResult = new ReturnResult();

    @Resource(name = "commentService")
    private ICommentService commentService;
    @Autowired
    private LeaveMessageDao leaveMessageDao;

    /**
     * 添加评论
     *
     * @param comment
     * @param
     * @return
     */
    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult addInfo(TComment comment, HttpSession session) {
        returnResult.setStatus(ReturnCodeType.FAILURE);
        try {
            TUser user = (TUser) session.getAttribute("user");
            comment.setUserid(user.getId());
            comment.setCreatetime(new Date());
            commentService.insert(comment);
            returnResult.setStatus(ReturnCodeType.SUCCESS);
        } catch (Exception e) {
            logger.error("新增comment失败" + e);
        }
        return returnResult;

    }

    /**
     * 删除评论
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "deleteComment", method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult deleteComment(Integer id) {
        returnResult.setStatus(ReturnCodeType.FAILURE);
        try {

            commentService.deleteByPrimaryKey(id);
            returnResult.setStatus(ReturnCodeType.SUCCESS);
        } catch (Exception e) {
            logger.error("删除comment失败" + e);
        }
        return returnResult;

    }

    /**
     * 根据摄影师id查询评论
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "getCommentByPid", method = RequestMethod.GET)
    @ResponseBody
    public ReturnResult getCommentByPid(Integer pid) {
        returnResult.setStatus(ReturnCodeType.FAILURE);
        try {
            returnResult.setStatus(ReturnCodeType.SUCCESS).setData(commentService.getByPhotographerId(pid));
        } catch (Exception e) {
            logger.error("根据摄影师id查询评论" + e);
        }
        return returnResult;

    }

    /**
     * 分页获取comment
     *
     * @return
     */
    @RequestMapping(value = "getCommentListByPage", method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult getCommentListByPage(PageVO page) {
        returnResult.setStatus(ReturnCodeType.FAILURE);
        try {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            StringBuffer sql = new StringBuffer("SELECT DISTINCT * FROM t_comment WHERE 1=1");


            List<Map<String, Object>> results = commentService.selectPageBySQL(sql.toString(), page.getPage() - 1,
                    page.getRows());
            if (!results.isEmpty() && results != null) {
                int total = commentService.selectCount(new TComment());
                int rows = page.getRows();
                rows = rows == 0 ? 10 : rows;
                resultMap.put("total", (total % rows != 0 ? (total / rows + 1) : (total / rows)));
                resultMap.put("page", page.getPage());
                resultMap.put("records", total);
                resultMap.put("rows", results);
                returnResult.setStatus(ReturnCodeType.SUCCESS).setData(resultMap);
            }
        } catch (Exception e) {
            logger.error("分页获取comment失败" + e);
        }
        return returnResult;
    }


    @RequestMapping(value = "saveMessage", method = RequestMethod.GET)
    @ResponseBody
    public ReturnResult saveMessage(String content) {
        LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setContent(content);
        leaveMessage.setDate(new Date());
        leaveMessageDao.insert(leaveMessage);
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }


}
