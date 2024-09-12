package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private final StudentDao studentDao;
    private final UserInputService scannerService;

    // Constructor Injection for StudentDao
    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService scannerService) {
        this.studentDao = studentDao;
        this.scannerService = scannerService;
    }

    @Override
    public Student create() {
        Student student = new Student();
        System.out.println("Enter student id:");
        int id = scannerService.getInt();
        student.setId(id);
        System.out.println("Enter student name:");
        String name = scannerService.getString();

        student.setName(name);
        if(student.getId() == 0 && student.getName() == null) {
            throw new IllegalArgumentException("Student id cannot be 0 and name cannot be null");
        }
        Student createdStudent = studentDao.save(student);
        System.out.println("CreatedStudentId: "+ createdStudent.getId() + "CreatedStudentName: " + createdStudent.getName());
        return createdStudent;
    }

    @Override
    public Student save(Student student) {
        Student saveStudent = studentDao.save(student);
        System.out.println("SavedStudentId: "+ saveStudent.getId() + "SavedStudentName: " + saveStudent.getName());
        return saveStudent;
    }

    @Override
    public Student find(int id) {

        /*System.out.println("Enter student id:");
        int studentIdToFind = Integer.parseInt(String.valueOf(scannerService.getInt()));*/
        Student foundStudent = studentDao.find(id);
        System.out.println("FoundStudentId: "+ foundStudent.getId() + "FoundStudentName: " + foundStudent.getName());
        return foundStudent;
    }

    @Override
    public Student remove(int id) {

        Student deletedStudent = studentDao.remove(id);
        System.out.println("DeletedStudentId: "+ deletedStudent.getId() + "DeletedStudentName: " + deletedStudent.getName());
        return deletedStudent;
    }

    @Override
    public List<Student> findAll() {
        List<Student> allStudents = studentDao.findAll();
        for(Student name : allStudents) {
            System.out.println(" Students id: " + name.getId() + " student name: " + name.getName());
        }
        return allStudents;
    }

    @Override
    public Student edit(Student student) {
        Student editStudent = studentDao.edit(student);
        System.out.println("EditedStudentId: "+ editStudent.getId() + "EditedStudentName: " + editStudent.getName());
        return editStudent;
    }

}
