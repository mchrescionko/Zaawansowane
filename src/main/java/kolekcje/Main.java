package kolekcje;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws RestaurantException {
        String rosol = "rosół";
        String pomidorowa = "pomidorowa";
        String barszcz = "barszcz";

        Dish dish = Dish.builder()
                .cena(30)
                .kcal(400).build();

        System.out.println(dish);

        Set<String> set1 = new HashSet<>();
        set1.add(rosol);
        set1.add(pomidorowa);
        set1.add(barszcz);
        set1.add(barszcz);
//        for (String s : set1) {
//            System.out.println(s);
//        }

        Restaurant restaurant = new Restaurant();

        Dish dishRosol = new Dish("rosol", 10, 10, DishType.DINNER);
        Dish zurek = new Dish("zurek", 10, 10, DishType.DINNER);
        Dish jajaecznica = new Dish("jajecznica", 10, 10, DishType.BREAKFAST);

//Optional
        restaurant.addDish(dishRosol);
        restaurant.addDish(zurek);
        restaurant.addDish(jajaecznica);

        Optional<Dish> dishOptional = restaurant.findDish2("jajecznica");
        if(dishOptional.isPresent()){
            System.out.println(dishOptional.get().kcal);
        }else{
            System.out.println("nic nie ma");
        }

        dishOptional.ifPresent(s-> System.out.println(s.kcal));
        Dish dish5 = dishOptional.orElseThrow(()->new RestaurantException());
        System.out.println(dish5);

//        System.out.println(restaurant.findDish("rosol"));

//        HashMap<String, User> map = new HashMap<>();
//        User user1 = new User("kowalski@gmail.com","kwoalski");
//        User user2 = new User("wisniewski@gmail.com","wisniewski");
//        map.put("kowalski@gmail.com", user1);
//        map.put("wisniewski@gmail.com", user2);
//
//        System.out.println(map.size());
//        System.out.println(map.get("kowalski@gmail.com"));
//        map.remove("kowalski@gmail.com");
//        System.out.println(map.get("kowalski@gmail.com"));
//        map.containsKey("kowalski@gmail.com");
//        map.containsKey("wisniewski@gmail.com");


    }




}
