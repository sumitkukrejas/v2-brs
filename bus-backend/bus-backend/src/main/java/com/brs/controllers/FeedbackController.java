package com.brs.controllers;



import java.util.List;

import javax.validation.Valid;

import com.brs.exceptions.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Feedback;
import com.brs.service.interfaces.IFeedBackService;


@RestController
public class FeedbackController { 
    
    @Autowired
    IFeedBackService feedBackService;



   @PostMapping("/addFeedback")
   @SneakyThrows
    public Feedback addFeedBack(@Valid @RequestBody Feedback feedBack) {
        return feedBackService.addFeedBack(feedBack);
    }
    
    @PutMapping("/updateFeedback")
    @SneakyThrows
    public Feedback updateFeedBack(@Valid @RequestBody Feedback feedBack){
        return feedBackService.updateFeedBack(feedBack);
    }
    
    @GetMapping("/viewFeedback")
    @SneakyThrows
    public Feedback viewFeedBack(@RequestParam int feedBackId) {
        return feedBackService.viewFeedBack(feedBackId);
    }
    
    @GetMapping("/viewAllFeedback")
    public List<Feedback> viewAllFeedBack(){
        return feedBackService.viewAllFeedBack();
    }
}