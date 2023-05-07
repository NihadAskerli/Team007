package com.example.team007.controller;

import com.example.team007.dto.DeptorDto;
import com.example.team007.models.Deptor;
import com.example.team007.service.DeptorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/deptor")
@RequiredArgsConstructor
public class DeptorController {
public final DeptorService deptorService;
public final ObjectMapper objectMapper;
    @GetMapping("/demo")
    public String demo(){
         return "hello guys";
    }
    @PostMapping("/save")
    public Deptor saveDeptor(@RequestBody String deptorDto) throws JsonProcessingException {
//
        DeptorDto deptorDto1=objectMapper.readValue(deptorDto,DeptorDto.class);
        Deptor deptor=objectMapper.convertValue(deptorDto, Deptor.class);
         Deptor deptor1=deptorService.saveDeptor(deptor);
        return deptor1;
    }

}
