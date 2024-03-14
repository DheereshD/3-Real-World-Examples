/*
This program is for inventory management system to track products and
quantity in the warehouse.
*/

import java.util.Scanner

data class Product(val name: String, var quantity: Int)

class InventoryManagementSystem {
    private val inventory = mutableMapOf<String, Product>()

    fun addProduct(name: String, quantity: Int) {
        if (inventory.containsKey(name)) {
            println("Product '$name' already exists. Use updateProduct() to modify quantity.")
        }
        else{
            inventory[name] = Product(name, quantity)
            println("Product '$name' added to inventory with quantity $quantity.")
        }
    }

    fun updateProduct(name: String, quantity: Int) {
        if(inventory.containsKey(name)) {
            inventory[name]?.quantity = quantity
            println("Quantity for product '$name' updated to $quantity.")
        }
        else {
            println("Product '$name' does not exist in inventory. Use addProduct() to add it.")
        }
    }

    fun removeProduct(name: String) {
        if (inventory.containsKey(name)) {
            inventory.remove(name)
            println("Product '$name' removed from inventory.")
        }
        else {
            println("Product '$name' does not exist in inventory.")
        }
    }

    fun displayInventory() {
        if (inventory.isEmpty()) {
            println("Inventory is empty.")
        }
        else {
            println("Current Inventory:")
            inventory.forEach { (name, product) ->
                println("$name - Quantity: ${product.quantity}")
            }
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val inventoryManagementSystem = InventoryManagementSystem()

    var option: Int
    do {
        println("\n1. Add Product\n2. Update Product\n3. Remove Product\n4. Display Inventory\n5. Exit")
        print("Enter your choice: ")
        option = scanner.nextInt()

        when (option) {
            1 -> {
                print("Enter product name: ")
                val name = scanner.next()
                print("Enter quantity: ")
                val quantity = scanner.nextInt()
                inventoryManagementSystem.addProduct(name, quantity)
            }
            2 -> {
                print("Enter product name: ")
                val name = scanner.next()
                print("Enter new quantity: ")
                val quantity = scanner.nextInt()
                inventoryManagementSystem.updateProduct(name, quantity)
            }
            3 -> {
                print("Enter product name to remove: ")
                val name = scanner.next()
                inventoryManagementSystem.removeProduct(name)
            }
            4 -> inventoryManagementSystem.displayInventory()
            5 -> println("Exiting...")
            else -> {
                println("Invalid option. Please try again.")
            }
        }
    }
    while (option != 5)
}