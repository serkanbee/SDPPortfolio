/**
  * Created by Serkan on 22/01/2017.
  */
class SecurityControlUnit {

  var time: Double = 2300

  def timeCheck(time: Double) = {

    if (time > 2200 ) {
      true
    }
    false
  }

  if (timeCheck(time).equals(true)) { pollSensors()}


  def pollSensors() {

      val sensors = new SensorCollection

      for (sensor <- sensors.getSecuritySensorCollection) {
        if (sensor.isTriggered) {
          System.out.println("A " + sensor.getSensorType +  " sensor was triggered at " + sensor.getLocation )
        }
        else {
          System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
        }
      }
    }

}





