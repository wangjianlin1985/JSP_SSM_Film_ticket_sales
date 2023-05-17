// 
// 
// 

package com.dao;

import java.util.List;
import com.entity.Topic;
import org.springframework.stereotype.Repository;

@Repository("topicDAO")
public interface TopicDAO
{
    int insertTopic(Topic p0);
    
    int updateTopic(Topic p0);
    
    int deleteTopic(String p0);
    
    List<Topic> getAllTopic();
    
    List<Topic> getTopicByCond(Topic p0);
    
    List<Topic> getTopicByLike(Topic p0);
    
    Topic getTopicById(String p0);
}
