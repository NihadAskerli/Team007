package com.example.team007.service;

import com.example.team007.models.Deptor;
import com.example.team007.repo.DeptorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeptorService {
private DeptorRepo deptorRepo;
public Deptor saveDeptor(Deptor deptor){
    return  deptorRepo.save(deptor);
}
}
