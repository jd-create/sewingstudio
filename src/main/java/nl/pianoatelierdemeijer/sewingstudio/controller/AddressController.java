package nl.pianoatelierdemeijer.sewingstudio.controller;

import nl.pianoatelierdemeijer.sewingstudio.model.Address;
import nl.pianoatelierdemeijer.sewingstudio.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/addresses")
    public ResponseEntity<Object> getAddresses(){
        List<Address> addressList = addressService.getAllAddresses();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }
}
