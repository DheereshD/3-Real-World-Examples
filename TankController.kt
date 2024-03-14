/* This program is to set the parameters of an automated fish tank where the light control , filter control
and the feeding amount of the fish is set.
*/
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private class FishTank(val numberOfFishes: Int) {

    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("hh")
    val formattedHour = current.format(formatter)
    val currentHours = formattedHour.toInt()

    // This function allows to set turn on time and turn off time for Lights.
    fun controlLight(turnOnTime: Int, turnOffTime: Int) {
        println("Light scheduled to turn on at $turnOnTime Hour and turn off at $turnOffTime Hour")

        if (turnOffTime <= turnOnTime) {
            throw IllegalArgumentException("Turn off time cannot be less then turn on time")
        }
        if (currentHours > turnOnTime && currentHours <turnOffTime){
            println("Lights are ON")
        }
        else {
            println("Lights are OFF")
        }
    }
    // This function allows to set turn on time and turn off time for Filter.
    fun controlFilter(turnOnTime: Int, turnOffTime: Int) {
        println("Filter scheduled to turn on at $turnOnTime Hour and turn off at $turnOffTime Hour")
        if (turnOffTime <= turnOnTime) {
            throw IllegalArgumentException("Turn off time cannot be less then turn on time")
        }
        if (currentHours >= turnOnTime && currentHours <= turnOffTime){
            println("Filter is running ")
        }
        else {
            println("Filter is OFF")
        }
    }
    //sets the amount of food per fish needs.
    fun feedingControl(foodPerFish: Int, feedingTime: Int) {
        val feedAmount = numberOfFishes * foodPerFish
        println("Feeding fishes set to $feedAmount grams of food")
        if (currentHours == feedingTime ){
           println("Feeding Fishes")
        }

    }


}

fun main() {

    val fishTank = FishTank(10) // 10 fishes are in tank
    fishTank.feedingControl(15, 2) // assuming each fish consumes 15 grams of food
    fishTank.controlLight(3, 4)
    fishTank.controlFilter(1,10)

}
