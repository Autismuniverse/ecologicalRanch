package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.RssiSave;
import com.ecologicalRanch.project.entity.User;

public interface MongoDBService {

    User insert(User user);

    RssiSave insertRssiDB(RssiSave rssiSave);
}
