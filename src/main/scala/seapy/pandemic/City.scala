package seapy.pandemic

import seapy.pandemic.Infection._

class City(val name: String, val infection: Infection){
  val neighbors: collection.mutable.Set[City] = collection.mutable.Set()
  val infectionCounts: collection.mutable.Map[Infection, Int] = collection.mutable.Map(Infection.Black -> 0,
    Infection.Blue -> 0,
    Infection.Red -> 0,
    Infection.Yellow -> 0)
}
