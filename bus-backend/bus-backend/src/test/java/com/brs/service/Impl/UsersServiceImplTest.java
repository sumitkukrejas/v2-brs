package com.brs.service.Impl;

import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.Users;
import com.brs.service.interfaces.IUserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UsersServiceImplTest {

    @MockBean
    UsersServiceImpl usersService;

    @BeforeEach
    @SneakyThrows 
    void setUp() {
        userList.add(user1);
        userList.add(user2);
        Mockito.when(usersService.addUser(user1)).thenReturn(user1);
        Mockito.when(usersService.updateUser(user1)).thenReturn(user2);
        Mockito.when(usersService.viewAllUsers()).thenReturn(userList);
        Mockito.when(usersService.deleteUser(1)).thenReturn(user1);
        Mockito.when(usersService.viewUser(1)).thenReturn(user1);
    }

    @Test
    void addUserTest() {
        Users testUser = usersService.addUser(user1);
        assertEquals(testUser,user1);
        assertNotEquals(testUser,user2);
    }

    @Test
    @SneakyThrows
    void updateUserTest() {
        Users testUser = usersService.updateUser(user1);
        assertEquals(testUser,user2);
        assertNotEquals(testUser,user1);
    }

    @Test
    void viewAllUsersTest() {
        List<Users> testList = usersService.viewAllUsers();
        assertEquals(testList,userList);
        assertNotEquals(testList,userList2);
    }

    @Test
    @SneakyThrows
    void deleteUserTest() {
        Users testUser = usersService.deleteUser(user1.getUserLoginId());
        assertEquals(testUser,user1);
        assertNotEquals(testUser,user2);
    }

    @Test
    @SneakyThrows
    void viewUserTest() {
        Users testUser = usersService.viewUser(user1.getUserLoginId());
        assertEquals(testUser,user1);
    }

   ReservationServiceImplTest rst = new ReservationServiceImplTest();
    Reservation reservation1 = rst.reservation;
    Reservation reservation2 = rst.reservation;

    List<Users> userList = new ArrayList<>();
    List<Users> userList2 = new ArrayList<>();
  //  Bus bus = rst.bus;

    Users user1 = Users.builder()
            .userLoginId(1)
            .contact("70060")
            .email("xyx@gmail.com")
            .firstName("abcd")
            .lastName("dfddf")
            .password("1234")
            .userName("abcd")
            .reservation(reservation1)
            .build();

    Users user2 = Users.builder()
            .userLoginId(2)
            .contact("70060")
            .email("xyx@gmail.com")
            .firstName("abcdyyyyyy")
            .lastName("dfddf")
            .password("1234")
            .userName("abcd")
            .reservation(reservation2)
            .build();
}