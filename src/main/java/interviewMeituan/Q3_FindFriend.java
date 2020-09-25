package interviewMeituan;

import java.util.Scanner;

public class Q3_FindFriend {

    public void findCommon() {
        Scanner scanner = new Scanner(System.in);
        int len1 = scanner.nextInt();
        int len2 = scanner.nextInt();
        scanner.nextLine();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int index1 = 0, index2 = 0;
        int count = 0;
        while (index1 != len1 && index2 != len2) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                index1++;
            } else {
                count = count + (index1 + 1);
                index1++;
                index2++;
            }
        }
        if(index2==len2){
            System.out.println("Yes");
            System.out.println(count);
        }else{
            System.out.println("No");
        }

    }

    public static void main(String[] args) {
        Q3_FindFriend q3_findFriend = new Q3_FindFriend();
        q3_findFriend.findCommon();
    }
}
