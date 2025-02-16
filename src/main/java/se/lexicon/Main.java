package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.services.StudentMangement;
import se.lexicon.util.UserInputService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao student = context.getBean(StudentDao.class);
        UserInputService userInputService =context.getBean(UserInputService.class);
        StudentMangement studentManagement = context.getBean(StudentMangement.class);


        var jack =studentManagement.create();
        studentManagement.save(jack);
        System.out.println(studentManagement.findAll());




    }
}