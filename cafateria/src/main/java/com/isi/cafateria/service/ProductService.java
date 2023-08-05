package com.isi.cafateria.service;

import com.isi.cafateria.model.Product;
import com.isi.cafateria.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;



    public List<Product> getAllProducts(int page, int size ,String sorting){
       return productRepo.findAll(PageRequest.of(page, size, Sort.by(sorting))).getContent();
    }
}
