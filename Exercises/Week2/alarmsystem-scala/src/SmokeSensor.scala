class SmokeSensor extends Sensor {
  //Exercise 2 implement SmokeSensor based on the instructions in the exercise

  private var smokeSensorCounter: Double = 0.0
  private var batteryPercentage: Double = 100.0
  private val location: String = "Lobby"
  private val sensorType: String = "smokeSensor"
  private val sensorCategory: String = "hazard"


  override def isTriggered: Boolean = {
    smokeSensorCounter += 1.0

    if (smokeSensorCounter >= 10.00) {
         true
    }
    else {
         false
    }
  }
  def giveAlarmNotification: Unit = {

    if(isTriggered) {

      println("The fire alarm is on.")
      println("Calling the firebrigade...")

    }
  }

  override def getLocation: String = {
    location
  }



  override def getSensorType: String = {
    sensorType

  }
  override def getSensorCategory :String = sensorCategory

  override def getBatteryPercentage: Double = {
    batteryPercentage = batteryPercentage - ((batteryPercentage / 100) * 20)
    batteryPercentage
  }
}
