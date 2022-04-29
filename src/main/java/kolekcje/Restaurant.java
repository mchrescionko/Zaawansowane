package kolekcje;

import java.util.HashSet;
import java.util.Optional;

public class Restaurant {

    HashSet<Dish> dishList = new HashSet<>();

    public void addDish(Dish dish){
        dishList.add(dish);
    }
    public void removeDish(Dish dish){
        dishList.remove(dish);
    }
    public Dish findDish(String name) throws RestaurantException {
        for (Dish dish : dishList) {
            if(dish.getNazwa().equals(name)){
                return dish;
            }
        } throw new RestaurantException();
    }

    public Optional<Dish> findDish2(String name) throws RestaurantException {
        for (Dish dish : dishList) {
            if(dish.getNazwa().equals(name)){
                return Optional.of(dish);
            }
        } return Optional.empty();
    }





}
