package wzorceProjektowe.behavioral.visitor;

public class PriceTransportVisitor implements TransportVisitor{
    @Override
    public void visit(Animal animal) {
        System.out.println(animal.getWeight()*2);
    }

    @Override
    public void visit(Person person) {
        int przelicznik = 6;
        if(person.isRegularCustomer()){
            przelicznik = 3;
        }
        System.out.println("cena " +przelicznik);
    }

    @Override
    public void visit(Shipment shipment) {
        System.out.println("cena " +5);
    }
}
