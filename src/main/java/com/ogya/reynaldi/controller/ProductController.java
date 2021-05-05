package com.ogya.reynaldi.controller;

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

import com.ogya.reynaldi.model.Product;
import com.ogya.reynaldi.repository.ProductRepository;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product")
	public String findbyname(@RequestParam(required = false, defaultValue = "") String name,
			Model model,
			@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
			) {
		List<Product> Products;
		
		if (name != null && !name.isEmpty()) {
			Products = productRepository.findByName(name);
		} else {
			Products = productRepository.findAll();
		}
		
		model.addAttribute("products", Products);
		model.addAttribute("name", name);
		
		return "products/product";
	}
	
	@GetMapping("/add")
	public String showSignUpForm(Product product) {
		return "products/add-product";
	}
	
	@PostMapping("/addproduct")
    public String addProduct(@Valid Product product, BindingResult result, Model model, Pageable pageable) {
        if (result.hasErrors()) {
            return "products/add-product";
        }

        productRepository.save(product);
        model.addAttribute("Inventorys", productRepository.findAll());
        return "redirect:/product";

    }
	
	// additional CRUD methods
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
    	Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        model.addAttribute("product", product);
        return "products/update-product";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Product product,
                             BindingResult result, Model model, Pageable pageable) {
        if (result.hasErrors()) {
        	product.setId(id);
            return "operations/update-product";
        }

        productRepository.save(product);
        model.addAttribute("products", productRepository.findAll());
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model, Pageable pageable) {
    	Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
    	productRepository.delete(product);
        model.addAttribute("products", productRepository.findAll());
        return "redirect:/product";
    }
    
    
}
