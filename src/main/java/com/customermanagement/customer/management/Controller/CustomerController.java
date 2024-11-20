package com.customermanagement.customer.management.Controller;

import com.customermanagement.customer.management.Document.Customer;
import com.customermanagement.customer.management.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers",customers);
        return "index";
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "new_customer";
    }

    @PostMapping("/new")
    public String saveCustomer(Model model,@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer",customer);
            return "new_customer";
        }
        customerService.createCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String viewCustomer(Model model, @PathVariable("id") String id){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer",customer);
        return "view_customer";
    }

    @GetMapping("/edit/{id}")
    public String editCustomer(Model model, @PathVariable("id") String id) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer",customer);
        return "edit_customer";
    }
    @PostMapping("/edit/{id}")
    public String updateCustomer(Model model, @PathVariable("id") String id,@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_customer";
        }
        customerService.updateCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(Model model, @PathVariable("id") String id) {
        customerService.deleteCustomer(id);
        return "redirect:/";
    }
}
