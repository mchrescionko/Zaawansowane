package Streams.src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Customer> customers;

    public Shop(List<Customer> customers) {
        this.customers = customers;
    }

//zwróć imiona customerów posortowane alfabetycznie

    public List<String> imionaCustomerow() {
        return customers.stream()
                .map(customer -> customer.getName() + " ")
                .sorted()
                .collect(Collectors.toList());
    }

    //zwróć średni wiek customerów
    public double sredniWiek() {
        return customers.stream()
                .mapToDouble(customers -> customers.getAge())
                .sum() / customers.size();
    }


    //zwróć customerów którzy mają jakieś zamówienia
    public List<Customer> zamowienia() {
        return customers.stream()
                .filter(customer -> customer.getOrders().size() != 0)
                .collect(Collectors.toList());
    }
//zwróć tylko pełnoletnich customerów posortowanych po ich wieku

    public List<Customer> pelnoletni() {
        return customers.stream()
                .filter(customer -> customer.getAge() >= 18)
                .sorted(new Comparator<Customer>() {
                    @Override
                    public int compare(Customer o1, Customer o2) {
                        return o1.getAge() - o2.getAge();
                    }
                })
                .collect(Collectors.toList());
    }
//zwróć zamówienia nie starsze niż tydzień

    public List<Order> zamowieniaTygodniowe() {
        return customers.stream()
                .map(customer -> customer.getOrders())
                .flatMap(List::stream)
                .filter(s -> s.getOrderTime().isAfter(LocalDateTime.now().minusDays(7)))
                .collect(Collectors.toList());
    }


//zwróć średnią ilość produktów w zamówieniach

    public double sredniaIloscPRoduktow() {
        return customers.stream()
                .mapToDouble(customer -> customer.getOrders().size())
                .average()
                .orElse(0);
    }
//zwróć średnią cenę produktów ze wszystkich zamówień

    public double sredniaCenaProduktow() {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(s -> s.getProducts().stream())
                .mapToDouble(r -> r.getPrice() / r.getAmount())
                .average()
                .orElse(0);


//                .sum()/customers.stream()
//                .map(customer -> customer.getOrders())
//                .flatMap(List::strea
//                .map(s->s.getProducts())
//                .flatMap(List::stream).collect(Collectors.toList()).size();
    }

//zwróć customera, który złożył wydał najwięcej
//    public Customer wydalNajwiecej(){
//        return customers.stream()
//                .filter(customer -> customer.getOrders().stream().
//                        map(order -> order.getProducts().stream().map()))
//    }
//zwróć produkt którego mamy najmniej (wg. amound)
//zwróć wszystkie produkty zamówione później niż tydzień temu

//trudne:
//zwróć mapę której kluczem będzie numer miesiąca a wartością ilość customerów urodzonych w danym miesiącu
//zwróć mapę zawierającą kraj oraz ilość produktów pochodzących z tego kraju
}
