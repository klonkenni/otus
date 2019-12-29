package my;

import my.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import my.service.ExamImpl;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = context.getBean(Student.class);
        ExamImpl exam = context.getBean(ExamImpl.class);

        exam.takeExam(student);
    }
}
