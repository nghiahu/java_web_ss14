package com.example.session13.controller;

import com.example.session13.model.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String cartForm(Model model, HttpServletRequest request) {
        model.addAttribute("cartItem", new CartItem());

        List<String> cookieProducts = getProductNamesFromCookie(request);
        model.addAttribute("cookieProducts", cookieProducts);

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        model.addAttribute("cart", cart);

        return "cartForm";
    }

    @PostMapping("/cart/add")
    public String addToCart(@ModelAttribute CartItem cartItem,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(cartItem);
        session.setAttribute("cart", cart);


        List<String> productNames = getProductNamesFromCookie(request);
        productNames.add(cartItem.getName());
        saveProductNamesToCookie(productNames, response);

        return "redirect:/cart";
    }

    @GetMapping("/cart/delete")
    public String deleteFromCart(@RequestParam("name") String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            cart.removeIf(item -> item.getName().equals(name));
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart";
    }

    private List<String> getProductNamesFromCookie(HttpServletRequest request) {
        List<String> names = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("productNames".equals(c.getName())) {
                    String value = c.getValue();
                    String[] split = value.split("\\|");
                    for (String s : split) {
                        if (!s.trim().isEmpty()) names.add(s);
                    }
                }
            }
        }
        return names;
    }

    private void saveProductNamesToCookie(List<String> names, HttpServletResponse response) {
        String joined = String.join("|", names);
        Cookie cookie = new Cookie("productNames", joined);
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
    }
}
