package com.example.demo.bootstrap;

import com.example.demo.domain.Product;
import com.example.demo.domain.Restaurant;
import com.example.demo.services.ProductService;
import com.example.demo.services.RestaurantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RestaurantService restaurantService;
    private final ProductService productService;

    public DataLoader(RestaurantService restaurantService, ProductService productService) {
        this.restaurantService = restaurantService;
        this.productService = productService;
    }


    @Override
    public void run(String... args) throws Exception {

        Restaurant r1 = new Restaurant("Pizza Hut");
        Restaurant r2 = new Restaurant("Dominos");
        Restaurant r3 = new Restaurant("McDonalds");
        Restaurant r4 = new Restaurant("KFC");

        Product p1 = new Product("Pizza Capriciosa","description" , 29.99 , 10);
        Product p2 = new Product("Pizza Diavola","description" , 19.99 , 32);
        Product p3 = new Product("Pizza Chicken Club","description" , 35.99 , 12);
        Product p4 = new Product("Pizza Pepperoni","description" , 29.99 , 54);
        Product p5 = new Product("Big Mac","description" , 16.99 , 32);
        Product p6 = new Product("Chicken Nuggets","description" , 12.99 , 12);
        Product p7 = new Product("Double Hot Booster","description" , 10.99 , 12);
        Product p8 = new Product("Crispy Strips","description" , 23.99 , 32);



        r1.addProduct(p1);
        r1.addProduct(p2);
        r2.addProduct(p3);
        r2.addProduct(p4);
        r3.addProduct(p5);
        r3.addProduct(p6);
        r4.addProduct(p7);
        r4.addProduct(p8);





        restaurantService.save(r1);
        restaurantService.save(r2);
        restaurantService.save(r3);
        restaurantService.save(r4);

        productService.save(p1);
        productService.save(p2);
        productService.save(p3);
        productService.save(p4);
        productService.save(p5);
        productService.save(p6);
        productService.save(p7);
        productService.save(p8);




        restaurantService.findAll();
        System.out.println(restaurantService.findRestaurantById(1L));
        System.out.println(restaurantService.findAll().get(0).getId());

        System.out.println(productService.findAll());
        System.out.println(productService.findAllByRestaurant(r1.getId()));
        System.out.println(productService.findAllByRestaurant(r2.getId()));

    }
}
