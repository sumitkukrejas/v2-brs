package com.brs.service.Impl;
 
import java.util.List;
import java.util.Optional;

import com.brs.dao.RouteDao;
import com.brs.service.interfaces.IRouteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;


@Service
public class RouteServiceImpl implements IRouteService {
    @Autowired
    RouteDao routeDao;
 
    @Override
    @SneakyThrows
    public Route addRoute(Route route) {
        int id = route.getRouteId();
        Optional<Route> r = routeDao.findById(id);
        if(!r.isPresent())
        {
           return routeDao.save(route);

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
        Optional<Route> result = routeDao.findById(routeId);
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
        Optional<Route> route = routeDao.findById(routeId);
        if(route.isPresent())
        {
            Route routeToDelete = route.get();
            routeDao.deleteById(routeId);
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

        Optional<Route> route = routeDao.findById(routeId);
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
        return routeDao.findAll();
    }
    
}


 
    
 