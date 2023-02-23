package com.studentservice.service;

import com.studentservice.feignclients.AddressFeignClient;
import com.studentservice.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    long count = 1;
    Logger logger = LoggerFactory.getLogger(CommonService.class);
    @Autowired
    AddressFeignClient addressFeignClient;

    @CircuitBreaker(name = "adressService", fallbackMethod = "fallbackGetAddressById")
    public AddressResponse getAddressById(long addressId){

        logger.info("count : " + count);
        count++;
        AddressResponse addressResponse = addressFeignClient.getById(addressId);

        return addressResponse;

    }

    public AddressResponse fallbackGetAddressById(long addressId, Throwable th){
        logger.error("Error :" + th);
        return new AddressResponse();
    }


}
