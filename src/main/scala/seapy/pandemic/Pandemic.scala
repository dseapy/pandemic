package seapy.pandemic

import seapy.pandemic.Infection.Infection

object Pandemic extends App {
  val cities = (new Board).cities
  for(c <- cities){
    println(s"City:\t${c.name}")
    print(s"Neighbors:\t")
    for(n <- c.neighbors){print(s"${n.name} ")}
    println("")
    println(s"Infection Type:\t${c.infection}")
    println("--------------------------------------------------")
  }
}

object Infection extends Enumeration {
  type Infection = Value
  val Red, Blue, Yellow, Black = Value
}

class City(val name: String,
           val infection: Infection,
           val neighbors: collection.mutable.Set[City] = collection.mutable.Set(),
           val infectionCounts: collection.mutable.Map[Infection, Int] = collection.mutable.Map().withDefaultValue(0)){

}

class Board {
  val cities: Set[City] = {
    val santiago = new City("Santiago", Infection.Yellow)
    val lima = new City("Lima", Infection.Yellow)
    val bogota = new City("Bogota", Infection.Yellow)
    val buenosAires = new City("Buenos Aires", Infection.Yellow)
    val saoPaulo = new City("Sao Paulo", Infection.Yellow)
    val mexicoCity = new City("Mexico City", Infection.Yellow)
    val losAngeles = new City("Los Angeles", Infection.Yellow)
    val miami = new City("Miami", Infection.Yellow)
    val lagos = new City("Lagos", Infection.Yellow)
    val kinshasa = new City("Kinshasa", Infection.Yellow)
    val johannesburg = new City("Johannesburg", Infection.Yellow)
    val khartoum = new City("Khartoum", Infection.Yellow)

    val sanFrancisco = new City("San Francisco", Infection.Blue)
    val chicago = new City("Chicago", Infection.Blue)
    val atlanta = new City("Atlanta", Infection.Blue)
    val montreal = new City("Montreal", Infection.Blue)
    val washington = new City("Washington", Infection.Blue)
    val newYork = new City("New York", Infection.Blue)
    val london = new City("London", Infection.Blue)
    val madrid = new City("Madrid", Infection.Blue)
    val paris = new City("Paris", Infection.Blue)
    val essen = new City("Essen", Infection.Blue)
    val milan = new City("Milan", Infection.Blue)
    val stPetersburg = new City("St. Petersburg", Infection.Blue)

    val algiers = new City("Algiers", Infection.Black)
    val istanbul = new City("Istanbul", Infection.Black)
    val cairo = new City("Cairo", Infection.Black)
    val moscow = new City("Moscow", Infection.Black)
    val baghdad = new City("Baghdad", Infection.Black)
    val riyadh = new City("Riyadh", Infection.Black)
    val tehran = new City("Tehran", Infection.Black)
    val karachi = new City("Karachi", Infection.Black)
    val mumbai = new City("Mumbai", Infection.Black)
    val delhi = new City("Delhi", Infection.Black)
    val chennai = new City("Chennai", Infection.Black)
    val kolkata = new City("Kolkata", Infection.Black)

    val beijing = new City("Beijing", Infection.Red)
    val seoul = new City("Seoul", Infection.Red)
    val tokyo = new City("Tokyo", Infection.Red)
    val shanghai = new City("Shanghai", Infection.Red)
    val hongKong = new City("Hong Kong", Infection.Red)
    val taipei = new City("Taipei", Infection.Red)
    val osaka = new City("Osaka", Infection.Red)
    val bangkok = new City("Bangkok", Infection.Red)
    val jakarta = new City("Jakarta", Infection.Red)
    val hoChiMinhCity = new City("Ho Chi Minh City", Infection.Red)
    val manila = new City("Manila", Infection.Red)
    val sydney = new City("Sydney", Infection.Red)

    val edges = Set(
      santiago -> lima, lima -> mexicoCity, lima -> bogota, mexicoCity -> losAngeles, mexicoCity -> chicago,
      mexicoCity -> miami, mexicoCity -> bogota, bogota -> miami, bogota -> buenosAires, bogota -> saoPaulo,
      buenosAires -> saoPaulo, saoPaulo -> madrid, saoPaulo -> lagos, losAngeles -> sydney, losAngeles -> sanFrancisco,
      losAngeles -> chicago, sanFrancisco -> tokyo, sanFrancisco -> manila, sanFrancisco -> chicago, chicago -> montreal,
      chicago -> atlanta, atlanta -> washington, atlanta -> miami, miami -> washington, montreal -> washington,
      montreal -> newYork, washington -> newYork, newYork -> london, newYork -> madrid, lagos -> kinshasa,
      lagos -> khartoum, kinshasa -> johannesburg, kinshasa -> khartoum, johannesburg -> khartoum, khartoum -> cairo,
      cairo -> algiers, algiers -> madrid, madrid -> london, london -> essen, essen -> stPetersburg, stPetersburg -> istanbul,
      istanbul -> cairo, istanbul -> algiers, algiers -> istanbul, istanbul -> milan, milan -> essen, milan -> paris,
      paris -> essen, paris -> algiers, paris -> madrid, paris -> london, cairo -> riyadh, riyadh -> karachi, karachi -> tehran,
      tehran -> moscow, moscow -> stPetersburg, moscow -> istanbul, istanbul -> baghdad, cairo -> baghdad, riyadh -> baghdad,
      baghdad -> karachi, baghdad -> tehran, tehran -> delhi, karachi -> delhi, karachi -> mumbai, mumbai -> delhi,
      mumbai -> chennai, chennai -> delhi, delhi -> kolkata, kolkata -> chennai, kolkata -> hongKong, kolkata -> bangkok,
      chennai -> bangkok, chennai -> jakarta, jakarta -> bangkok, jakarta -> sydney, jakarta -> hoChiMinhCity, sydney -> manila,
      manila -> hoChiMinhCity, manila -> hongKong, manila -> taipei, hoChiMinhCity -> bangkok, hoChiMinhCity -> hongKong,
      bangkok -> hongKong, hongKong -> shanghai, shanghai -> beijing, beijing -> seoul, seoul -> tokyo, tokyo -> osaka,
      osaka -> taipei, taipei -> hongKong, taipei -> shanghai, shanghai -> seoul, shanghai -> tokyo
    )

    //Add neighbors to all cities with the edges & yield the Set containing all the cities
    edges.flatMap{ edge =>
      edge._1.neighbors.add(edge._2)
      edge._2.neighbors.add(edge._1)
      Set(edge._1, edge._2)
    }
  }
}
