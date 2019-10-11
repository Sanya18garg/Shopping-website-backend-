////package com.caseStudy.eCart.service;
////
////
////
////import com.caseStudy.eCart.modals.Cart;
////import com.caseStudy.eCart.modals.Users;
////import com.caseStudy.eCart.Respository.cartRepository;
////import com.caseStudy.eCart.Respository.userRepository;
////import org.springframework.http.HttpHeaders;
////import org.springframework.http.ResponseEntity;
//
//import java.security.Principal;
//import java.util.Optional;
//
//public class CurrentUserService {
//    private userRepository userRepository;
//    private cartRepository cartRepository;
//    public Optional<Users> CurrentUser(Principal principal) {
//        String email = principal.getName();
//        return userRepository.findByUsername(email);
//    }
//
//    public Long getuserid(Principal principal) {
//        String email = principal.getName();
//        Long id = userRepository.findByUsername(email).get().getId();
//        return id;
//    }
//
//    public Long getuserrole(Principal principal) {
//        return userRepository.findByUsername(principal.getName()).get().getRole().getRoleid();
//    }
//
//    public Optional<Users> getuserprofile(Principal principal) {
//        return userRepository.findByUsername(principal.getName());
//    }
//
//    public ResponseEntity<?> checkdetails(Users user, Principal principal) {
//        Optional<Users> usercheck = userRepository.findByUsername(principal.getName());
//        Optional<Users> usercheckinfo = userRepository.findByUsername(user.getUsername());
//        if (usercheckinfo.isPresent() & usercheckinfo.get().getUsername() != usercheck.get().getUsername()) {
//            HttpHeaders responseHeaders = new HttpHeaders();
//        } else {
//            Cart cart = new Cart();
//            cart.setItems(product);
//            cart.setUser(user);
//            cart.setQuantity(1);
//            cartRepository.save(cart);
//        }
//    }
//}
