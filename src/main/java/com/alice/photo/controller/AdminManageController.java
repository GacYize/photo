package com.alice.photo.controller;

import com.alice.photo.common.util.OperationFileUtil;
import com.alice.photo.dao.BrandDao;
import com.alice.photo.dao.LeaveMessageDao;
import com.alice.photo.dao.PhotoPathDao;
import com.alice.photo.dao.ProductDao;
import com.alice.photo.model.Brand;
import com.alice.photo.model.LeaveMessage;
import com.alice.photo.model.PhotoPath;
import com.alice.photo.model.Product;
import com.alice.photo.vo.ReturnCodeType;
import com.alice.photo.vo.ReturnResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ghj
 * @Description
 * @date 2020/1/7 16:33
 */
@RestController
@RequestMapping("/admin/manage")
@Scope("prototype")
public class AdminManageController {
    @Autowired
    private LeaveMessageDao leaveMessageDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private PhotoPathDao photoPathDao;
    @Autowired
    private ProductDao productDao;
    @Value("${upload.path}")
    private String filePath;
    private ReturnResult returnResult = new ReturnResult();

    /**
     * 分页获取所有留言
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getAllMsg/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ReturnResult getAllMessage(@PathVariable("pageNum") Integer pageNum,
                                      @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaveMessage> leaveMessageList = leaveMessageDao.selectAll();
        return returnResult.setStatus(ReturnCodeType.SUCCESS).setData(new PageInfo<LeaveMessage>(leaveMessageList));
    }

    /**
     * 根据留言id删除
     *
     * @param msgId
     * @return
     */
    @RequestMapping(value = "delMsgById/{msgId}", method = RequestMethod.GET)
    public ReturnResult getAllMessage(@PathVariable("msgId") Integer msgId) {
        leaveMessageDao.deleteByPrimaryKey(msgId);
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }

    /**
     * 清空留言
     *
     * @return
     */
    @RequestMapping(value = "delMsgAll", method = RequestMethod.GET)
    public ReturnResult getAllMessage() {
        leaveMessageDao.deleteAll();
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }

    /**
     * 保存留言
     *
     * @param id
     * @param content
     * @return
     */
    @RequestMapping(value = "saveMsg", method = RequestMethod.POST)
    public ReturnResult saveMsg(Integer id, String content) {
        if (id != null) {
            LeaveMessage leaveMessage = new LeaveMessage();
            leaveMessage.setId(id);
            leaveMessage.setContent(content);
            leaveMessage.setDate(new Date());
            leaveMessageDao.updateByPrimaryKey(leaveMessage);
        } else {
            LeaveMessage leaveMessage = new LeaveMessage();
            leaveMessage.setContent(content);
            leaveMessage.setDate(new Date());
            leaveMessageDao.insert(leaveMessage);
        }
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }

    /**
     * 获取品牌介绍
     *
     * @return
     */
    @RequestMapping(value = "getBrandInfo", method = RequestMethod.GET)
    public ReturnResult getBrandInfo() {
        List<Brand> brands = brandDao.selectAll();
        return returnResult.setStatus(ReturnCodeType.SUCCESS).setData(brands);
    }

    /**
     * 保存品牌介绍信息
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "saveBrand", method = RequestMethod.POST)
    public ReturnResult saveBrand(@RequestBody Brand brand) {
        Integer id = brand.getId();
        if (id != null) {
            brandDao.updateByPrimaryKey(brand);
        } else {
            brandDao.insert(brand);
        }
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }

    /**
     * 删除品牌介绍
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delBrand/{id}", method = RequestMethod.GET)
    public ReturnResult delBrand(@PathVariable("id") Integer id) {
        brandDao.deleteByPrimaryKey(id);
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }

    /**
     * 文件上传
     *
     * @param request
     * @param type               1：产品照片，2：门店照片
     * @param productId          产品id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public ReturnResult uploadFile( MultipartFile file, HttpServletRequest request,Integer type, Integer productId) throws Exception {
        String dir = request.getServletContext().getRealPath(filePath);
        System.out.println(System.getProperty("user.dir")+System.getProperty("file.separator")+"WEB-INF");
        String filePath = OperationFileUtil.upload(file, dir);
        PhotoPath photoPath = new PhotoPath();
        photoPath.setFileName(file.getOriginalFilename());
        photoPath.setPath(filePath);
        photoPath.setType(type);
        photoPath.setProductId(productId);
        photoPathDao.insert(photoPath);
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }

    /**
     * 根据产品类型获取列表
     *
     * @param type
     * @return
     */
    @RequestMapping(value = "getAllProductByType/{type}", method = RequestMethod.GET)
    public ReturnResult getAllProductByType(@PathVariable("type") Integer type) {
        List<Product> productList = productDao.findByType(type);
        return returnResult.setStatus(ReturnCodeType.SUCCESS).setData(productList);
    }

    /**
     * 保存产品信息
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "saveProduct", method = RequestMethod.POST)
    public ReturnResult saveProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            productDao.updateByPrimaryKey(product);
        } else {
            productDao.insert(product);
        }
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }

    /**
     * 删除产品信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delProduct/{id}", method = RequestMethod.GET)
    public ReturnResult delProduct(@PathVariable("id") Integer id) {
        productDao.deleteByPrimaryKey(id);
        return returnResult.setStatus(ReturnCodeType.SUCCESS);
    }



}
