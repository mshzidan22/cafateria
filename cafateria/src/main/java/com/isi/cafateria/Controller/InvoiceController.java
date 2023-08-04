package com.isi.cafateria.Controller;

import com.isi.cafateria.model.Customer;
import com.isi.cafateria.model.InvoiceLine;
import com.isi.cafateria.model.Product;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    public void buySomeThing(Customer customer, Product product){
        InvoiceLine invoiceLine = new InvoiceLine();


    }

}
