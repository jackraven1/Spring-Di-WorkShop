package se.lexicon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.util.UserInputService;
import se.lexicon.models.Student;

import java.util.List;
@Component
public class StudentManagementConsoleImpl implements StudentMangement {
    private final UserInputService scannerService;
    private final StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        int id = scannerService.getInt();
        String name = scannerService.getString();
        return new Student(id, name);
    }

    @Override
    public Student save(Student student) {
       return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        studentDao.delete(id);
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
       int studentId = student.getId();
       String studentName = scannerService.getString();
       studentDao.delete(studentId);
       return studentDao.save(new Student(studentId, studentName));
    }
}
