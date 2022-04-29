package kolekcje;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Dish {
    String nazwa;
    int cena;
    int kcal;
    DishType type;

    public String getNazwa() {
        return nazwa;
    }


}
