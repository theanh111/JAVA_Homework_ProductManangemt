package service;

import java.util.List;

public interface IManagement<T> {
    void add(T object);

    void update(Long id, T newObject);

    void delete(Long id);

    T findByID(Long id);

    List<T> findByName(String name);

    List<T> findAll();
}
