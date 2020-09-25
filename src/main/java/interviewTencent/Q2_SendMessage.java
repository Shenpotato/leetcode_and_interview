package interviewTencent;

import sun.jvm.hotspot.debugger.Page;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Q2_SendMessage {

    public void sendMessgage() {

        // get input
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> listInts = new LinkedList<>();
        for (int i = 0; i < m + 1; i++) {
            String tempString = scanner.nextLine();
            String[] strings = tempString.split(" ");
            int ints[] = new int[strings.length - 1];
            for (int j = 1; j < strings.length; j++) {
                ints[j - 1] = Integer.parseInt(strings[j]);
            }
            listInts.add(ints);
        }

//        for (int i = 0; i < listInts.size(); i++) {
//            for (int j = 0; j < listInts.get(i).length; j++) {
//                System.out.print(listInts.get(i)[j]);
//                System.out.print(" ");
//            }
//            System.out.println("");
//        };


        // solu
        Stack<Integer> knownPeople = new Stack<>();
        List<Integer> alreadyCountPeople = new LinkedList<>();
        knownPeople.push(0);
        while (!knownPeople.isEmpty()) {
//            System.out.println(knownPeople.toString());
            int number = knownPeople.pop();
            alreadyCountPeople.add(number);
//            System.out.println(alreadyCountPeople.toString());
            for (int i = 0; i < listInts.size(); i++) {
                boolean tag = false;
                for (int j = 0; j < listInts.get(i).length; j++) {
                    if (listInts.get(i)[j] == number) {
                        tag = true;
                    }
                }
                for (int j = 0; j < listInts.get(i).length; j++)
                    if (tag) {
                        if (!alreadyCountPeople.contains(listInts.get(i)[j]) && !knownPeople.contains(listInts.get(i)[j])) {
                            knownPeople.push(listInts.get(i)[j]);
                        }
                    }
            }
        }


        System.out.println(alreadyCountPeople.size());


    }

    public static void main(String[] args) {
        Q2_SendMessage q2_sendMessage = new Q2_SendMessage();
        q2_sendMessage.sendMessgage();

    }
}
