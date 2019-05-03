/**
 * Name:	Michael Ressler
 * Class:	CSCI305 Progamming Languages and Concepts
 * Assignment:	Kotlin Program
 * Date:	3/15/2019
 */

data class City(val name: String, val latitude: Double, val longitude: Double) //Step One


fun main() {
    
    var cityLocations: List<City>
    
    cityLocations = listCities()
  
    println("**********Step Two**********")
    for (i in 0 until cityLocations.size) {

        println("${cityLocations[i]} ")
    }
    println()
    
    println("**********Step Three**********")
    
    println("The distance between Tacoma and Seattle is\n " + distanceFromSeattle(cityLocations[4]) + " km\n")
    
    println("**********Step Four**********")
	
    println(cityLocations.map { distanceFromSeattle(it) })
    println()

    println("**********Step Five**********")
    
    var ll: List<City>
    ll = cityLocations.filter { distanceFromSeattle(it) > 1000 }
    furthest(ll)
	println()
    
     println("**********Step Six**********")
     
     //Print longitude less than -89.97803
     var jk: List<City>
       
     jk = cityLocations.filter { west(it) < -89.97803 }
     println(jk.map { it.name })
     println()
     
     println("**********Step Seven***********")
     
     println("Max Distance: " + cityLocations.maxBy { distanceFromSeattle(it) })
     println()
     
     println("**********Step Eight***********")
     
    val mappedCities = mutableMapOf<String, City>()
    
    val Atlanta = City("Atlanta", 33.7490, -84.3880)
    val Bozeman = City("Bozeman", 45.6770, -111.0429)
    val NewYork = City("New York", 40.7128, -74.0060)    
    val SanFrancisco = City("San Francisco", 37.7749, -122.4194)
    val Tacoma = City("Tacoma", 47.2529, -122.4443)
    
    
    mappedCities["Atlanta"] = Atlanta
    mappedCities["Bozeman"] = Bozeman
    mappedCities["New York"] = NewYork
    mappedCities["San Francisco"] = SanFrancisco
    mappedCities["Tacoma"] = Tacoma
    println(mappedCities)

    println("The latitude for Bozeman is " + Bozeman.latitude)
 // println(cityLocations[1])
      
}


fun name(City1: City): String {
  
   	 	var (name, latitude, longitude) = City1

   	 	return(name)

}

fun west(City1: City): Double {
  
   	 	var (name, latitude, longitude) = City1

   	 	return(longitude)

}


fun furthest(ll: List<City>) {
    
    for (i in 0 until ll.size) {
        val (name) = ll[i]
        println("$name")
    }
}

            
fun listCities() : List<City> {
 
    val Atlanta = City("Atlanta", 33.7490, -84.3880)
    val Bozeman = City("Bozeman", 45.6770, -111.0429)
    val NewYork = City("New York", 40.7128, -74.0060)    
    val SanFrancisco = City("San Francisco", 37.7749, -122.4194)
    val Tacoma = City("Tacoma", 47.2529, -122.4443)
    
    var cityLocations = listOf(Atlanta, Bozeman, NewYork, SanFrancisco, Tacoma)
    
    return cityLocations
}

fun distanceFromSeattle(city1: City) : Double {
    
    var distance: Double 
    val Seattle = City("Seattle", 47.6062, -122.3321)
    distance = haversine(city1.latitude, city1.longitude, Seattle.latitude, Seattle.longitude)
    return distance
}


fun haversine(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {    
	
    val R = 6372.8 // in kilometers    
	val l1 = Math.toRadians(lat1)    
	val l2 = Math.toRadians(lat2)    
	val dl = Math.toRadians(lat2 - lat1)    
	val dr = Math.toRadians(lon2 - lon1)   

    return 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin(dl / 2), 2.0) +
		Math.pow(Math.sin(dr / 2), 2.0) * Math.cos(l1) * Math.cos(l2)))
}