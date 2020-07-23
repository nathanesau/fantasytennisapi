package com.tennis.fantasytennisapi.service.impl;

import java.util.List;

import com.tennis.fantasytennisapi.entity.SimpleEntity;
import com.tennis.fantasytennisapi.repository.SimpleRepository;
import com.tennis.fantasytennisapi.request.Simple;
import com.tennis.fantasytennisapi.service.SimpleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Autowired
    SimpleRepository simpleRepository;

    @Override
    public Simple addSimple(Simple input) {
        SimpleEntity simpleEntity = new SimpleEntity();
        simpleEntity.setField1(input.getField1());
        simpleEntity.setField2(input.getField2());
        simpleRepository.save(simpleEntity);
        return input;
    }

    @Override
    public Simple deleteSimple(Simple input) {
        simpleRepository.deleteSimple(input.getField1(), input.getField2());
        return input;
    }

    @Override
    public List<SimpleEntity> getSimple() {
        List<SimpleEntity> result = simpleRepository.getSimple();
        return result;
    }

}