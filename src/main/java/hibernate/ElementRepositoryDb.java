package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ElementRepositoryDb<T> implements ElementRepository<T> {
    private SessionFactory sessionFactory = ConnectionDbProvider.getSessionFactory();

    //skoro parametryzujemy klase to po co parametryzowac pozniej kazda metode?

    @Override
    public void saveOrUPdateElement(T element) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(element);
        transaction.commit();
        session.close();

    }

    @Override
    public Optional<T> getEle(int id, Class<T> classZ) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T element = session.get(classZ, id);
        transaction.commit();
        session.close();
        return Optional.ofNullable(element);
    }

    @Override
    public List<T> getAllElement(Class<T> classZ) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String classMy = classZ.getName();
        List<T> catList = session.createQuery("from "+classMy).getResultList();
        transaction.commit();
        session.close();
        return catList;
    }

    @Override
    public Optional deleteElementById(int id) {
        return Optional.empty();
    }


    public List<Cat> getAllCatsByAge(int age) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String queryString = "from Cat c where c.age = :age";
        Query <Cat> query = session.createQuery(queryString);
        query.setParameter("age", age);
        List<Cat> catList = query.getResultList();
        transaction.commit();
        session.close();
        return catList;
    }


    public Optional<Cat> deleteCatById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Cat cat = session.get(Cat.class, id);
        if (cat != null) {
            session.delete(cat);
        }
        transaction.commit();
        session.close();
        return Optional.ofNullable(cat);
    }




}
