package com.caseStudy.eCart.service;
import com.caseStudy.eCart.modals.Cart;
// import com.caseStudy.eCart.modals.FixedCart;
import com.caseStudy.eCart.modals.Products;
import com.caseStudy.eCart.modals.Users;
import com.caseStudy.eCart.Respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
@Service
public class cartservice {
    @Autowired
    private productsRespositry productRepoistory;
    @Autowired
    private cartRepository cartRepository;

    @Autowired
    private userRepository userRepository;
    //private OrderHistoryRepository orderHistoryRepository;

    public Cart addProduct(Long userid, Long productid) {
        Products products = productRepoistory.findByProductid(productid);
        Users users = userRepository.findByuserid((userid));

        if (cartRepository.findByUserAndItems(users, products).isPresent()) {
            Cart cartt = (Cart) cartRepository.findByUserAndItems(users, products).get();
            //    FixedCart fixedCart = fixedCartRepository.findByRefId(cartt.getId().intValue());
            cartt.setQuantity(cartt.getQuantity() + 1);
            //  fixedCart.setQuantity(fixedCart.getQuantity() + 1);
            cartRepository.save(cartt);
            // fixedCartRepository.save(fixedCart);
        } else {
            Cart c = new Cart(products, users, 1);
            //   FixedCart fc = new FixedCart(products, users, 1);
            cartRepository.save(c);
            //   fixedCartRepository.save(fc);
        }
        return (Cart)cartRepository.findByUserAndItems(users, products).get();
    }
    public Cart removeproduct(Long userid,Long productid) {
        Products products = productRepoistory.findByProductid(productid);
        Users users = userRepository.findByuserid(userid);

        if(cartRepository.findByUserAndItems(users,products).get().getQuantity() == 1) {
            Cart cart = cartRepository.findByUserAndItems(users,products).get();
            cart.setQuantity(0);
            cartRepository.save(cart);
        }
        else if(cartRepository.findByUserAndItems(users,products).get().getQuantity() > 1) {
            Cart cart = cartRepository.findByUserAndItems(users,products).get();

            cart.setQuantity(cart.getQuantity() - 1);
            cartRepository.save(cart);
        }
        return cartRepository.findByUserAndItems(users,products).get();
    }

    public List<Cart> showCart(Long user_id, Principal principal) {
        Users user = userRepository.findByuserid(user_id);
        return cartRepository.findByUserAndItems_Active(user,1);
    }

   public String clearCart(Long userId,Principal principal) {

        Users user = userRepository.findByuserid(userId);
        List<Cart> cartList=cartRepository.findAllByUser(user);
        for (Cart cart : cartList) {
            cartRepository.deleteById(cart.getCartid());
        }
        return "cart cleared!";
    }
}


