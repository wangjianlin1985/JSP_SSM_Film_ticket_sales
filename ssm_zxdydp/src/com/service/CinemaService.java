// 
// 
// 

package com.service;

import java.util.List;
import com.entity.Cinema;
import org.springframework.stereotype.Service;

@Service("cinemaService")
public interface CinemaService
{
    int insertCinema(Cinema p0);
    
    int updateCinema(Cinema p0);
    
    int deleteCinema(String p0);
    
    List<Cinema> getAllCinema();
    
    List<Cinema> getCinemaByCond(Cinema p0);
    
    List<Cinema> getCinemaByLike(Cinema p0);
    
    Cinema getCinemaById(String p0);
}
