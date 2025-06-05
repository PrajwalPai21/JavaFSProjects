package com.ecommerce.productcatalog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data //For Getters and Setters
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;

//    Link this to Category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
