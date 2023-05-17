// 
// 
// 

package com.service;

import java.util.List;
import com.entity.Details;
import org.springframework.stereotype.Service;

@Service("detailsService")
public interface DetailsService
{
    int insertDetails(Details p0);
    
    int updateDetails(Details p0);
    
    int deleteDetails(String p0);
    
    List<Details> getAllDetails();
    
    List<Details> getDetailsByCond(Details p0);
    
    List<Details> getDetailsByLike(Details p0);
    
    Details getDetailsById(String p0);
}
