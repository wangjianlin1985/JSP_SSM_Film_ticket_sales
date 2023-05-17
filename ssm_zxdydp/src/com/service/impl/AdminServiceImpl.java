// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Admin;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.AdminDAO;
import org.springframework.stereotype.Service;
import com.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService
{
    @Autowired
    @Resource
    private AdminDAO adminDAO;
    
    @Override
    public int insertAdmin(final Admin admin) {
        return this.adminDAO.insertAdmin(admin);
    }
    
    @Override
    public int updateAdmin(final Admin admin) {
        return this.adminDAO.updateAdmin(admin);
    }
    
    @Override
    public int deleteAdmin(final String adminid) {
        return this.adminDAO.deleteAdmin(adminid);
    }
    
    @Override
    public List<Admin> getAllAdmin() {
        return this.adminDAO.getAllAdmin();
    }
    
    @Override
    public List<Admin> getAdminByCond(final Admin admin) {
        return this.adminDAO.getAdminByCond(admin);
    }
    
    @Override
    public List<Admin> getAdminByLike(final Admin admin) {
        return this.adminDAO.getAdminByLike(admin);
    }
    
    @Override
    public Admin getAdminById(final String adminid) {
        return this.adminDAO.getAdminById(adminid);
    }
}
