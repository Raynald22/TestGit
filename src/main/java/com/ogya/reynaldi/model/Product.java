package com.ogya.reynaldi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Brand is mandatory")
    @Column(name = "brand")
    private String brand;
    
    @NotBlank(message = "Made In is mandatory")
    @Column(name = "madein")
    private String madein;
    
    @NotNull(message = "Price is mandatory")
    @Column(name = "price")
    private double price;
    
    public Product() {
    }

	public Product(int id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Brand is mandatory") String brand,
			@NotBlank(message = "Made In is mandatory") String madein,
			@NotNull(message = "Price is mandatory") double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", madein=" + madein + ", price=" + price
				+ "]";
	}

}
