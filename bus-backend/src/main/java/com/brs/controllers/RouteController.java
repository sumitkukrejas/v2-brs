package com.brs.controllers;
 
import java.util.List;

import javax.validation.Valid;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.service.interfaces.IRouteService;
 
@RestController
public class RouteController {
    @Autowired
    IRouteService routeService;

    @PostMapping("/addRoute") @SneakyThrows
    public Route addRoute(@Valid @RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @PutMapping("/updateRoute") @SneakyThrows
    public Route updateRoute(@Valid @RequestBody Route route) {
        return routeService.updateRoute(route);
    } 

    @DeleteMapping("/deleteRoute") @SneakyThrows
    public Route deleteRoute(@RequestParam int routeId){
        return routeService.deleteRoute(routeId);
    }
    @GetMapping("/viewRoute") @SneakyThrows
    public Route viewRoute(@RequestParam int routeId){
        return routeService.viewRoute(routeId);
    }
    @GetMapping("/viewAllRoute")
    public List<Route> viewAllRoute(){
        return routeService.viewAllRoute();
    }
}



