// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Users;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.UsersDAO;
import org.springframework.stereotype.Service;
import com.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService
{
    @Autowired
    @Resource
    private UsersDAO usersDAO;
    
    @Override
    public int insertUsers(final Users users) {
        return this.usersDAO.insertUsers(users);
    }
    
    @Override
    public int updateUsers(final Users users) {
        return this.usersDAO.updateUsers(users);
    }
    
    @Override
    public int deleteUsers(final String usersid) {
        return this.usersDAO.deleteUsers(usersid);
    }
    
    @Override
    public List<Users> getAllUsers() {
        return this.usersDAO.getAllUsers();
    }
    
    @Override
    public List<Users> getUsersByCond(final Users users) {
        return this.usersDAO.getUsersByCond(users);
    }
    
    @Override
    public List<Users> getUsersByLike(final Users users) {
        return this.usersDAO.getUsersByLike(users);
    }
    
    @Override
    public Users getUsersById(final String usersid) {
        return this.usersDAO.getUsersById(usersid);
    }
}
