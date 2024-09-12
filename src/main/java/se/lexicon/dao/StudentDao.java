package se.lexicon.dao;

import se.lexicon.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    public abstract Student save(Student student);

    public abstract Student find(int id);

    public abstract List<Student> findAll();

    public abstract void delete(int id);

    public abstract Student edit(Student student);

    public abstract Student remove(int id);

}
