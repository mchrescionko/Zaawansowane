package hibernate;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cat{

    @Id
    @GeneratedValue
    private int id;
    private int age;
    private String name;
    @ManyToOne
    private Dog catEnemy;

    @Column(name = "full_name")
    private String fullName;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void drapanie(){
        System.out.println("Kot "+name+" drapie");
    }


}