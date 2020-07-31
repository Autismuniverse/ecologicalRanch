package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.project.entity.RssiSave;
import com.ecologicalRanch.project.entity.User;
import com.ecologicalRanch.project.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MongoDBServiceImpl implements MongoDBService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User insert(User user){
        return mongoTemplate.save(user,"test");
    }


    @Override
    public RssiSave insertRssiDB(RssiSave rssiSave){
        return mongoTemplate.save(rssiSave);
    }

}
