package com.brs.service.Implementation;

import java.util.List;
import java.util.Optional;
import com.brs.repository.IRouteRepository;
import com.brs.service.interfaces.IRouteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RouteServiceImpl implements IRouteService {
    @Autowired
    IRouteRepository routeRepository;
 
    @Override
    @SneakyThrows
    public Route addRoute(Route route) {
        int id = route.getRouteId();
        Optional<Route> r = routeRepository.findById(id);
        if(!r.isPresent())
        {
           return routeRepository.save(route);

        }
        else
        {
            throw new RouteNotFoundException("Route Id exits ");
        }


    }
 
    @Override
    @SneakyThrows
    public Route updateRoute(Route route){
    	
    	int routeId = route.getRouteId();
        Optional<Route> result = routeRepository.findById(routeId);
        if(result.isPresent()) {
            Route r = result.get();
            r.setRouteFrom(route.getRouteFrom());
            r.setRouteTo(route.getRouteTo());
            r.setDistance(route.getDistance());

//            r.setBuses(route.getBuses());
            return r;
        }
        else {
          throw new RouteNotFoundException("ROUTE ID NOT AVAILABLE ");
        }
        
    }
 
    @Override
    @SneakyThrows
    public Route deleteRoute(int routeId){
        Optional<Route> route = routeRepository.findById(routeId);
        if(route.isPresent())
        {
            Route routeToDelete = route.get();
            routeRepository.deleteById(routeId);
            return routeToDelete;
        }
        else
        {
            throw new RouteNotFoundException("NO ROUTE WITH GIVEN ID ");
        }



    }
 
    @Override
    @SneakyThrows
    public Route viewRoute(int routeId){

        Optional<Route> route = routeRepository.findById(routeId);
        if(route.isPresent())
        {
            return route.get();
        }
        else
        {
            throw new RouteNotFoundException("NO ROUTE WITH GIVEN ID ");
        }


    }
 
    @Override
    public List<Route> viewAllRoute() {
        return routeRepository.findAll();
    }
    
}


 
    
 