package com.shop.advance.academy.yordan.petrov.git.shop.domain;

import com.shop.advance.academy.yordan.petrov.git.shop.data.dao.ContactInformationDao;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.ContactInformation;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.ContactInformationServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.ContactInformationService;
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
public class ContactInformationServiceTest {

    @MockBean
    ContactInformationDao contactInformationDao;

    @Autowired
    ContactInformationService contactInformationService;

    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testContactInformationServiceReturnsAllContactInformations() {
        List<ContactInformation> contactInformations = new ArrayList<>();
        contactInformations.add(new ContactInformation());
        contactInformations.add(new ContactInformation());
        contactInformations.add(new ContactInformation());

        Mockito.when(contactInformationDao.findAll()).thenReturn(contactInformations);
        List<ContactInformationServiceViewModel> contactInformationServiceViewModels = contactInformationService.getAllContactInformations();

        assertEquals(3, contactInformationServiceViewModels.size());
    }


    @Test
    public void testContactInformationServiceGetContactInformationById() {
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setId(15L);

        Mockito.when(contactInformationDao.findById(15L))
                .thenReturn(java.util.Optional.of(contactInformation));
        ContactInformationServiceViewModel contactInformationServiceViewModel = this.modelMapper.map(contactInformation, ContactInformationServiceViewModel.class);

        assertEquals(contactInformationServiceViewModel, contactInformationService.getContactInformationById(15L));
    }

    //TODO ADD TEST IF CREATES

    //TODO ADD TEST IF REMOVES

    //TODO ADD TEST IF UPDATES
}
