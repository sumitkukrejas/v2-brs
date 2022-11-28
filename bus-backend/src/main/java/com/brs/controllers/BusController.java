package com.brs.controllers;




import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.brs.entity.Bus;
import com.brs.service.interfaces.IBusService;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BusController {
    @Autowired
    IBusService busService;


    
    @PostMapping(value ="/bus")
    @SneakyThrows
    public Bus addBus(@RequestBody Bus bus) {
      return busService.addBus(bus);
    }

    @PutMapping("/bus")
    @SneakyThrows
    public Bus updateBus(@RequestBody Bus bus) {
        return busService.updateBus(bus);
    }
    @DeleteMapping("/bus")
    @SneakyThrows
    public Bus deleteBus(@RequestParam int busId) {
        return busService.deleteBus(busId);
    }
    @GetMapping("/bus")
    @SneakyThrows
    public Bus viewBus(@RequestParam int busId)
    {
        return busService.viewBus(busId);
    }




    @GetMapping("/buses")
    public List<Bus> viewAllBus(){
        return busService.viewAllBus();
    }



    @GetMapping("/searchBus")
    public List<Bus> searchBus(@RequestParam String from , @RequestParam String to , @RequestParam  String departure){
        LocalDate departureDate = LocalDate.parse(departure);
        return busService.searchBus(from , to , departureDate);
    }
}