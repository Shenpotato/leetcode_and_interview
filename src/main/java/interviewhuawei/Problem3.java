package interviewhuawei;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Problem3 {


    public static void main(String[] args) {

        HashMap<String, HashMap<String, Integer>> name_grades = new HashMap<String, HashMap<String, Integer>>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String name = scanner.next();
            HashMap<String, Integer> grades = new HashMap<String, Integer>();
            String grade = scanner.next();
            int chinese_grade = Integer.parseInt(grade);
            grade = scanner.next();
            int math_grade = Integer.parseInt(grade);
            grade = scanner.next();
            int english_grade = Integer.parseInt(grade);
            grades.put("chinese", chinese_grade);
            grades.put("math", math_grade);
            grades.put("english", english_grade);
            name_grades.put(name, grades);
            System.out.println(name_grades);
        }

    }
}

