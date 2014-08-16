package seapy.pandemic

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

  val tokyo = cities.filter(_.name == "Tokyo").head
  tokyo.infectionCounts.update(Infection.Red, tokyo.infectionCounts.get(Infection.Red).get + 3)
  println(s"Tokyo: ${tokyo.infectionCounts.get(Infection.Red).get}")
  cities.filter(_.name == "Osaka").head.neighbors.foreach(n => println(n.name + " " + n.infectionCounts.get(Infection.Red).get))

}


