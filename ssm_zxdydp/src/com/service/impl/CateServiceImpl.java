// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Cate;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.CateDAO;
import org.springframework.stereotype.Service;
import com.service.CateService;

@Service("cateService")
public class CateServiceImpl implements CateService
{
    @Autowired
    @Resource
    private CateDAO cateDAO;
    
    @Override
    public int insertCate(final Cate cate) {
        return this.cateDAO.insertCate(cate);
    }
    
    @Override
    public int updateCate(final Cate cate) {
        return this.cateDAO.updateCate(cate);
    }
    
    @Override
    public int deleteCate(final String cateid) {
        return this.cateDAO.deleteCate(cateid);
    }
    
    @Override
    public List<Cate> getAllCate() {
        return this.cateDAO.getAllCate();
    }
    
    @Override
    public List<Cate> getCateFront() {
        return this.cateDAO.getCateFront();
    }
    
    @Override
    public List<Cate> getCateByCond(final Cate cate) {
        return this.cateDAO.getCateByCond(cate);
    }
    
    @Override
    public List<Cate> getCateByLike(final Cate cate) {
        return this.cateDAO.getCateByLike(cate);
    }
    
    @Override
    public Cate getCateById(final String cateid) {
        return this.cateDAO.getCateById(cateid);
    }
}
