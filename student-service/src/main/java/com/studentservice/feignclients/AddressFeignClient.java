package com.studentservice.feignclients;

import com.studentservice.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "adress-service", path = "/api/address")
public interface AddressFeignClient {

    @GetMapping("getById/{id}")
    public AddressResponse getById(@PathVariable long id);
}
