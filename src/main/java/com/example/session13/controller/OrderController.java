package com.example.session13.controller;

import com.example.session13.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orderForm")
    public String showForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("order") Order order, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) {
            orders = new ArrayList<>();
        }
        orders.add(order);
        session.setAttribute("orders", orders);
        return "redirect:/orderList";
    }

    @GetMapping("/orderList")
    public String listOrders(Model model, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        if (orders == null) orders = new ArrayList<>();
        model.addAttribute("orders", orders);
        return "orderList";
    }

    @GetMapping("/editOrder")
    public String editOrder(@RequestParam("id") String id, Model model, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        for (Order o : orders) {
            if (o.getOrderId().equals(id)) {
                model.addAttribute("order", o);
                break;
            }
        }
        return "orderForm";
    }

    @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute("order") Order updatedOrder, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().equals(updatedOrder.getOrderId())) {
                orders.set(i, updatedOrder);
                break;
            }
        }
        session.setAttribute("orders", orders);
        return "redirect:/orderList";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("id") String id, HttpSession session) {
        List<Order> orders = (List<Order>) session.getAttribute("orders");
        orders.removeIf(order -> order.getOrderId().equals(id));
        session.setAttribute("orders", orders);
        return "redirect:/orderList";
    }
}