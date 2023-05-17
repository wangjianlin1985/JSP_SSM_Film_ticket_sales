// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.City;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.CityDAO;
import org.springframework.stereotype.Service;
import com.service.CityService;

@Service("cityService")
public class CityServiceImpl implements CityService
{
    @Autowired
    @Resource
    private CityDAO cityDAO;
    
    @Override
    public int insertCity(final City city) {
        return this.cityDAO.insertCity(city);
    }
    
    @Override
    public int updateCity(final City city) {
        return this.cityDAO.updateCity(city);
    }
    
    @Override
    public int deleteCity(final String cityid) {
        return this.cityDAO.deleteCity(cityid);
    }
    
    @Override
    public List<City> getAllCity() {
        return this.cityDAO.getAllCity();
    }
    
    @Override
    public List<City> getCityByCond(final City city) {
        return this.cityDAO.getCityByCond(city);
    }
    
    @Override
    public List<City> getCityByLike(final City city) {
        return this.cityDAO.getCityByLike(city);
    }
    
    @Override
    public City getCityById(final String cityid) {
        return this.cityDAO.getCityById(cityid);
    }
}
