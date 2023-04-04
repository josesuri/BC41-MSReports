package com.nttdata.msreports.proxy;

import com.nttdata.msreports.model.Account;
import com.nttdata.msreports.model.Credit;
import com.nttdata.msreports.model.Movements;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class ReportProxy {

    private final WebClient.Builder webClientBuilder = WebClient.builder();

    public Flux<Movements> getMovements(){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:9020/movements")
                .retrieve()
                .bodyToFlux(Movements.class);
    }

    public Flux<Movements> getCommissions(String idProduct){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:9020/movements/byProductAndType/{idProduct}/{type}", idProduct, "commission")
                .retrieve()
                .bodyToFlux(Movements.class);
    }

    public Flux<Account> getAccountByCustomer(String idCustomer){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:9020/account/byCustomer/{idCustomer}", idCustomer)
                .retrieve()
                .bodyToFlux(Account.class);
    }

    public Flux<Credit> getCreditByCustomer(String idCustomer){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:9020/credit/allByCustomer/{idCustomer}", idCustomer)
                .retrieve()
                .bodyToFlux(Credit.class);
    }
}
