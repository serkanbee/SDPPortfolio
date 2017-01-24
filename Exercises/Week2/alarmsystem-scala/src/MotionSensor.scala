/**
  * Created by Serkan on 22/01/2017.
  */


//import java.util.Calendar

class MotionSensor extends Sensor {


    private val location: String = "frontDoor"
    private val sensorType: String = "motionSensorType"
    private val sensorCategory: String = "securityCategory"


    /*def checkTime() : Double = {

      val now = Calendar.getInstance()
      now
    }*/

  override def isTriggered: Boolean = {
    true
  }

  override def getLocation: String = {
    location

  }

  override def getSensorType: String = {
    sensorType
  }

  override def getSensorCategory :String = {
    sensorCategory
  }
  override def getBatteryPercentage: Double = {
     throw new Exception("This sensor is not operated by batteries")
  }
}
