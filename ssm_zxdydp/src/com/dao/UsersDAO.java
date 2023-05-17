// 
// 
// 

package com.dao;

import java.util.List;
import com.entity.Users;
import org.springframework.stereotype.Repository;

@Repository("usersDAO")
public interface UsersDAO
{
    int insertUsers(Users p0);
    
    int updateUsers(Users p0);
    
    int deleteUsers(String p0);
    
    List<Users> getAllUsers();
    
    List<Users> getUsersByCond(Users p0);
    
    List<Users> getUsersByLike(Users p0);
    
    Users getUsersById(String p0);
}
