package com.brs.service.interfaces;
 
import java.util.List;
 
import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;
 
public interface IRouteService {
    Route addRoute(Route route);
    Route updateRoute(Route route) throws RouteNotFoundException;
    Route deleteRoute(int routeId) throws RouteNotFoundException;
    Route viewRoute(int routeId) throws RouteNotFoundException;
    List<Route> viewAllRoute();
}