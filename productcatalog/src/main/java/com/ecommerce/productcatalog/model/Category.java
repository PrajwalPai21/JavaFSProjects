package com.ecommerce.productcatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",
                cascade =  CascadeType.ALL, //"When I do something to the Category, do the same to all related Products too."
                fetch = FetchType.LAZY) // Don't load the products until I actually ask for them.
    @JsonIgnore
    private Set<Product> products;
}
