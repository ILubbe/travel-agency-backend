package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.Cart.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    //private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) { this.cartRepository = cartRepository; }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart order = purchase.getCart();
        String orderTrackingNumber = UUID.randomUUID().toString(); // generates a random tracking #
        order.setOrderTrackingNumber(orderTrackingNumber);
        Set<CartItem> cartItems = purchase.getCartItems();
        if (cartItems.isEmpty()) {
            orderTrackingNumber = "Cart is Empty";
            return new PurchaseResponse(orderTrackingNumber);
        }
        cartItems.forEach(item -> order.add(item));
        Customer customer = purchase.getCustomer();
        customer.add(order);
        order.setStatus(ordered);
        cartRepository.save(order);
        return new PurchaseResponse(orderTrackingNumber);

    }
}
