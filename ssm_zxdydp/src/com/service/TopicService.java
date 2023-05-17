// 
// 
// 

package com.service;

import java.util.List;
import com.entity.Topic;
import org.springframework.stereotype.Service;

@Service("topicService")
public interface TopicService
{
    int insertTopic(Topic p0);
    
    int updateTopic(Topic p0);
    
    int deleteTopic(String p0);
    
    List<Topic> getAllTopic();
    
    List<Topic> getTopicByCond(Topic p0);
    
    List<Topic> getTopicByLike(Topic p0);
    
    Topic getTopicById(String p0);
}
