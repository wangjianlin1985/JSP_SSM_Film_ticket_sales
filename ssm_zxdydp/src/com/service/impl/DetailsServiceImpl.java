// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Details;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.DetailsDAO;
import org.springframework.stereotype.Service;
import com.service.DetailsService;

@Service("detailsService")
public class DetailsServiceImpl implements DetailsService
{
    @Autowired
    @Resource
    private DetailsDAO detailsDAO;
    
    @Override
    public int insertDetails(final Details details) {
        return this.detailsDAO.insertDetails(details);
    }
    
    @Override
    public int updateDetails(final Details details) {
        return this.detailsDAO.updateDetails(details);
    }
    
    @Override
    public int deleteDetails(final String detailsid) {
        return this.detailsDAO.deleteDetails(detailsid);
    }
    
    @Override
    public List<Details> getAllDetails() {
        return this.detailsDAO.getAllDetails();
    }
    
    @Override
    public List<Details> getDetailsByCond(final Details details) {
        return this.detailsDAO.getDetailsByCond(details);
    }
    
    @Override
    public List<Details> getDetailsByLike(final Details details) {
        return this.detailsDAO.getDetailsByLike(details);
    }
    
    @Override
    public Details getDetailsById(final String detailsid) {
        return this.detailsDAO.getDetailsById(detailsid);
    }
}
