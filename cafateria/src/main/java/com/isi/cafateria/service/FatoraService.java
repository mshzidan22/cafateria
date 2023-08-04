package com.isi.cafateria.service;

import com.isi.cafateria.model.Category;
import com.isi.cafateria.model.Fatora;
import com.isi.cafateria.model.Officer;
import com.isi.cafateria.model.Product;
import com.isi.cafateria.repository.CategoryRepo;
import com.isi.cafateria.repository.FatoraRepo;
import com.isi.cafateria.repository.OfficerRepo;
import com.isi.cafateria.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
public class FatoraService {
    @Autowired ProductRepo productRepo;
    @Autowired OfficerRepo officerRepo;
    @Autowired CategoryRepo categoryRepo;
    @Autowired FatoraRepo fatoraRepo;


    public void firstFAtora(){
        Officer officer = officerRepo.findById(1L).get();
        Category category = categoryRepo.findById(1L).get();
        Product product1 = new Product();
        product1.setName("drotios 5 le");
        product1.setBarcode(6546546L);
        product1.setAmount(16D);
        product1.setCategory(category);
        product1.setUnitPrice(5D);
        product1.setPurchasing(4.5D);

        Product product2 = new Product();
        product2.setName("shitos 5 le");
        product2.setBarcode(8484L);
        product2.setAmount(18D);
        product2.setCategory(category);
        product2.setUnitPrice(5D);
        product2.setPurchasing(4.5D);
        Fatora fatora = new Fatora();
        fatora.setDate(LocalDateTime.now());
        fatora.setCode("46546");
        fatora.setOfficer(officer);
        fatora.getProducts().add(product1);
        fatora.getProducts().add(product2);
        fatora.setTotalBuy(fatora.getProducts().stream().mapToDouble(product ->product.getUnitPrice()).sum());
        fatora.setTotalSell(fatora.getProducts().stream().mapToDouble(product ->product.getPurchasing()).sum());

        fatoraRepo.save(fatora);

    }

}
