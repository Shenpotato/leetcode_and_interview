package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CountNum {
    int [] array;
    HashMap<Integer, Integer> hashMap;

    public CountNum(int array[]){
        if(hashMap == null){
            hashMap = new HashMap<>();
        }
        this.array = array;
    }

    void count(){
        for (int i = 0; i < array.length; i++) {
            if(hashMap.get(array[i]) == null){
                hashMap.put(array[i], 1);
            }else {
                int count = hashMap.get(array[i]);
                hashMap.put(array[i], ++count);
            }
        }
        System.out.println(array.length);
    }

    public void printHashMap(){
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getKey()+ ": " + entry.getValue());
        }
    }




    public static void main(String[] args) {
//        int[] array = {8,6,4,1,4,2,3,7,8,8,3,1,2,3,4,2,9,1,3,6,4,8,8,5,3,2,5,1,4,8,4,2,2,6,7,8,7,1,7,4,8,2};
        int[] array = {5,6,5,0,4,9,1,0,5,7,3,1,2,3,4,2,1,4,2,6,5,7,6,9,0,2,4,1,7,8,3,2,2,4,6,8,5,0,9,4,8,2};
        CountNum countNum = new CountNum(array);
        countNum.count();
        countNum.printHashMap();
    }
}
