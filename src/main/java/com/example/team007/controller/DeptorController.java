package com.example.team007.controller;

import com.example.team007.dto.DeptorDtoForDataS;
import com.example.team007.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import com.example.team007.dto.DeptorDto;
import com.example.team007.models.Deptor;
import com.example.team007.service.DeptorService;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/deptor")
@RequiredArgsConstructor
public class DeptorController {
    public final DeptorService deptorService;
    public final ObjectMapper objectMapper;


    RestTemplate restTemplate;

    @GetMapping("/demo")
    public String demo() {
        return "hello guys";
    }

    @PostMapping("/save")
    public Deptor saveDeptor(@RequestBody String  deptorDto) throws JsonProcessingException {
        DeptorDto deptorDto1 = objectMapper.readValue(deptorDto, DeptorDto.class);
        Deptor deptor = objectMapper.convertValue(deptorDto, Deptor.class);
        Deptor deptor1 = deptorService.saveDeptor(deptor);
        return deptor1;
    }


    @PostMapping()
    public DeptorDto checkUser(DeptorDtoForDataS deptorDtoForDataS) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<DeptorDtoForDataS> entity = new HttpEntity<DeptorDtoForDataS>(deptorDtoForDataS,headers);

        return restTemplate.exchange(
                "91.102.161.166:5000/predict?data", HttpMethod.POST, entity, DeptorDto.class).getBody();

    }
}





