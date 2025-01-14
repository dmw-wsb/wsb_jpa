package com.jpacourse.rest;

import com.jpacourse.dto.AddressTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * Finds an address by its ID.
     *
     * @param id The ID of the address to find.
     * @return ResponseEntity containing the {@link AddressTO} if found.
     * @throws EntityNotFoundException if the address is not found.
     */
    @GetMapping("/address/{id}")
    public ResponseEntity<AddressTO> findById(@PathVariable Long id) {
        AddressTO address = addressService.findById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        }
        throw new EntityNotFoundException(id);
    }
}
