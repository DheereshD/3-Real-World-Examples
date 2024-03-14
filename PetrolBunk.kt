@file:Suppress("DEPRECATION")
import java.util.Date

// To define Petrol rate and validity date.
class Petrol(var rate: Double, var validityDate: Date) {
    fun updateRate(newRate: Double, newValidityDate: Date) {
        val currentDate = Date()
        if (newValidityDate.before(currentDate)) {                                   // reference https://kodejava.org/how-do-i-know-if-a-date-is-before-another-date/
            throw IllegalArgumentException("Validity date cannot be before set date")
        }
        var differenceRate: Double = newRate - rate
        if (differenceRate < 0.0){
            differenceRate = differenceRate * -1.0
        }

        if (rate < newRate) {
            println("petrol price went UP by $differenceRate ")
        }
        if (rate > newRate){
            println("petrol price went DOWN by $differenceRate ")
        }
        else {
            println("petrol price remains the same")
        }

        rate = newRate
        validityDate = newValidityDate
        println ("Petrol rate has been set to $rate valid until $validityDate")
    }
}

// To define Diesel rate and validity date.
class Diesel(var rate: Double, var validityDate: Date) {
    fun updateRate(newRate: Double, newValidityDate: Date) {
        val currentDate = Date()
        if (newValidityDate.before(currentDate)){
            throw IllegalArgumentException("Validity date cannot be before set date")
        }
        var differenceRate: Double = newRate - rate
        if (differenceRate < 0.0){
            differenceRate = differenceRate * -1.0
        }

        if (rate < newRate) {
            println("Diesel price went UP by $differenceRate ")
        }
        if (rate > newRate) {
            println("Diesel price went DOWN by $differenceRate ")
        }
        else {
            println("Diesel price remains the same")
        }

        rate = newRate
        validityDate = newValidityDate
    }
}

// Vendor class for dispensing petrol/diesel.
class Vendor {
    fun dispensePetrol(quantity: Double, petrol: Petrol): Double {
        // Calculate cost based on quantity and current rate
        return quantity * petrol.rate
    }

    fun dispenseDiesel(quantity: Double, diesel: Diesel): Double {
        // Calculate cost based on quantity and current rate
        return quantity * diesel.rate
    }
}

fun main() {
    // Create instances of Petrol and Diesel classes

    val petrol = Petrol(100.0, validityDate = Date(2025, 8, 16))
    val diesel = Diesel(110.0, validityDate = Date(2025, 7, 20))

    val vendor = Vendor()

    //updating petrol rate and validity date
    try {
        petrol.updateRate(20.0, newValidityDate = Date(2022, 6, 29))
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    try {
        diesel.updateRate(110.0, newValidityDate = Date(2026, 6, 29))
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    // Dispensing petrol and calculating cost.
    val petrolCost = vendor.dispensePetrol(10.0, petrol)
    println("Cost of 10 liters of petrol: $petrolCost")


    // Dispensing diesel and calculating cost.
    val dieselCost = vendor.dispenseDiesel(10.0, diesel)
    println("Cost of 10 liters of diesel: $dieselCost")

}



