package se.lexicon.dao.Impl;

import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoListImpl implements StudentDao {
    private List<Student> students;

    public StudentDaoListImpl() {
        this.students = new ArrayList<>();
    }
    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void delete(int id) {
        if(id == 0) {
            throw new IllegalArgumentException("id cannot be 0");
        }
        students.removeIf(student -> student.getId() == id);
    }

    @Override
    public Student edit(Student student) {
        Student existingStudent = find(student.getId());
        if (existingStudent == null) {
            throw new IllegalArgumentException("Student cannot be null or enter a valid student id");
        }
        int updateStudentIndex= students.indexOf(existingStudent);
        existingStudent.setName(student.getName());
        existingStudent.setId(student.getId());
        students.set((updateStudentIndex), existingStudent);
        return existingStudent;
    }

    @Override
    public Student remove(int id) {
        Student studentToRemove = find(id);
        if (studentToRemove == null) {
            throw new IllegalArgumentException("Id cannot not be null or give valid student id");
        }
        int removedStudentIndex = students.indexOf(studentToRemove);
        Student removedStudent = students.get(removedStudentIndex);
        students.removeIf(student -> student.getId() == id);
        return removedStudent;
    }
}
