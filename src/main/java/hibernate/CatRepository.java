package hibernate;

import java.util.List;

public interface CatRepository extends ElementRepository<Cat>{
        abstract List<Cat> getAllElementByAge (int age);

}
