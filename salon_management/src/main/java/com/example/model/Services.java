package com.example.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String description;
    private double price;

    @OneToMany(mappedBy = "services")  // The "services" field in InventoryItem should match this
    private List<InventoryItem> inventoryItems; // Assuming InventoryItem is another entity

    // Default constructor
    public Services() {}

    // Constructor with fields
    public Services(String serviceName, String description, double price) {
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    // Override equals() and hashCode() for proper entity comparison in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services services = (Services) o;
        return id != null && id.equals(services.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // Override toString() for easier debugging
    @Override
    public String toString() {
        return "Services [id=" + id + ", serviceName=" + serviceName + ", description=" + description + ", price=" + price + "]";
    }
}
