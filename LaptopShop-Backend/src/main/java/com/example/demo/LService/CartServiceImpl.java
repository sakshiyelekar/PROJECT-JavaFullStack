package com.example.demo.LService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.LEntity.Cart;
import com.example.demo.LEntity.Laptop1;
import com.example.demo.LRepository.CartRepository;
import com.example.demo.LRepository.LaptopRepo1;

@Service
public class CartServiceImpl implements CartService {
	 private final CartRepository cartRepository;
	
	  


	     @Autowired
	     public CartServiceImpl(CartRepository cartRepository) {
	         this.cartRepository = cartRepository;
	     }

	     @Override
	     public Cart saveCart(Cart cart) {
	         return cartRepository.save(cart);
	     }

	     @Override
	     public List<Cart> getAllCarts() {
	         return cartRepository.findAll();
	     }

	     @Override
	     public Cart getCartById(Long id) {
	         return cartRepository.findById(id).orElse(null);
	     }

	     @Override
	     public Cart updateCart(Long id, Cart cart) {
	         Cart existingCart = cartRepository.findById(id).orElse(null);
	         if (existingCart != null) {
	             // Update the existing cart details
	             existingCart.setBrand(cart.getBrand());
	             existingCart.setModel(cart.getModel());
	             existingCart.setPrice(cart.getPrice());
	             existingCart.setDescription(cart.getDescription());
	             existingCart.setImage(cart.getImage());

	             return cartRepository.save(existingCart);
	         }
	         return null; // Cart not found
	     }

	   
	     
	     @Override
	     public Cart deleteCart(Long id) {
	         Cart cartToDelete = cartRepository.findById(id).orElse(null);
	         if (cartToDelete != null) {
	             cartRepository.delete(cartToDelete);
	             return cartToDelete;
	         }
	         return null; // Cart not found
	     }
	 

    // Implement other methods of CartService
}



