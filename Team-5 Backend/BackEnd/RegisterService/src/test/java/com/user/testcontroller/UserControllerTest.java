package com.user.testcontroller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.user.controller.UserController;
import com.user.exception.USERALREADYEXISTSEXCEPTION;
import com.user.exception.USERNOTFOUNDEXCEPTION;
import com.user.model.User;
import com.user.service.IUserService;

class UserControllerTest {

    @Mock
    private IUserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserHandler() throws USERALREADYEXISTSEXCEPTION {
        User user = new User();
        user.setUserId(1);
        user.setUserFirstName("Srinivas");
        user.setUserLastName("Muntala");
        user.setUserEmail("srini@gmail.com");

        when(userService.saveUser(any(User.class))).thenReturn("User saved successfully");

        ResponseEntity<?> response = userController.saveUserHandler(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("User saved successfully", response.getBody());
        verify(userService, times(1)).saveUser(any(User.class));
    }

    @Test
    void testSaveUserHandler_UserAlreadyExists() throws USERALREADYEXISTSEXCEPTION {
        User user = new User();
        user.setUserEmail("srini@gmail.com");

        when(userService.saveUser(any(User.class))).thenThrow(USERALREADYEXISTSEXCEPTION.class);

        ResponseEntity<?> response = userController.saveUserHandler(user);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("User Already Exist", response.getBody());
        verify(userService, times(1)).saveUser(any(User.class));
    }

    @Test
    void testGetUserHandler() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Arun", "Saji", "2000-01-01", "Male", "arun@gmail.com", null, "Arun@123", "1234567890", "Hyderabad", null));
        userList.add(new User(2, "Rishi", "Beri", "2000-03-15", "Male", "rishi@gmail.com", null, "password", "9876543210", "Hyderabad", null));

        when(userService.getAllUsers()).thenReturn(userList);

        ResponseEntity<?> response = userController.GetUserHandler();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userList, response.getBody());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testUpdateUserHandler() throws USERNOTFOUNDEXCEPTION {
        int userId = 1;
        User user = new User();
        user.setUserFirstName("Arun Saji");
        user.setUserLastName("Saji Arun");

        when(userService.updateUser(any(User.class), eq(userId))).thenReturn(user);

        ResponseEntity<?> response = userController.updateUserHandler(user, userId);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).updateUser(any(User.class), eq(userId));
    }

    @Test
    void testUpdateUserHandler_UserNotFound() throws USERNOTFOUNDEXCEPTION {
        int userId = 2;
        User user = new User();
        user.setUserFirstName("Rishi ");
        user.setUserLastName("Rishi Beri");

        when(userService.updateUser(any(User.class), eq(userId))).thenThrow(USERNOTFOUNDEXCEPTION.class);

        ResponseEntity<?> response = userController.updateUserHandler(user, userId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User Not found", response.getBody());
        verify(userService, times(1)).updateUser(any(User.class), eq(userId));
    }

    @Test
    void testGetUserByIdHandler() throws USERNOTFOUNDEXCEPTION {
        int userId = 1;
        User user = new User();
        user.setUserId(userId);
        user.setUserFirstName("Arun");
        user.setUserLastName("Saji");

        when(userService.getUserById(eq(userId))).thenReturn(user);

        ResponseEntity<?> response = userController.getUserByIdHandler(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).getUserById(eq(userId));
    }

    @Test
    void testGetUserByIdHandler_UserNotFound() throws USERNOTFOUNDEXCEPTION {
        int userId = 1;

        when(userService.getUserById(eq(userId))).thenThrow(USERNOTFOUNDEXCEPTION.class);

        ResponseEntity<?> response = userController.getUserByIdHandler(userId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User Not found", response.getBody());
        verify(userService, times(1)).getUserById(eq(userId));
    }

    @Test
    void testDeleteUserByIdHandler() throws USERNOTFOUNDEXCEPTION {
        int userId = 1;

        when(userService.delUser(eq(userId))).thenReturn(true);

        ResponseEntity<?> response = userController.DeleteUserByIdHandler(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(true, response.getBody());
        verify(userService, times(1)).delUser(eq(userId));
    }

    @Test
    void testDeleteUserByIdHandler_UserNotFound() throws USERNOTFOUNDEXCEPTION {
        int userId = 1;

        when(userService.delUser(eq(userId))).thenThrow(USERNOTFOUNDEXCEPTION.class);

        ResponseEntity<?> response = userController.DeleteUserByIdHandler(userId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User not exist", response.getBody());
        verify(userService, times(1)).delUser(eq(userId));
    }

    @Test
    void testGetUserByUserEmailHandler() throws USERNOTFOUNDEXCEPTION {
        String userEmail = "srini@gmail.com";
        User user = new User();
        user.setUserEmail(userEmail);

        when(userService.getuserByUserEmail(eq(userEmail))).thenReturn(user);

        ResponseEntity<?> response = userController.getuserByUserEmailHandler(userEmail);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).getuserByUserEmail(eq(userEmail));
    }



}