package hibernate;

import java.util.List;
import java.util.Optional;

public interface ElementRepository<T> {
    abstract void saveOrUPdateElement(T element);
    abstract Optional<T> getEle (int id, Class<T> classZ);
    abstract List<T> getAllElement(Class<T> classZ);
    abstract Optional<T> deleteElementById (int id);
}

