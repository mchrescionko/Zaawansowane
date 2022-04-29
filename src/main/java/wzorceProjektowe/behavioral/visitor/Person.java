package wzorceProjektowe.behavioral.visitor;

public class Person implements TransportStuff{
    private String firstName;
    private String secondName;
    private boolean isRegularCustomer;

    public Person(String firstName, String secondName, boolean isRegularCustomer) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.isRegularCustomer = isRegularCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public boolean isRegularCustomer() {
        return isRegularCustomer;
    }


    @Override
    public void accept(TransportVisitor transportVisitor) {
        transportVisitor.
                visit(this);
    }
}
