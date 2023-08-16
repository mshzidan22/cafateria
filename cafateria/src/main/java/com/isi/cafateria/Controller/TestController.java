package com.isi.cafateria.Controller;

import com.isi.cafateria.model.Customer;
import com.isi.cafateria.model.Employee;
import com.isi.cafateria.model.InvoiceLine;
import com.isi.cafateria.model.Product;
import com.isi.cafateria.repository.CustomerRepo;
import com.isi.cafateria.repository.EmployeeRepo;
import com.isi.cafateria.service.InvoiceService;
import com.isi.cafateria.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired private InvoiceService invoiceService;
    @Autowired private ProductService productService;
    @Autowired private CustomerRepo customerRepo;

    @Autowired private EmployeeRepo employeeRepo;




    @GetMapping("/testBuy")
    public void testBuy(){
        Employee employee = employeeRepo.findById(1L).get();
        Customer customer = customerRepo.findById(1L).get();

        InvoiceLine invoiceLine1 = new InvoiceLine();



    }

}
