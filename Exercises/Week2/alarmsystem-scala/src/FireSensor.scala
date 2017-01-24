class FireSensor extends Sensor {
//Exercise 1 implement FireSensor based on the instructions in the exercise


  private var fireSensorCounter: Double = 0.0
  private var batteryPercentage: Double = 100
  private val location: String = "1st Floor"
  private val sensorType: String = "fireSensor"
  private val sensorCategory: String = "hazard"
  private var fireAlarm: Boolean = false

  override def isTriggered: Boolean = {
    fireSensorCounter += 1
    if (fireSensorCounter == 0.0) {
       true
    }
    else{

      false
    }
  }

  def alarmNotification: Unit = {
    if(isTriggered) {

      println("The fire alarm is on.")
      println("Calling the firebrigade...")
    }
  }



  override def getLocation: String = {
    location
  }

  override def getSensorType: String ={
    sensorType
  }
  override def getSensorCategory :String = sensorCategory


  override def getBatteryPercentage: Double = {
    batteryPercentage = batteryPercentage - ((batteryPercentage / 100) * 10)
    batteryPercentage
  }
}
