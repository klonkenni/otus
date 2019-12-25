package my.service;


import my.domain.Student;

import java.io.IOException;

public interface Exam {
    void takeExam(Student name) throws IOException;
}
