package seapy.pandemic


import seapy.pandemic.Infection.Infection

object Pandemic extends App {

}

object Infection extends Enumeration {
  type Infection = Value
  val Red, Blue, Yellow, Black = Value
}

case class City(name: String,
                infection: Infection,
                neighbors: collection.mutable.Seq[City] = collection.mutable.Seq(),
                infectionCounts: Map[Infection, Int] = Map.withDefaultValue(0)){

}

class Board {
  val santiago =      City("Santiago", Infection.Yellow)
  val lima =          City("Lima", Infection.Yellow)
  val bogota =        City("Bogota", Infection.Yellow)
  val buenosAires =   City("Buenos Aires", Infection.Yellow)
  val saoPaulo =      City("Sao Paulo", Infection.Yellow)
  val mexicoCity =    City("Mexico City", Infection.Yellow)
  val losAngeles =    City("Los Angeles", Infection.Yellow)
  val miami =         City("Miami", Infection.Yellow)
  val lagos =         City("Lagos", Infection.Yellow)
  val kinshasa =      City("Kinshasa", Infection.Yellow)
  val johannesburg =  City("Johannesburg", Infection.Yellow)
  val khartoum =      City("Khartoum", Infection.Yellow)

  val sanFrancisco =  City("San Francisco", Infection.Blue)
  val chicago =       City("Chicago", Infection.Blue)
  val atlanta =       City("Atlanta", Infection.Blue)
  val montreal =      City("Montreal", Infection.Blue)
  val washington =    City("Washington", Infection.Blue)
  val newYork =       City("New York", Infection.Blue)
  val london =        City("London", Infection.Blue)
  val madrid =        City("Madrid", Infection.Blue)
  val paris =         City("Paris", Infection.Blue)
  val essen =         City("Essen", Infection.Blue)
  val milan =         City("Milan", Infection.Blue)
  val stPetersburg =  City("St. Petersburg", Infection.Blue)

  //todo: rest of cities
  
  def edges(): Map[City, City] = Map(
    santiago -> lima,
    lima -> mexicoCity,
    lima -> bogota,
    mexicoCity -> losAngeles,
    mexicoCity -> chicago,
    mexicoCity -> miami,
    mexicoCity -> bogota,
    bogota -> miami,
    bogota -> buenosAires,
    bogota -> saoPaulo,
    buenosAires -> saoPaulo,
    saoPaulo -> madrid,
    saoPaulo -> lagos,
    losAngeles -> sydney,
    losAngeles -> sanFrancisco,
    losAngeles -> chicago,

    //todo: rest of edges
  )

  //todo: set the neihbors of the cities to that indicated by the edges
}
