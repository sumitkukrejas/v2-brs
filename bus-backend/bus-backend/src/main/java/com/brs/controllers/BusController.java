package com.brs.controllers;




import java.util.Date;
import java.util.List;


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


    
    @PostMapping(value ="/addbus")
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
    
    @GetMapping("/viewBusByType")
    public List<Bus> viewBusByType(@RequestParam String busType){
        return busService.viewBusByType(busType);
    }


    @GetMapping("/buses")
    public List<Bus> viewAllBus(){
        return busService.viewAllBus();
    }


    @GetMapping("/searchBus")
    public List<Bus> searchBus(@RequestParam String from , @RequestParam String to , @RequestParam Date date){
        return busService.searchBus(from , to ,date);
    }

    @GetMapping("/searchBuses")
    public List<Bus> searchBus(@RequestParam String from , @RequestParam String to){
        return busService.searchBus(from , to );
    }
}