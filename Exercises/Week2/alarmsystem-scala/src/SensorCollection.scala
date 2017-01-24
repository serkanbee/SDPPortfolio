import scala.collection.mutable.ListBuffer

/**
  * Created by Serkan on 22/01/2017.
  */
class SensorCollection {

  def getHazardSensorCollection ={
    val hazardSensors = new ListBuffer[Sensor]()
    hazardSensors += new FireSensor()
    hazardSensors += new SmokeSensor()
    hazardSensors
  }

  def getSecuritySensorCollection ={
    val securitySensors = new ListBuffer[Sensor]()
    securitySensors += new MotionSensor()
    securitySensors
  }




}
