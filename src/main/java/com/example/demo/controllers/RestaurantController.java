package com.example.demo.controllers;


import com.example.demo.domain.Client;
import com.example.demo.domain.Product;
import com.example.demo.domain.Restaurant;
import com.example.demo.services.ClientService;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import com.example.demo.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ProductService productService;
    private final ClientService clientService;
    private final OrderService orderService;
    private Long id;
    private Model model;

    public RestaurantController(RestaurantService restaurantService, ProductService productService, ClientService clientService, OrderService orderService) {
        this.restaurantService = restaurantService;
        this.productService = productService;
        this.clientService = clientService;
        this.orderService = orderService;
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

    @GetMapping("/clients/{id}")
    public String getClients(@PathVariable(value = "id") Long id, Model model){

        Restaurant restaurant = restaurantService.findRestaurantById(id);
       // List<Client> clients = clientService.findByRestaurant(restaurant);
        model.addAttribute("clients",clientService.findByRestaurant(restaurant));
        model.addAttribute("restaurant" , restaurant);

        return "clients";

    }

    @GetMapping("/orders/{id}")
    public String getOrders(@PathVariable(value = "id") Long id, Model model){

        Restaurant restaurant = restaurantService.findRestaurantById(id);
        // List<Client> clients = clientService.findByRestaurant(restaurant);
        model.addAttribute("orders",orderService.findOrderByRestaurant(restaurant));
        model.addAttribute("restaurant" , restaurant);
        model.addAttribute("price",50);

        return "restaurant_orders";

    }







    @GetMapping("/newRestaurant")
    public String newRestaurant(Model model){
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant" , restaurant);
        return "new_restaurant";

    }

    @PostMapping("/saveRestaurant")
    public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant){
        restaurantService.save(restaurant);
        return "redirect:/restaurants";

    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id , Model model){

        Restaurant restaurant = restaurantService.findRestaurantById(id);
        model.addAttribute("restaurant",restaurant);
        return "update_restaurant";
    }

    @GetMapping("deleteRestaurant/{id}")
    public String deleteRestaurant(@PathVariable(value = "id") Long id){

        restaurantService.deleteRestaurantById(id);

        return "redirect:/";

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
