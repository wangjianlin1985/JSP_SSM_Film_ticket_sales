// 
// 
// 

package com.service;

import java.util.List;
import com.entity.City;
import org.springframework.stereotype.Service;

@Service("cityService")
public interface CityService
{
    int insertCity(City p0);
    
    int updateCity(City p0);
    
    int deleteCity(String p0);
    
    List<City> getAllCity();
    
    List<City> getCityByCond(City p0);
    
    List<City> getCityByLike(City p0);
    
    City getCityById(String p0);
}
