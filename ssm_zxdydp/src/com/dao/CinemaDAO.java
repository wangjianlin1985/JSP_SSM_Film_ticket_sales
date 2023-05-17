// 
// 
// 

package com.dao;

import java.util.List;
import com.entity.Cinema;
import org.springframework.stereotype.Repository;

@Repository("cinemaDAO")
public interface CinemaDAO
{
    int insertCinema(Cinema p0);
    
    int updateCinema(Cinema p0);
    
    int deleteCinema(String p0);
    
    List<Cinema> getAllCinema();
    
    List<Cinema> getCinemaByCond(Cinema p0);
    
    List<Cinema> getCinemaByLike(Cinema p0);
    
    Cinema getCinemaById(String p0);
}
