package com.shop.advance.academy.yordan.petrov.git.shop.domain;

import com.shop.advance.academy.yordan.petrov.git.shop.data.dao.AddressDao;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.Address;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.AddressServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Class test  for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @MockBean
    AddressDao addressDao;

    @Autowired
    AddressService addressService;

    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddressServiceReturnsAllAddresses() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address());
        addresses.add(new Address());
        addresses.add(new Address());

        Mockito.when(addressDao.findAll()).thenReturn(addresses);
        List<AddressServiceViewModel> addressServiceViewModels = addressService.getAllAddresses();

        assertEquals(3, addressServiceViewModels.size());
    }


    @Test
    public void testAddressServiceGetAddressById() {
        Address address = new Address();
        address.setId(15L);

        Mockito.when(addressDao.findById(15L))
                .thenReturn(java.util.Optional.of(address));
        AddressServiceViewModel addressServiceViewModel = this.modelMapper.map(address, AddressServiceViewModel.class);

        assertEquals(addressServiceViewModel, addressService.getAddressById(15L));
    }

    //TODO ADD TEST IF CREATES

    //TODO ADD TEST IF REMOVES

    //TODO ADD TEST IF UPDATES
}
