package com.tennis.fantasytennisapi.service;

import java.util.List;

import com.tennis.fantasytennisapi.entity.SimpleEntity;
import com.tennis.fantasytennisapi.request.Simple;

public interface SimpleService {
    
    Simple addSimple(Simple simple);

    Simple deleteSimple(Simple simple);

    List<SimpleEntity> getSimple();

}