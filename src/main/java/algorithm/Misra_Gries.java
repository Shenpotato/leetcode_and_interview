package algorithm;

import java.util.*;

public class Misra_Gries {

    private int k;
    private HashMap<Integer, Integer> numCounts;
    private HashMap<Integer, Integer> trueCounts;

    public Misra_Gries(int k) {
        this.k = k;
        this.numCounts = new HashMap<>();
        this.trueCounts = new HashMap<>();
    }

    public void streamFrequentIterm(int[] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            if (numCounts.get(numArray[i]) != null) {
                int count = numCounts.get(numArray[i]);
                numCounts.put(numArray[i], ++count);
            } else {
                if (numCounts.size() < k - 1) {
                    numCounts.put(numArray[i], 1);
                } else {
                    List<Integer> removeList = new LinkedList<>();
                    for (Map.Entry<Integer, Integer> numcount : numCounts.entrySet()) {
                        if (numcount.getValue() == 1) {
                            removeList.add(numcount.getKey());
                        } else {
                            int value = numcount.getValue();
                            numCounts.put(numcount.getKey(), --value);
                        }
                    }
                    for (int j = 0; j < removeList.size(); j++) {
                        numCounts.remove(removeList.get(j));
                    }
                }
            }
            System.out.print("step" + (i + 1) + ": ");
            printNumCounts(numCounts);
            System.out.println();
        }
    }

    public void trueFrequency(int[] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            if (trueCounts.get(numArray[i]) != null) {
                int value = trueCounts.get(numArray[i]);
                trueCounts.put(numArray[i], ++value);
            } else {
                trueCounts.put(numArray[i], 1);
            }
            System.out.print("step" + (i + 1) + ": ");
            printNumCounts(trueCounts);
            System.out.println();
        }
    }

    public void printNumCounts(HashMap<Integer, Integer> hashMap) {
        for (Map.Entry<Integer, Integer> numcount : hashMap.entrySet()) {
            System.out.print(  numcount.getValue() + ", ");
        }

    }

    public static void main(String[] args) {
        int[] numArray = {7, 3, 1, 1, 5, 2, 7, 5, 3, 5, 8, 1, 5, 4, 4, 2, 1, 6, 8, 7, 6, 8, 7, 5, 7, 2, 5, 4, 5, 8, 4, 5, 1, 1, 5, 2, 7, 1, 2, 1, 3, 4};
        Misra_Gries misra_gries = new Misra_Gries(5);
        misra_gries.trueFrequency(numArray);
    }

}