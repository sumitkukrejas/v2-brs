package com.brs.service.interfaces;
 
import java.util.List;
 
import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;
 
public interface IRouteService {
    public Route addRoute(Route route);
    public Route updateRoute(Route route) throws RouteNotFoundException;
    public Route deleteRoute(int routeId) throws RouteNotFoundException;
    public Route viewRoute(int routeId) throws RouteNotFoundException;
    public List<Route> viewAllRoute();
}