package com.first.dice.favoritedish.Utils

object Constants {
    val DishType = "Dish Type"
    val DishCatogoriy = "Dish Categoriy"
    val DishCookingTime = "Dish Cooking Time"

    public fun DishTypes():ArrayList<String>{
        val dishTypeArray = ArrayList<String>()
        dishTypeArray.add("breakfast")
        dishTypeArray.add("lunch")
        dishTypeArray.add("dinner")
        dishTypeArray.add("snack")
        dishTypeArray.add("salad")
        dishTypeArray.add("sideDish")
        dishTypeArray.add("dessert")
        dishTypeArray.add("other")

        return dishTypeArray
    }

    public fun DishCategoiry() : ArrayList<String>{

        val DishCategoriys = ArrayList<String>()
        DishCategoriys.add("Pizza")
        DishCategoriys.add("BBQ")
        DishCategoriys.add("Bakery")
        DishCategoriys.add("Burger")
        DishCategoriys.add("Cafe")
        DishCategoriys.add("Chicken")
        DishCategoriys.add("Dessert")
        DishCategoriys.add("Drinks")
        DishCategoriys.add("Hot Dogs")
        DishCategoriys.add("Juices")
        DishCategoriys.add("Sandwhich")
        DishCategoriys.add("Tea & Coffee")
        DishCategoriys.add("Wraps")
        DishCategoriys.add("Other")
        return DishCategoriys
    }

    public fun DishCookingTime():ArrayList<String>{
        val dishCookingTime = ArrayList<String>()

        dishCookingTime.add("1min")
        dishCookingTime.add("2min")
        dishCookingTime.add("5min")
        dishCookingTime.add("10min")
        dishCookingTime.add("30min")
        dishCookingTime.add("1hr")
        dishCookingTime.add("4hr")
        dishCookingTime.add("7hr")
        dishCookingTime.add("1Day")

       return dishCookingTime
    }

}