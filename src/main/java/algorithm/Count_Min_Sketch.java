package algorithm;

import java.util.HashMap;

public class Count_Min_Sketch {
    int [] inputArray;
    HashMap<Integer, Integer> hashMap;


    public Count_Min_Sketch(int array[]){
        if(hashMap == null){
            hashMap = new HashMap<>();
        }
        this.inputArray = array;
    }



    public static void main(String[] args) {
        int array[] = {8,6,4,1,4,2,3,7,8,8,3,1,2,3,4,2,5,1,3,6,4,8,8,5,3,2,5,1,4,8,4,2,2,6,7,8,7,1,7,4,8,2};
    }
}
