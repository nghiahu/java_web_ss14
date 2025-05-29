package com.example.session13.controller;

import com.example.session13.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("productForm")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("product-save")
    public String productSave(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "productForm";
        }

        List<Product> products = getProductsFromCookie(request);
        products.add(product);
        saveProductsToCookie(products, response);
        return "redirect:/listProduct";
    }

    @GetMapping("listProduct")
    public String listProduct(Model model, HttpServletRequest request) {
        List<Product> products = getProductsFromCookie(request);
        model.addAttribute("products", products);
        return "listProduct";
    }

    @GetMapping("deleteProduct")
    public String deleteProduct(@RequestParam("id") String id,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        List<Product> products = getProductsFromCookie(request);
        products.removeIf(p -> p.getId().equals(id));
        saveProductsToCookie(products, response);
        return "redirect:/listProduct";
    }

    private List<Product> getProductsFromCookie(HttpServletRequest request) {
        List<Product> products = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("products".equals(c.getName())) {
                    String value = c.getValue();
                    String[] productStrings = value.split("\\|");
                    for (String productStr : productStrings) {
                        String[] fields = productStr.split("-", 3);
                        if (fields.length == 3) {
                            Product p = new Product();
                            p.setId(fields[0]);
                            p.setName(fields[1]);
                            try {
                                p.setPrice(Double.parseDouble(fields[2]));
                                products.add(p);
                            } catch (NumberFormatException ignored) {}
                        }
                    }
                }
            }
        }
        return products;
    }

    private void saveProductsToCookie(List<Product> products, HttpServletResponse response) {
        StringBuilder cookieValue = new StringBuilder();
        for (Product p : products) {
            if (cookieValue.length() > 0) {
                cookieValue.append("|");
            }
            cookieValue.append(p.getId()).append("-").append(p.getName()).append("-").append(p.getPrice());
        }
        Cookie cookie = new Cookie("products", cookieValue.toString());
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);
    }
}
