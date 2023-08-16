package com.isi.cafateria.Controller;

import com.isi.cafateria.model.Customer;
import com.isi.cafateria.model.Invoice;
import com.isi.cafateria.model.InvoiceLine;
import com.isi.cafateria.model.Product;
import com.isi.cafateria.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
  @Autowired
  private InvoiceService invoiceService;
    public void buySomeThing(Customer customer, Product product){
        InvoiceLine invoiceLine = new InvoiceLine();


    }



    @PostMapping(value = "/buy")

    public String buy(Invoice invoice){
        invoiceService.buy(invoice);
        return "done";
    }

}
