package com.example.mindtechtaskxml.model.dataClass

data class Car(
    val carImage: String,
    val brandName: String,
    val color: String,
    val title: String
)

data class CarBrand(
    val brandLogoUrl: String,
    val brandName: String
)

val carBrands = listOf<CarBrand>(
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/31618144/pexels-photo-31618144/free-photo-of-close-up-of-a-nissan-steering-wheel.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Nissan"
    ), CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/16646461/pexels-photo-16646461/free-photo-of-dashboard-with-steering-wheel.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Volkswagen"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/29603842/pexels-photo-29603842/free-photo-of-close-up-of-ferrari-logo-on-red-surface.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Ferrari"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/29298444/pexels-photo-29298444/free-photo-of-close-up-of-jeep-car-grille-with-logo.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Jeep"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/373282/pexels-photo-373282.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/1338396/pexels-photo-1338396.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "BMW"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/168938/pexels-photo-168938.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Audi"
    ),
    CarBrand(
        brandLogoUrl = "https://blog.boon.so/wp-content/uploads/2024/03/Land-Rover-Logo-2-768x576.jpg",
        brandName = "Range Rover"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/7738877/pexels-photo-7738877.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Ford"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/29189114/pexels-photo-29189114/free-photo-of-close-up-of-renault-vehicle-badge-on-metal.jpeg",
        brandName = "Renault"
    ),
    CarBrand(
        brandLogoUrl = "https://images.pexels.com/photos/54546/pexels-photo-54546.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Chevrolet"
    )
)

val listOfCars = listOf<Car>(
    Car(
        carImage = "https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Dark Grey",
        title = "Beast"
    ), Car(
        carImage = "https://images.pexels.com/photos/2365572/pexels-photo-2365572.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Yellow",
        title = "Furious"
    ), Car(
        carImage = "https://images.pexels.com/photos/1637857/pexels-photo-1637857.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Black",
        title = "Nice one"
    ), Car(
        carImage = "https://images.pexels.com/photos/3729464/pexels-photo-3729464.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Red",
        title = "Shiny"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/170811/pexels-photo-170811.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "BMW",
        color = "Blue",
        title = "Cutie"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/2127039/pexels-photo-2127039.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "BMW",
        color = "Light Blue",
        title = "Charm"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/93615/pexels-photo-93615.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "BMW",
        color = "Dark Grey",
        title = "Darkie"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/707046/pexels-photo-707046.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "BMW",
        color = "White",
        title = "Peace"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/892522/pexels-photo-892522.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "BMW",
        color = "Dark Blue",
        title = "Furious"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/100650/pexels-photo-100650.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "BMW",
        color = "White",
        title = "Dosthi"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/116675/pexels-photo-116675.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Range Rover",
        color = "White",
        title = "Shiny"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/225841/pexels-photo-225841.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Range Rover",
        color = "Red",
        title = "Furious"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/32244634/pexels-photo-32244634/free-photo-of-fashionable-woman-beside-luxury-suv-in-urban-setting.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Range Rover",
        color = "Grey",
        title = "Darkie"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/5704347/pexels-photo-5704347.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Range Rover",
        color = "Black",
        title = "King"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/4639907/pexels-photo-4639907.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Range Rover",
        color = "Pale Red",
        title = "Furious"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/909907/pexels-photo-909907.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Audi",
        color = "Black",
        title = "Furious Boy"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1035108/pexels-photo-1035108.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Audi",
        color = "Blue",
        title = "Peace"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1719647/pexels-photo-1719647.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Audi",
        color = "Grey",
        title = "Shiny"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1461887/pexels-photo-1461887.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Audi",
        color = "Black",
        title = "Darker"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/26713352/pexels-photo-26713352/free-photo-of-audi-s4-sports-car-on-the-road.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Audi",
        color = "Mixed",
        title = "Handsome"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/810357/pexels-photo-810357.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Blue",
        title = "Beauty"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/119435/pexels-photo-119435.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Jeep",
        color = "White",
        title = "Perfect"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1682666/pexels-photo-1682666.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Jeep",
        color = "Red",
        title = "Messy"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/761815/pexels-photo-761815.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Jeep",
        color = "Green",
        title = "Nature Boy"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/758744/pexels-photo-758744.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Jeep",
        color = "Blue",
        title = "Demo"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1429775/pexels-photo-1429775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Grey",
        title = "Cat"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1007410/pexels-photo-1007410.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Ford",
        color = "Black",
        title = "Dog"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/57409/ford-mustang-stallion-red-57409.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Ford",
        color = "Red",
        title = "Parrot"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/3354648/pexels-photo-3354648.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Ford",
        color = "White",
        title = "Test"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/112460/pexels-photo-112460.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Dark Grey",
        title = "Nothing"
    ), Car(
        carImage = "https://images.pexels.com/photos/2365572/pexels-photo-2365572.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Yellow",
        title = "Hot"
    ), Car(
        carImage = "https://images.pexels.com/photos/1637857/pexels-photo-1637857.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Black",
        title = "Iron"
    ), Car(
        carImage = "https://images.pexels.com/photos/3729464/pexels-photo-3729464.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Mercedes",
        color = "Red",
        title = "Light"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/35619/capri-ford-oldtimer-automotive.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Ford",
        color = "Yellow",
        title = "Dark"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1005633/pexels-photo-1005633.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Renault",
        color = "White",
        title = "Key"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/163597/oldtimer-automobile-renault-caravelle-163597.jpeg?auto=compress&cs=tinysrgb&w=600",
        brandName = "Renault",
        color = "Blue",
        title = "Cyan"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1257763/pexels-photo-1257763.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Renault",
        color = "Brown",
        title = "Wire"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/949796/pexels-photo-949796.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Renault",
        color = "Green",
        title = "Brave"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/575386/pexels-photo-575386.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Chevrolet",
        color = "Yellow",
        title = "Chrome"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/242125/pexels-photo-242125.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Chevrolet",
        color = "Blue",
        title = "Studio"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1136566/pexels-photo-1136566.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Chevrolet",
        color = "Pale Blue",
        title = "Space"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1280553/pexels-photo-1280553.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Chevrolet",
        color = "Red",
        title = "Fire"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/131811/pexels-photo-131811.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Volkswagen",
        color = "Red",
        title = "Acetate"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/163711/auto-vw-vw-bus-vehicle-163711.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Volkswagen",
        color = "Orange",
        title = "Cotton"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/2533092/pexels-photo-2533092.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Volkswagen",
        color = "Yellow",
        title = "Wool"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/144171/pexels-photo-144171.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Volkswagen",
        color = "Yellow",
        title = "Seda"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/1616262/pexels-photo-1616262.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Volkswagen",
        color = "Green",
        title = "Silk"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/358189/pexels-photo-358189.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Ferrari",
        color = "Red",
        title = "Rayon"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/905554/pexels-photo-905554.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Nissan",
        color = "White",
        title = "Point"
    ),
    Car(
        carImage = "https://images.pexels.com/photos/919073/pexels-photo-919073.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
        brandName = "Nissan",
        color = "Black",
        title = "Sharp"
    )
)
