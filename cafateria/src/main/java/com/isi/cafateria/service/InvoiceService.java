package com.isi.cafateria.service;


import com.isi.cafateria.exceptions.ProductAmountlessThanOrderdExcption;
import com.isi.cafateria.exceptions.TareshNotSuffientException;
import com.isi.cafateria.model.Invoice;
import com.isi.cafateria.model.InvoiceLine;
import com.isi.cafateria.model.Product;
import com.isi.cafateria.repository.InvoiceRepo;
import com.isi.cafateria.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepo invoiceRepo;
    @Autowired
    private ProductRepo productRepo;


    public Invoice buy(Invoice invoice) {
        Product littleProduct = notAvailableProducts(invoice);
        setTotalPrice(invoice);
        invoice.setDate(LocalDateTime.now());

        if (!littleProduct.equals(null)) {
            throw new ProductAmountlessThanOrderdExcption("You can order only " + littleProduct.getAmount() + "from " + littleProduct.getName());
        }
        Double taresh = invoice.getCustomer().getTaresh();
        Double totalPrice = invoice.getTotalPrice();
        Double amountPaid = invoice.getPayment().getAmountPaid();
        Double needToPayByTaresha = totalPrice - amountPaid;


        if (totalPrice > amountPaid && needToPayByTaresha > taresh) {
            throw new TareshNotSuffientException("you only have " + taresh + " EGP in your account. you need " + needToPayByTaresha);
        }

        if (totalPrice > amountPaid && needToPayByTaresha < taresh) {
            invoice.getCustomer().setTaresh(taresh - needToPayByTaresha);
            invoiceRepo.save(invoice);
        } else invoiceRepo.save(invoice);
        updateProductsAmount(invoice.getInvoiceLinesList());
        return invoice;

    }

    public Product notAvailableProducts(Invoice invoice) {
        //return first not available product
        return invoice.getInvoiceLinesList().stream()
                .filter(il -> il.getAmount() > il.getProduct().getAmount())
                .map(il -> il.getProduct())
                .findFirst().orElse(null);
    }

    public void updateProductsAmount(Set<InvoiceLine> invoiceLineSet) {
        Set<Product> products = new HashSet<>();
        invoiceLineSet.forEach(invoiceLine -> {
            invoiceLine.getProduct().setAmount(invoiceLine.getProduct().getAmount() - invoiceLine.getAmount());
            products.add(invoiceLine.getProduct());
        });
         productRepo.saveAll(products);

    }

    public void setTotalPrice(Invoice invoice){
        invoice.setTotalPrice(invoice.getInvoiceLinesList().stream().mapToDouble(l->l.getUnitPrice()).sum());
    }

}