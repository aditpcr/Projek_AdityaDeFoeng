package com.example.projek_adityadefoeng

import androidx.annotation.DrawableRes

data class Destination(
    val id: Int,
    val name: String,
    val location: String,
    @DrawableRes val imageRes: Int,
    val rating: Float,
    val about: String,
    val tips: String,
    val bestTime: String
)

/** Sumber data sementara (hardcoded). Nanti bisa diganti API / database. */
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
            rating = 4.5f,
            about = "TODO: isi deskripsi Kelingking Beach.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 3,
            name = "Raja Ampat",
            location = "Southwest Papua",
            imageRes = R.drawable.rajaampat,
            rating = 5f,
            about = "TODO: isi deskripsi Raja Ampat.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 4,
            name = "Padar Island",
            location = "East Nusa Tenggara",
            imageRes = R.drawable.padar,
            rating = 4.5f,
            about = "TODO: isi deskripsi Padar Island.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 5,
            name = "Pink Beach",
            location = "East Nusa Tenggara",
            imageRes = R.drawable.pink,
            rating = 4f,
            about = "TODO: isi deskripsi Pink Beach.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 6,
            name = "Tanjung Kelayang",
            location = "Belitung",
            imageRes = R.drawable.tanjangkelayang,
            rating = 4.5f,
            about = "TODO: isi deskripsi Tanjung Kelayang.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 7,
            name = "Tanjung Kelayang",
            location = "Belitung",
            imageRes = R.drawable.tanjangkelayang,
            rating = 4.5f,
            about = "TODO: isi deskripsi Tanjung Kelayang.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 8,
            name = "Tanjung Kelayang",
            location = "Belitung",
            imageRes = R.drawable.tanjangkelayang,
            rating = 4.5f,
            about = "TODO: isi deskripsi Tanjung Kelayang.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 9,
            name = "Tanjung Kelayang",
            location = "Belitung",
            imageRes = R.drawable.tanjangkelayang,
            rating = 4.5f,
            about = "TODO: isi deskripsi Tanjung Kelayang.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        ),
        Destination(
            id = 10,
            name = "Tanjung Kelayang",
            location = "Belitung",
            imageRes = R.drawable.tanjangkelayang,
            rating = 4.5f,
            about = "TODO: isi deskripsi Tanjung Kelayang.",
            tips = "TODO: isi tips perjalanan.",
            bestTime = "TODO: isi waktu terbaik berkunjung."
        )


    )

    fun findById(id: Int): Destination? = list.firstOrNull { it.id == id }
}