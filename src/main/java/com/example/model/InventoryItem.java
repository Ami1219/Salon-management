package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "inventory_id")  // Optional if the column name is different
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "services_id")  // Foreign key to the Services table
    private Services services;

    // Constructors, Getters, Setters, toString, equals, hashCode methods

    public InventoryItem() {}

    public InventoryItem(String name, int quantity, Inventory inventory, Services services) {
        this.name = name;
        this.quantity = quantity;
        this.inventory = inventory;  // Corrected constructor to initialize Inventory
        this.services = services;    // Initialize Services if needed
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Inventory getInventory() { return inventory; }
    public void setInventory(Inventory inventory) { this.inventory = inventory; }

    public Services getServices() { return services; }
    public void setServices(Services services) { this.services = services; }

    @Override
    public String toString() {
        return "InventoryItem [id=" + id + ", name=" + name + ", quantity=" + quantity + ", inventory=" + inventory + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem that = (InventoryItem) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
