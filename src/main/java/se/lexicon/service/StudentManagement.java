package se.lexicon.service;

import se.lexicon.model.Student;

import java.util.List;

public interface StudentManagement {

    public abstract Student create();

    public abstract Student save(Student student);

    public abstract Student find(int id);

    public abstract Student remove(int id);

    public abstract List<Student> findAll();

    public abstract Student edit(Student student);
}
