package com.shop.advance.academy.yordan.petrov.git.shop.domain;

import com.shop.advance.academy.yordan.petrov.git.shop.data.dao.UserDao;
import com.shop.advance.academy.yordan.petrov.git.shop.data.models.User;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.UserServiceModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.dto.UserServiceViewModel;
import com.shop.advance.academy.yordan.petrov.git.shop.domain.services.UserService;
import com.shop.advance.academy.yordan.petrov.git.shop.exeption.InvalidEntityException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Class test  for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @MockBean
    UserDao userDao;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testUserServiceReturnsAllUsers() {
        List<User> usersToAdd = new ArrayList<>();
        usersToAdd.add(new User());
        usersToAdd.add(new User());
        usersToAdd.add(new User());

        Mockito.when(userDao.findAll()).thenReturn(usersToAdd);
        List<UserServiceViewModel> usersFetchedFromRepo = userService.getAllUsers();

        assertEquals(3, usersFetchedFromRepo.size());
    }

    @Test
    public void testUserServiceCreateExistingUserThrowsException() {
        User user = new User();
        user.setUsername("UserNameOfTheUserToTestIfItThrowsException");

        Mockito.when(userDao.findByUsername(user.getUsername()))
                .thenReturn(java.util.Optional.of(user));
        UserServiceModel userServiceModel = this.modelMapper.map(user, UserServiceModel.class);

        assertThrows(InvalidEntityException.class, () -> userService.createUser(userServiceModel));
    }

    @Test
    public void testUserServiceGetUserById() {
        User user = new User();
        user.setId(5L);

        Mockito.when(userDao.findById(5L))
                .thenReturn(java.util.Optional.of(user));
        UserServiceViewModel userServiceModel = this.modelMapper.map(user, UserServiceViewModel.class);

        assertEquals(userServiceModel, userService.getUserById(5L));
    }


    @Test
    public void testUserServiceFromSpringSecurityLoadUserByUsername() {
        User user = new User();
        user.setUsername("UsernameForTesting");

        Mockito.when(userDao.findByUsername("UsernameForTesting"))
                .thenReturn(java.util.Optional.of(user));

        assertEquals(user, userService.loadUserByUsername("UsernameForTesting"));
    }

    @Test
    public void testUserServiceFromSpringSecurityLoadUserByUsernameThrowsException() {
        User user = new User();
        user.setUsername("UsernameForTesting");

        Mockito.when(userDao.findByUsername("UsernameForTesting"))
                .thenReturn(java.util.Optional.of(user));

        assertThrows(InvalidEntityException.class, () -> userService.loadUserByUsername("Username"));
    }

}