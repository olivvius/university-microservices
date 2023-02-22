package com.adressservice.service;

import com.adressservice.entity.Address;
import com.adressservice.repository.AddressRepository;
import com.adressservice.request.CreateAddressRequest;
import com.adressservice.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    Logger logger = LoggerFactory.getLogger(AddressService.class);


    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());
        addressRepository.save(address);
        return new AddressResponse(address);
    }

    public AddressResponse getById(long id){
        logger.info("inside getById:" + id);
        Address address = addressRepository.findById(id).get();
        return new AddressResponse(address);
    }


}
