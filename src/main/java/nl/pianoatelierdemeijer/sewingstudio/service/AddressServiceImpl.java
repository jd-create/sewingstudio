package nl.pianoatelierdemeijer.sewingstudio.service;

import nl.pianoatelierdemeijer.sewingstudio.model.Address;
import nl.pianoatelierdemeijer.sewingstudio.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
