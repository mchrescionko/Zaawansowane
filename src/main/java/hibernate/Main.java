package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Dog dog = new Dog(4, "Mika");
        ElementRepositoryDb elementRepository = new ElementRepositoryDb();
        elementRepository.saveOrUPdateElement(dog);
//
//        Cat cat = new Cat(5, "Kulka");
//        elementRepository.saveOrUPdateElement(cat);

        ElementRepositoryDb<Dog> elementRepositoryDbDog = new ElementRepositoryDb<>();
        elementRepositoryDbDog.saveOrUPdateElement(dog);
//
//        Dog dog2 = (Dog) elementRepository.getEle(16, Dog.class).orElseThrow();
//        Dog dog3 = elementRepositoryDbDog.getEle(16, Dog.class).orElseThrow();



//        Transaction transaction = session.beginTransaction();
//        Cat cat = new Cat(5,"Kulka");
//        session.save(cat);
//        transaction.commit();
//        session.close();

//        Dog dog = new Dog(5, "Czarny");
//        ElementRepository catRepository = new elementRepositoryDb();
//        catRepository.saveOrUPdateCat(dog);
//        Cat cat = new Cat(1, 10, "Django2", dog, "DjangoFullName");
//        catRepository.saveOrUPdateCat(cat);
//        System.out.println(cat);
//
//        Optional<Cat> cat1 = catRepository.getCat(2);
//        System.out.println("cat1: "+cat1);
//
//        Optional<Cat> cat2 = catRepository.getCat(266);
//        System.out.println("cat2: "+cat2);
//
//        List<Cat> catList = catRepository.getAllCats();
//        System.out.println(catList);
//
//        List<Cat> catList2 = catRepository.getAllCatsByAge(140);
//        System.out.println(catList2);
//
//        Optional<Cat> catDeleted = catRepository.deleteCatById(2);
//        System.out.println("catdeleted: "+catDeleted);
//
//        Optional<Cat> catDeleted2 = catRepository.deleteCatById(2);
//        System.out.println("catdeleted: "+catDeleted2);


    }
}
