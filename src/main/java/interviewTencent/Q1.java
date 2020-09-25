package interviewTencent;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int groupNum = 0;
        int operationNum = 0;
        String operation;
        LinkedList<String> operations = new LinkedList<>();
        int point = 0;
        while(in.hasNext()){
            operations.add(in.nextLine());
        }
        for (int i = 0; i < operations.size(); i++) {
            System.out.println(operations.get(i));
        }
//        if (operations.size()>0) {
//            groupNum = Integer.valueOf(operations.get(point));
//        }
//        while (groupNum != 0) {
//            Queue<String> queue = new LinkedBlockingQueue<>();
//            operationNum = Integer.valueOf(operations.get(point));
//            point++;
//            while (operationNum != 0) {
//                operation = in.nextLine();
//                String[] strings = operation.split(" ");
//                if(strings[0].equals("PUSH")){
//                    queue.add(strings[1]);
//                }else if(strings[0].equals("TOP")){
//                    if(queue.size() != 0)
//                        System.out.println(queue.peek());
//                    else
//                        System.out.println(-1);
//                }else if(strings[0].equals("POP")){
//                    if(queue.size() != 0)
//                        queue.remove();
//                    else
//                        System.out.println(-1);
//                }else if(strings[0].equals("SIZE")){
//                    System.out.println(queue.size());
//                }else if(strings[0].equals("CLEAR")){
//                    while(queue.size()!=0)
//                        queue.remove();
//                }
//                point++;
//            }
//            while(queue.size()!=0)
//                queue.remove();
//            groupNum--;
//        }
    }
}
