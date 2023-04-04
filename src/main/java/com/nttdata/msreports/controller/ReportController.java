package com.nttdata.msreports.controller;

import com.nttdata.msreports.model.Movements;
import com.nttdata.msreports.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService service;

    @GetMapping("/commission/{idProduct}")
    public Flux<Movements> getCommissionsByProduct(@PathVariable("idProduct") String idProduct){
        return service.getComissionsByProduct(idProduct);
    }

    @GetMapping("/allProduct/{idClient}")
    public Flux<?> getAllProductByClient(@PathVariable("idClient") String idClient){
        return Flux.concat(service.getAllAccountByCustomer(idClient), service.getAllCreditByCustomer(idClient));
    }
}