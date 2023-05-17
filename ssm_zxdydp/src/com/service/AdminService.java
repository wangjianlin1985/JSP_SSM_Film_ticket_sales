// 
// 
// 

package com.service;

import java.util.List;
import com.entity.Admin;
import org.springframework.stereotype.Service;

@Service("adminService")
public interface AdminService
{
    int insertAdmin(Admin p0);
    
    int updateAdmin(Admin p0);
    
    int deleteAdmin(String p0);
    
    List<Admin> getAllAdmin();
    
    List<Admin> getAdminByCond(Admin p0);
    
    List<Admin> getAdminByLike(Admin p0);
    
    Admin getAdminById(String p0);
}
