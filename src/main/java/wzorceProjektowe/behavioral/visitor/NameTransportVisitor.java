package wzorceProjektowe.behavioral.visitor;

public class NameTransportVisitor implements TransportVisitor{
    @Override
    public void visit(Animal animal) {
        System.out.println("typ zwierzecia to "+animal.getKind());
    }

    @Override
    public void visit(Person person) {
        System.out.println("Pan "+person.getFirstName()+" "+person.getSecondName());

    }

    @Override
    public void visit(Shipment shipment) {
        System.out.println("prefix: "+shipment.getPrefix() + " " + shipment.getSerialNumber());
    }
}
