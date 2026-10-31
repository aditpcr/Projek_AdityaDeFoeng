package com.example.projek_adityadefoeng

import androidx.annotation.DrawableRes

data class Destination(
    val id: Int,
    val name: String,
    val location: String,
    @DrawableRes val imageRes: Int,
    val avatarUrl: String = "",
    val rating: Float = 4.5f,
    val about: String = "",
    val tips: String = "",
    val bestTime: String = ""
)

/** Sumber data sementara. */
object DestinationData {
    val list = listOf(
        Destination(
            id = 1,
            name = "Diamond Beach",
            location = "Nusa Penida, Bali",
            imageRes = R.drawable.diamond,
            rating = 4.5f,
            about = "Discover the breathtaking beauty of Diamond Beach, a hidden paradise on Nusa Penida, Bali. Marvel at towering limestone cliffs, pristine white sands, and crystal-clear turquoise waters. Descend the iconic cliffside staircase to experience one of Indonesia’s most stunning coastal landscapes, perfect for sightseeing, photography, and unforgettable adventures.",
            tips = "Wear sturdy footwear for the steep staircase, bring drinking water, and be cautious near the cliffs and shoreline. Strong waves and currents can make swimming dangerous.",
            bestTime = "Early morning is ideal for softer light, cooler temperatures, and a more relaxed sightseeing experience."
        ),
        Destination(
            id = 2,
            name = "Kelingking Beach",
            location = "Nusa Penida, Bali",
            imageRes = R.drawable.kelingking,
            rating = 4.8f,
            about = "Kelingking Beach is world-famous for its T-Rex shaped cliff formation jutting out into the ocean. The viewpoint from above offers one of Bali's most iconic vistas, overlooking secluded white sand and deep blue waters below.",
            tips = "The hike down the ridge is very steep and challenging with minimal safety railings. Ensure you have proper hiking shoes, stay hydrated, and avoid descending during extreme heat.",
            bestTime = "Late afternoon around 4 PM offers pleasant lighting for photos and cooler weather for the trek."
        ),
        Destination(
            id = 3,
            name = "Raja Ampat",
            location = "Southwest Papua",
            imageRes = R.drawable.rajaampat,
            rating = 5.0f,
            about = "Raja Ampat is a pristine archipelago consisting of over 1,500 small islands, cays, and shoals. Known as the epicenter of marine biodiversity, it harbors over 75% of all known coral species, making it a world-renowned haven for divers and nature enthusiasts.",
            tips = "Purchase the Environmental Maintenance Fee pin before visiting. Carry cash as ATM facilities are limited across the remote islands.",
            bestTime = "October to April offers the calmest seas and optimum underwater visibility for diving and snorkeling."
        ),
        Destination(
            id = 4,
            name = "Padar Island",
            location = "East Nusa Tenggara",
            imageRes = R.drawable.padar,
            rating = 4.7f,
            about = "Padar Island is the third largest island in Komodo National Park. Famous for its dramatic landscape of rugged volcanic mountains surrounded by three distinct crescent-shaped bays with white, pink, and black sand beaches.",
            tips = "Trek to the summit viewpoint early in the morning via the stone staircase. Bring sun protection and plenty of drinking water as there is very little shade along the trail.",
            bestTime = "Sunrise (5:30 AM to 6:30 AM) provides cooler trekking temperatures and incredible golden light across the bays."
        ),
        Destination(
            id = 5,
            name = "Pink Beach",
            location = "East Nusa Tenggara",
            imageRes = R.drawable.pink,
            rating = 4.6f,
            about = "Pink Beach (Pantai Merah) is one of only seven pink beaches in the world. The striking pink hue comes from microscopic animals called Foraminifera, which produce red pigment on the coral reefs, mixed with fine white sand.",
            tips = "Please do not collect or take any pink sand home to protect the natural ecosystem. Bring snorkeling gear to explore the thriving colorful reef right near the shore.",
            bestTime = "Midday around 11 AM to 2 PM when bright sunlight makes the pink sand color look most vibrant."
        ),
        Destination(
            id = 6,
            name = "Tanjung Kelayang",
            location = "Belitung",
            imageRes = R.drawable.tanjangkelayang,
            rating = 4.5f,
            about = "Tanjung Kelayang is a picturesque peninsula in Belitung known for its smooth white sand, calm turquoise waters, and colossal granite rock formations rising majestically out of the sea.",
            tips = "Rent a local boat from the beach pier for an island-hopping day trip to nearby Lengkuas Island and Garuda Rock.",
            bestTime = "March to October during the dry season for smooth seas and clear blue skies."
        ),
        Destination(
            id = 7,
            name = "Borobudur Temple",
            location = "Magelang, Central Java",
            imageRes = R.drawable.padar,
            rating = 4.9f,
            about = "Borobudur is the world's largest Buddhist temple, built in the 9th century during the reign of the Sailendra Dynasty. Decorated with 2,672 relief panels and 504 Buddha statues, it stands as a UNESCO World Heritage site and an architectural marvel.",
            tips = "Book sunrise entrance passes in advance. Wear comfortable walking shoes and modest clothing covering shoulders and knees.",
            bestTime = "Early morning at 6:00 AM for fresh air and serene atmosphere before daytime tour crowds arrive."
        ),
        Destination(
            id = 8,
            name = "Lake Toba",
            location = "North Sumatra",
            imageRes = R.drawable.rajaampat,
            rating = 4.7f,
            about = "Lake Toba is an immense volcanic lake situated inside a massive supervolcano caldera. In the center sits Samosir Island, a cultural heartland of the Batak people rich in traditional architecture, hot springs, and scenic waterfalls.",
            tips = "Rent a scooter on Samosir Island to explore traditional Batak villages and scenic lakeshore roads at your own pace.",
            bestTime = "May to September during dry weather, ideal for outdoor sightseeing and lake cruises."
        ),
        Destination(
            id = 9,
            name = "Derawan Islands",
            location = "East Kalimantan",
            imageRes = R.drawable.pink,
            rating = 4.8f,
            about = "Derawan Islands are a tropical island paradise in East Kalimantan famous for giant sea turtle nesting sites, stingless jellyfish lakes on Kakaban Island, and pristine coral reefs filled with manta rays.",
            tips = "Do not wear sunscreen before swimming in the stingless jellyfish lake to protect the fragile aquatic environment.",
            bestTime = "September to April for calm sea conditions and optimal snorkeling visibility."
        ),
        Destination(
            id = 10,
            name = "Tana Toraja",
            location = "South Sulawesi",
            imageRes = R.drawable.tanjangkelayang,
            rating = 4.6f,
            about = "Tana Toraja is a lush highland region renowned for its distinct culture, traditional boat-shaped Tongkonan houses, cliffside hanging graves, and elaborate funeral ceremonies (Rambo Solo).",
            tips = "Hire a knowledgeable local guide to explain cultural customs and respectfully observe ceremony traditions.",
            bestTime = "July and August when most traditional cultural ceremonies take place across Toraja villages."
        )
    )

    fun findById(id: Int): Destination? = list.firstOrNull { it.id == id }
}