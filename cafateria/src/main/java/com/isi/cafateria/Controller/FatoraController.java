package com.isi.cafateria.Controller;

import com.isi.cafateria.service.FatoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FatoraController {
    @Autowired FatoraService fatoraService;


   @GetMapping("/add")
    public void addFa(){
        fatoraService.firstFAtora();
    }
}
