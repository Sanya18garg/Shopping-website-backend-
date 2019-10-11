package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.Respository.cartRepository;
import com.caseStudy.eCart.modals.Cart;
import com.caseStudy.eCart.service.cartservice;
import com.caseStudy.eCart.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.caseStudy.eCart.service.cartservice;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class cartController {
    private cartRepository c;

    private cartservice c1;

    private userservice u;
     @Autowired
     public cartController(cartservice c1,userservice u)
     {
         this.c1=c1;
         this.u=u;
     }
    @RequestMapping(value="/removeproduct/receive/{productid}",method = RequestMethod.GET)
    @ResponseBody
    public Cart removeproduct(@PathVariable Long productid, Principal principal)
    {
        return c1.removeproduct(u.getUserId(principal),productid);


    }
    @RequestMapping(value="/addproduct/receive/{productid}",method = RequestMethod.POST)
    @ResponseBody
    public Cart addproduct(@PathVariable Long productid, Principal principal)
    {
        return c1.addProduct(u.getUserId(principal),productid);


    }
    @RequestMapping(value="/showcart/receive",method = RequestMethod.GET)
    @ResponseBody
    public List<Cart> showcart(Principal principal)
    {
        return c1.showCart(u.getUserId(principal),principal);


    }
   @RequestMapping(value="/clearcart",method = RequestMethod.GET)
    @ResponseBody
    public String clearcart(Principal principal)
    {
        return c1.clearCart(u.getUserId(principal),principal);


    }


}
