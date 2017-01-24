trait Sensor {
  def isTriggered: Boolean

  def getLocation: String
  //Exercise 8 part b: modify sensor trait to accommodate the recognition of sensor categories

  def getSensorType: String

  def getSensorCategory :String

  def getBatteryPercentage: Double
}


/*
* c
*
*
*
* */