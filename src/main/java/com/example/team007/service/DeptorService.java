package com.example.team007.service;

import com.example.team007.dto.DeptorDto;
import com.example.team007.models.Deptor;
import com.example.team007.models.UserEntity;
import com.example.team007.repo.DeptorRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeptorService {

    @Autowired
    private DeptorRepo deptorRepo;
    public final ObjectMapper objectMapper;


    public Deptor saveDeptor(Deptor deptor) {
        return deptorRepo.save(deptor);
    }

    public boolean checkUser(DeptorDto deptorDto) {
        Deptor d = deptorRepo.save(objectMapper.convertValue(deptorDto, Deptor.class));

        return false;
    }
}
