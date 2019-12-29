package my.service;

import my.domain.Student;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class ExamImpl implements Exam {
    private int numberOfQuestions = 0;
    private int numberOfRightAnswers = 0;
    private String examQuestionsDirectory;

    public void setExamQuestionsDirectory(String examQuestionsDirectory) {
        this.examQuestionsDirectory = examQuestionsDirectory;
    }

    public void takeExam(Student name) throws IOException {
        System.out.println("Hello, "+name.getName()+". Please answer the following questions:");

        Reader in = new FileReader(examQuestionsDirectory);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader("Question","Answer").withSkipHeaderRecord().withDelimiter(';').parse(in);

        Scanner scanner = new Scanner(System.in);

        for (CSVRecord record : records) {
            System.out.println(record.get("Question"));

            String studentAnswer = scanner.nextLine();
            numberOfQuestions++;


            if (studentAnswer.equals(record.get("Answer"))){
                System.out.println("You are right!");
                numberOfRightAnswers++;
            } else {
                System.out.println("You are wrong :(");
            }
        }
        System.out.println("You answered " + numberOfRightAnswers + " questions out of " + numberOfQuestions + ". Well done!");
    }
}
