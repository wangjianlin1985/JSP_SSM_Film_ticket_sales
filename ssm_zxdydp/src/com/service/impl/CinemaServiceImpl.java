// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Cinema;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.CinemaDAO;
import org.springframework.stereotype.Service;
import com.service.CinemaService;

@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService
{
    @Autowired
    @Resource
    private CinemaDAO cinemaDAO;
    
    @Override
    public int insertCinema(final Cinema cinema) {
        return this.cinemaDAO.insertCinema(cinema);
    }
    
    @Override
    public int updateCinema(final Cinema cinema) {
        return this.cinemaDAO.updateCinema(cinema);
    }
    
    @Override
    public int deleteCinema(final String cinemaid) {
        return this.cinemaDAO.deleteCinema(cinemaid);
    }
    
    @Override
    public List<Cinema> getAllCinema() {
        return this.cinemaDAO.getAllCinema();
    }
    
    @Override
    public List<Cinema> getCinemaByCond(final Cinema cinema) {
        return this.cinemaDAO.getCinemaByCond(cinema);
    }
    
    @Override
    public List<Cinema> getCinemaByLike(final Cinema cinema) {
        return this.cinemaDAO.getCinemaByLike(cinema);
    }
    
    @Override
    public Cinema getCinemaById(final String cinemaid) {
        return this.cinemaDAO.getCinemaById(cinemaid);
    }
}
