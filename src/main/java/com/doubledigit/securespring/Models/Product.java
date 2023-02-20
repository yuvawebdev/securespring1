package com.doubledigit.securespring.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long productId;
    private String productName;
    private String productDescription;
    private String productCategory;
    private double productMRP;


}
