package com.example.team007.controller;

import com.example.team007.dto.DeptorDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class DeptorController {

    RestTemplate template = new RestTemplate();

    private final ObjectMapper objectMapper;

    @GetMapping("/demo")
    public String demo() {
        return "hello guys";
    }


    @PostMapping("/save")
    public ResponseEntity<DeptorDTO> save(@RequestBody String deptor) throws JsonProcessingException {
        DeptorDTO deptorDTO = objectMapper.readValue(deptor, DeptorDTO.class);
        return ResponseEntity.ok(deptorDTO);

    }
    @PostMapping()
    public boolean checkUser(DeptorDTO deptorDTO) {
        userImpl.checkUser(deptorDTO);
        try {
            URL url = new URL("91.102.161.166:5000/predict?data=user");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(in.read());
            in.close();
            in.readLine();
            if(in.readLine() == "1"){
                return true;
            }
            else{
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



}
