package my.domain;

import java.util.Scanner;

public class Student {
    private String name;

    public Student(){
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
    }

    public String getName(){
        return name;
    }
}
