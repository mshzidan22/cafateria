package com.isi.cafateria.service;

import com.isi.cafateria.model.InvoiceLine;
import com.isi.cafateria.model.Product;
import com.isi.cafateria.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class InvoiceLineService {

    @Autowired
    private ProductRepo productRepo;

    public void  updateProductsAmount (Set<InvoiceLine> invoiceLineSet){
        invoiceLineSet.forEach(invoiceLine -> {
            invoiceLine.getProduct().setAmount(invoiceLine.getProduct().getAmount() - invoiceLine.getAmount());
        });
    }
}
