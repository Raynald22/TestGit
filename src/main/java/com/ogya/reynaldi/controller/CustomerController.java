package com.ogya.reynaldi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ogya.reynaldi.model.Customer;
import com.ogya.reynaldi.repository.CustomerRepository;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public String main(@RequestParam(required = false, defaultValue = "") String search,
                       Model model,
                       @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        List<Customer> Customers;

        if (search != null && !search.isEmpty()) {
        	System.out.print("search: " + search);
        	Customers = customerRepository.findByFirstName(search);
            System.out.print("customers: " + Customers);
        } else {
        	Customers = customerRepository.findAll();
        }

        model.addAttribute("customers", Customers);
        model.addAttribute("search", search);

        return "customers/customer";
    }


    @GetMapping("/addCustomer")
    public String showSignUpForm(Customer customer) {
        return "customers/add-customer";
    }

    @PostMapping("/addcustomer")
    public String addProduct(@Valid Customer customer, BindingResult result, Model model, Pageable pageable) {
        if (result.hasErrors()) {
            return "customers/add-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:/customer";

    }

    // additional CRUD methods
    @GetMapping("/editcustomer/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("customer", customer);
        return "customers/update-customer";
    }

    @PostMapping("/updatecustomer/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Customer customer,
                             BindingResult result, Model model, Pageable pageable) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "customers/update-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:/customer";
    }

    @GetMapping("/deletecustomer/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model, Pageable pageable) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        customerRepository.delete(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "redirect:/customer";
    }
}