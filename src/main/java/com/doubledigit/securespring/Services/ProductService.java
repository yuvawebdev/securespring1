package com.doubledigit.securespring.Services;

import com.doubledigit.securespring.Models.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Service
public class ProductService {

    List<Product> productList = null;

    @PostConstruct
    public void loadInitialProductData(){
        productList = LongStream.range(1, 100L)
                .mapToObj(i-> Product.builder()
                        .productId(i)
                        .productName("name" + i)
                        .productDescription(i + " description")
                        .productMRP((i * 1000) + 100).build()
                ).collect(Collectors.toList());
    }

    public List<Product> getProducts() { return productList;}

    public Product getProduct(Long id){
        return productList.stream()
                .filter(p-> p.getProductId() == id)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

}
