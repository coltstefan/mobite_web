package com.example.demo.controllers;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.domain.Restaurant;
import com.example.demo.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private Long id;
    private Model model;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public String listRestaurants(Model model){

        model.addAttribute("restaurants",restaurantService.findAll());
        return "restaurants";

    }


    @GetMapping("/{id}")
    public String getProfile(@PathVariable (value = "id") Long id, Model model){

        Restaurant restaurant = restaurantService.findRestaurantById(id);
        model.addAttribute("restaurant",restaurant);

        return "profile";

    }



//    @GetMapping("/profile")
//    public String getRestaurant(String name,Model model){
//
//        Restaurant r = restaurantService.findRestaurantByName(name);
//        model.addAttribute("restaurant",r);
//        return "profile";
//
//
//    }

}
