package repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    public void save(T object);

    public void showAll();

    public Optional<T> getById(Long id);

    public void deleteById(Long id);

    public List<T> getAll();

}
