package com.isi.cafateria.Controller;

import com.isi.cafateria.model.Product;
import com.isi.cafateria.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                        @RequestParam(value = "size", required = false, defaultValue = "10") int size
            ,@RequestParam(value = "sorting", required = false, defaultValue = "id") String sorting){
        return productService.getAllProducts(page, size, sorting);

    }


}
