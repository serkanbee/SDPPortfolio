//import scala.collection.mutable.ListBuffer

object ControlUnit {


}

// Exercise 2 : Before the change below, its responsibility were 1) to create a object for each sensor and 2) poll each of them to see if they are triggered. If so,...
//...it gets location and sensorType info from them.
//Exercise 5: Now it pulls a collection of sensors from the SensorCollection class as opposed to doing it itself.

class ControlUnit {
  def pollSensors() {
      //Exercise 4: Dependency Inversion by way of SensorCollection class
      val sensors = new SensorCollection


    for (sensor <- sensors.getHazardSensorCollection) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation )
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}

/*val sensors = new ListBuffer[Sensor]()
  sensors += new FireSensor()
  sensors += new SmokeSensor()*/