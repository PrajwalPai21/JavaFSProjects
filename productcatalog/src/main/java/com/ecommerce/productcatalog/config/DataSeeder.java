package com.ecommerce.productcatalog.config;


import com.ecommerce.productcatalog.model.Category;
import com.ecommerce.productcatalog.model.Product;
import com.ecommerce.productcatalog.repository.CategoryRepository;
import com.ecommerce.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component //Spring must manage this by itself.
public class DataSeeder implements CommandLineRunner {//Add some dummy data, initial data
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Clear any kind of data existing in db

        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics,home,clothing));


//        Create products

        Product phone = new Product();
        phone.setName("Smart Phone");
        phone.setDescription("Latest and cool model ever created with cool new features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(22000.00);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Lap Top");
        laptop.setDescription("Latest and cool Laptop ever created with cool new features");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(50000.00);
        laptop.setCategory(electronics);


        Product jacket = new Product();
        jacket.setName("Leather Jacket");
        jacket.setDescription("Warm and Cozy Leather Jacket");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(5000.00);
        jacket.setCategory(clothing);

        Product fan = new Product();
        fan.setName("Fan");
        fan.setDescription("Cool off during summer with this Fan");
        fan.setImageUrl("https://placehold.co/600x400");
        fan.setPrice(500.00);
        fan.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,fan));
    }
}
