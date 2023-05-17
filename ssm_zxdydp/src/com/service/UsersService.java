// 
// 
// 

package com.service;

import java.util.List;
import com.entity.Users;
import org.springframework.stereotype.Service;

@Service("usersService")
public interface UsersService
{
    int insertUsers(Users p0);
    
    int updateUsers(Users p0);
    
    int deleteUsers(String p0);
    
    List<Users> getAllUsers();
    
    List<Users> getUsersByCond(Users p0);
    
    List<Users> getUsersByLike(Users p0);
    
    Users getUsersById(String p0);
}
