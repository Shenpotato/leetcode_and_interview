package interviewhuawei;

import java.util.HashMap;
import java.util.Scanner;

public class Problem1 {

    public static int closespace(char[] array) {
        int closespace = 0;
        HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
        characters.put('a', 1);
        characters.put('b', 1);
        characters.put('c', 0);
        characters.put('d', 1);
        characters.put('e', 1);
        characters.put('f', 0);
        characters.put('A', 1);
        characters.put('B', 2);
        characters.put('C', 0);
        characters.put('D', 1);
        characters.put('E', 0);
        characters.put('F', 0);
        characters.put('1', 0);
        characters.put('2', 0);
        characters.put('3', 0);
        characters.put('4', 1);
        characters.put('5', 0);
        characters.put('6', 1);
        characters.put('7', 0);
        characters.put('8', 2);
        characters.put('9', 1);


        for (int i = 0; i < array.length; i++) {
            int count = 0;
            if (characters.get(array[i]) != null) {
                count = characters.get(array[i]);
                closespace += count;
            } else {
                continue;
            }
        }

        return closespace;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] array = str.toCharArray();
        int closespace = closespace(array);
        System.out.println(closespace);
    }
}



