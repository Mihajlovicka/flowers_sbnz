package com.ftn.sbnz.controller;

import com.ftn.sbnz.dto.StatisticDTO;
import com.ftn.sbnz.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = "/statistic")
public class StatisticController {

    @Autowired
    StatisticService statisticService;

    @GetMapping("/get/{id}/{email}")
    public ResponseEntity user(@PathVariable Long id, @PathVariable String email){
        return new ResponseEntity(statisticService.getStatistic(id, email), HttpStatus.OK);
    }

    @PostMapping("/positive")
    public ResponseEntity positive(@RequestBody StatisticDTO statisticDTO){
        return new ResponseEntity(statisticService.addPositive(statisticDTO.getId(), statisticDTO.getEmail(), statisticDTO.getComment()), HttpStatus.OK);
    }

    @PostMapping("/negative")
    public ResponseEntity negative(@RequestBody StatisticDTO statisticDTO){
        return new ResponseEntity(statisticService.addNegative(statisticDTO.getId(), statisticDTO.getEmail(), statisticDTO.getComment()), HttpStatus.OK);
    }

    @PostMapping("/negative/handle")
    public ResponseEntity handle(@RequestBody StatisticDTO statisticDTO) throws ParseException {
        return new ResponseEntity(statisticService.handleNegative(statisticDTO.getId(), statisticDTO.getEmail(), statisticDTO.getComment(), statisticDTO.getDate()), HttpStatus.OK);
    }
    @GetMapping("/level/{email}")
    public ResponseEntity level(@PathVariable String email){
        return new ResponseEntity(statisticService.changeLevel(email), HttpStatus.OK);
    }

}
