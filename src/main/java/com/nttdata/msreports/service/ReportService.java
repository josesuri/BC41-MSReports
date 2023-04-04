package com.nttdata.msreports.service;

import com.nttdata.msreports.model.Account;
import com.nttdata.msreports.model.Credit;
import com.nttdata.msreports.model.Movements;
import reactor.core.publisher.Flux;

public interface ReportService {
    Flux<Movements> getComissionsByProduct(String idProduct);
    Flux<Account> getAllAccountByCustomer(String idCustomer);
    Flux<Credit> getAllCreditByCustomer(String idCustomer);
}
