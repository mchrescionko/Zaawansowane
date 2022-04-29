package kolekcje;

public class RestaurantException extends  Exception{
    private static final String Exception_message = "nie ma takiego dania!";

    public RestaurantException(){
        super(Exception_message);
    }
}
