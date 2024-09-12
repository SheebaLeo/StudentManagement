package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Create application context
        AnnotationConfigApplicationContext context =
       new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        // Retrieve StudentDao bean
        /*StudentDao studentDao = context.getBean(StudentDao.class);

        // Add some students
        studentDao.save(new Student(1, "Amira"));
        studentDao.save(new Student(2, "Ananya"));

        // Retrieve and print all students
        studentDao.findAll().forEach(students -> System.out.println(students.getName()));*/

        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        UserInputService userInputService =context.getBean(UserInputService.class);
        String name = userInputService.getString();
        System.out.println("Your entered name: " + name);
        int id = userInputService.getInt();
        System.out.println("Your entered id: " + id);*/

        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        System.out.println("Adding a student:");
        Student student = studentManagement.create();
        System.out.println("id: " + student.getId() + "name: " + student.getName() );

        System.out.println("Saving a student");
        Student student2 = new Student(2, "Anaya");
        studentManagement.save(student2);
        System.out.println("id: " + student.getId() + "name: " + student.getName() );

        System.out.println("Finding the student");
        studentManagement.findAll();


        System.out.println("Find student by id");
        studentManagement.find(1);

        System.out.println("Updating......");
        Student student1 = new Student(3, "sheeba");
        studentManagement.edit(student1);

        System.out.println("Finding the student");
        studentManagement.findAll();

        System.out.println("Deleting.........");
        studentManagement.remove(1);

        System.out.println("Finding the student");
        studentManagement.findAll();



        // Close the context
        context.close();
    }
}
