// 
// 
// 

package com.service.impl;

import java.util.List;
import com.entity.Topic;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.TopicDAO;
import org.springframework.stereotype.Service;
import com.service.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService
{
    @Autowired
    @Resource
    private TopicDAO topicDAO;
    
    @Override
    public int insertTopic(final Topic topic) {
        return this.topicDAO.insertTopic(topic);
    }
    
    @Override
    public int updateTopic(final Topic topic) {
        return this.topicDAO.updateTopic(topic);
    }
    
    @Override
    public int deleteTopic(final String topicid) {
        return this.topicDAO.deleteTopic(topicid);
    }
    
    @Override
    public List<Topic> getAllTopic() {
        return this.topicDAO.getAllTopic();
    }
    
    @Override
    public List<Topic> getTopicByCond(final Topic topic) {
        return this.topicDAO.getTopicByCond(topic);
    }
    
    @Override
    public List<Topic> getTopicByLike(final Topic topic) {
        return this.topicDAO.getTopicByLike(topic);
    }
    
    @Override
    public Topic getTopicById(final String topicid) {
        return this.topicDAO.getTopicById(topicid);
    }
}
