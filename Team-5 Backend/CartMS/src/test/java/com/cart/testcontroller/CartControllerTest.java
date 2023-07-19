package com.cart.testcontroller;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cart.controller.CartController;
import com.cart.exception.CARTITEMALREADYEXISTS;
import com.cart.exception.CARTITEMNOTEXISTS;
import com.cart.model.Cart;
import com.cart.service.ICartService;
class CartControllerTest {
    @Mock
    private ICartService cartService;
    @InjectMocks
    private CartController cartController;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testSaveItemHandler_Success() throws CARTITEMALREADYEXISTS {
        // Mocking the service method
        Cart savedCart = new Cart();
        when(cartService.addToCart(any(Cart.class))).thenReturn(savedCart);
        // Creating the request body
        Cart cart = new Cart();
        // Invoking the controller method
        ResponseEntity<?> response = cartController.saveItemHandler(cart);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(savedCart, response.getBody());
    }
    @Test
    void testSaveItemHandler_CartItemAlreadyExists() throws CARTITEMALREADYEXISTS {
        // Mocking the service method to throw an exception
        doThrow(CARTITEMALREADYEXISTS.class).when(cartService).addToCart(any(Cart.class));
        // Creating the request body
        Cart cart = new Cart();
        // Invoking the controller method
        ResponseEntity<?> response = cartController.saveItemHandler(cart);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        Assertions.assertEquals("Cart Item  Already Exist", response.getBody());
    }
    @Test
    void testGetItemsHandler() {
        // Mocking the service method
        List<Cart> cartList = new ArrayList<>();
        when(cartService.getAllCartItems()).thenReturn(cartList);
        // Invoking the controller method
        ResponseEntity<?> response = cartController.GetItemsHandler();
        // Asserting the response
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(cartList, response.getBody());
    }
    @Test
    void testGetCartItemByIdHandler_Success() throws CARTITEMNOTEXISTS {
        // Mocking the service method
        Cart cart = new Cart();
        when(cartService.getCartItemById(1)).thenReturn(cart);
        // Invoking the controller method
        ResponseEntity<?> response = cartController.getCartItemByIdHandler(1);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(cart, response.getBody());
    }
    @Test
    void testGetCartItemByIdHandler_CartItemNotFound() throws CARTITEMNOTEXISTS {
        // Mocking the service method to throw an exception
        doThrow(CARTITEMNOTEXISTS.class).when(cartService).getCartItemById(1);
        // Invoking the controller method
        ResponseEntity<?> response = cartController.getCartItemByIdHandler(1);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertEquals("CartItem Not found", response.getBody());
    }
    @Test
    void testDeleteCartItemByIdHandler_Success() throws CARTITEMNOTEXISTS {
        // Mocking the service method
        when(cartService.delCartById(1)).thenReturn(true);
        // Invoking the controller method
        ResponseEntity<?> response = cartController.DeleteCartItemByIdHandler(1);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(true, response.getBody());
    }
    @Test
    void testDeleteCartItemByIdHandler_CartItemNotFound() throws CARTITEMNOTEXISTS {
        // Mocking the service method to throw an exception
        doThrow(CARTITEMNOTEXISTS.class).when(cartService).delCartById(1);
        // Invoking the controller method
        ResponseEntity<?> response = cartController.DeleteCartItemByIdHandler(1);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertEquals("Cart Item Not exist", response.getBody());
    }
    @Test
    void testGetByCartIdHandler_Success() throws CARTITEMNOTEXISTS {
        // Mocking the service method
        List<Cart> cartList = new ArrayList<>();
        when(cartService.getByUserId(1)).thenReturn(cartList);
        // Invoking the controller method
        ResponseEntity<?> response = cartController.getByCartIdHandler(1);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(cartList, response.getBody());
    }
    @Test
    void testGetByCartIdHandler_CartItemNotFound() throws CARTITEMNOTEXISTS {
        // Mocking the service method to throw an exception
        doThrow(CARTITEMNOTEXISTS.class).when(cartService).getByUserId(1);
        // Invoking the controller method
        ResponseEntity<?> response = cartController.getByCartIdHandler(1);
        // Asserting the response
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertEquals("CartItem Not found", response.getBody());
    }
}