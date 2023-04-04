package com.nttdata.msreports.service;

import com.nttdata.msreports.model.Account;
import com.nttdata.msreports.model.Credit;
import com.nttdata.msreports.model.Movements;
import com.nttdata.msreports.proxy.ReportProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ReportServiceImpl implements ReportService {

    private ReportProxy reportProxy = new ReportProxy();

    @Override
    public Flux<Movements> getComissionsByProduct(String idProduct) {
        return reportProxy.getCommissions(idProduct);
    }

    @Override
    public Flux<Account> getAllAccountByCustomer(String idClient) {
        return reportProxy.getAccountByCustomer(idClient);
    }

    @Override
    public Flux<Credit> getAllCreditByCustomer(String idClient) {
        return reportProxy.getCreditByCustomer(idClient);
    }

}