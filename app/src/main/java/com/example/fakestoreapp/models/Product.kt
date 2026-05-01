package com.example.fakestoreapp.models

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

val productList = listOf(
    Product(
        id = 1,
        title = "Classic Chronograph",
        price = 120.0,
        description = "A timeless classic for the modern gentleman. Stainless steel case and genuine leather strap.",
        category = "Classic",
        image = "https://images.unsplash.com/photo-1524592094714-0f0654e20314?q=80&w=1000&auto=format&fit=crop",
        rating = Rating(rate = 4.5, count = 120)
    ),
    Product(
        id = 2,
        title = "Minimalist Silver",
        price = 85.0,
        description = "Sleek and simple. The perfect accessory for any outfit. Thin profile with a mesh band.",
        category = "Minimalist",
        image = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?q=80&w=1000&auto=format&fit=crop",
        rating = Rating(rate = 4.8, count = 85)
    ),
    Product(
        id = 3,
        title = "Sport Digital",
        price = 45.0,
        description = "Durable and functional. Water resistant up to 50m with backlight and stopwatch features.",
        category = "Sport",
        image = "https://images.unsplash.com/photo-1542496658-e33a6d0d50f6?q=80&w=1000&auto=format&fit=crop",
        rating = Rating(rate = 4.2, count = 210)
    ),
    Product(
        id = 4,
        title = "Luxury Gold",
        price = 299.0,
        description = "Elegant 18k gold plated watch with sapphire crystal glass. A true statement piece.",
        category = "Luxury",
        image = "https://images.unsplash.com/photo-1614164185128-e4ec99c436d7?q=80&w=1000&auto=format&fit=crop",
        rating = Rating(rate = 4.9, count = 45)
    ),
    Product(
        id = 5,
        title = "Midnight Black",
        price = 110.0,
        description = "All black everything. Matte finish with a comfortable silicone strap for daily wear.",
        category = "Minimalist",
        image = "https://images.unsplash.com/photo-1508685096489-7aacd43bd3b1?q=80&w=1000&auto=format&fit=crop",
        rating = Rating(rate = 4.6, count = 150)
    ),
    Product(
        id = 6,
        title = "Vintage Brown",
        price = 95.0,
        description = "Retro-inspired design with a distressed leather strap and cream-colored dial.",
        category = "Classic",
        image = "https://images.unsplash.com/photo-1539533018447-63fcce2678e3?q=80&w=1000&auto=format&fit=crop",
        rating = Rating(rate = 4.4, count = 92)
    )
)