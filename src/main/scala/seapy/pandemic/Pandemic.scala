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
  }
}

object Infection extends Enumeration {
  type Infection = Value
  val Red, Blue, Yellow, Black = Value
}

case class City(name: String,
                infection: Infection,
                neighbors: collection.mutable.Set[City] = collection.mutable.Set(),
                infectionCounts: collection.mutable.Map[Infection, Int] = collection.mutable.Map().withDefaultValue(0))

class Board {
  val cities: Set[City] = {
    val santiago = City("Santiago", Infection.Yellow)
    val lima = City("Lima", Infection.Yellow)
    val bogota = City("Bogota", Infection.Yellow)
    val buenosAires = City("Buenos Aires", Infection.Yellow)
    val saoPaulo = City("Sao Paulo", Infection.Yellow)
    val mexicoCity = City("Mexico City", Infection.Yellow)
    val losAngeles = City("Los Angeles", Infection.Yellow)
    val miami = City("Miami", Infection.Yellow)
    val lagos = City("Lagos", Infection.Yellow)
    val kinshasa = City("Kinshasa", Infection.Yellow)
    val johannesburg = City("Johannesburg", Infection.Yellow)
    val khartoum = City("Khartoum", Infection.Yellow)

    val sanFrancisco = City("San Francisco", Infection.Blue)
    val chicago = City("Chicago", Infection.Blue)
    val atlanta = City("Atlanta", Infection.Blue)
    val montreal = City("Montreal", Infection.Blue)
    val washington = City("Washington", Infection.Blue)
    val newYork = City("New York", Infection.Blue)
    val london = City("London", Infection.Blue)
    val madrid = City("Madrid", Infection.Blue)
    val paris = City("Paris", Infection.Blue)
    val essen = City("Essen", Infection.Blue)
    val milan = City("Milan", Infection.Blue)
    val stPetersburg = City("St. Petersburg", Infection.Blue)

    val algiers = City("Algiers", Infection.Black)
    val istanbul = City("Istanbul", Infection.Black)
    val cairo = City("Cairo", Infection.Black)
    val moscow = City("Moscow", Infection.Black)
    val baghdad = City("Baghdad", Infection.Black)
    val riyadh = City("Riyadh", Infection.Black)
    val tehran = City("Tehran", Infection.Black)
    val karachi = City("Karachi", Infection.Black)
    val mumbai = City("Mumbai", Infection.Black)
    val delhi = City("Delhi", Infection.Black)
    val chennai = City("Chennai", Infection.Black)
    val kolkata = City("Kolkata", Infection.Black)

    val beijing = City("Beijing", Infection.Red)
    val seoul = City("Seoul", Infection.Red)
    val tokyo = City("Tokyo", Infection.Red)
    val shanghai = City("Shanghai", Infection.Red)
    val hongKong = City("Hong Kong", Infection.Red)
    val taipei = City("Taipei", Infection.Red)
    val osaka = City("Osaka", Infection.Red)
    val bangkok = City("Bangkok", Infection.Red)
    val jakarta = City("Jakarta", Infection.Red)
    val hoChiMinhCity = City("Ho Chi Minh City", Infection.Red)
    val manila = City("Manila", Infection.Red)
    val sydney = City("Sydney", Infection.Red)

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
