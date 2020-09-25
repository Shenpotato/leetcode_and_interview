package algorithm;

import com.sun.javafx.geom.Edge;

/**
 * @author ShenPotato
 * @descrpiton Kruskal algorithm，最小生成树算法
 * @date 2020/4/15 10:06 上午
 */

public class Kruskal {

    private static class EdgeData {
        char start;
        char end;
        int weight;
        char initiator;

        public EdgeData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.initiator = ' ';
        }

        public char getStart() {
            return start;
        }

        public void setStart(char start) {
            this.start = start;
        }

        public char getEnd() {
            return end;
        }

        public void setEnd(char end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public char getInitiator() {
            return initiator;
        }

        public void setInitiator(char initiator) {
            this.initiator = initiator;
        }
    }

    private int edgeNum;
    private char[] vertex;
    private int[][] distance;
    private static final int INF = Integer.MAX_VALUE;

    public void edgeSort(EdgeData[] edgeData) {
        edgeSort(edgeData, 0, edgeData.length - 1);
    }

    public void edgeSort(EdgeData[] edgeData, int low, int hi) {
        if (hi <= low) return;
        int mid = low + (hi - low) / 2;
        edgeSort(edgeData, low, mid);
        edgeSort(edgeData, mid + 1, hi);
        merge(edgeData, low, mid, hi);
    }

    public void merge(EdgeData[] edgeData, int low, int mid, int hi) {
        EdgeData[] temp = new EdgeData[edgeData.length];
        int i = low, j = mid + 1;
        for (int k = low; k < hi; k++) {
            temp[k] = edgeData[k];
        }
        for (int k = low; k <= hi; k++) {
            if (i > mid) edgeData[k] = temp[j++];
            else if (j > hi) edgeData[k] = temp[i++];
            else if (temp[i].weight > temp[j].weight) edgeData[k] = temp[j++];
            else edgeData[k] = temp[i++];
        }
    }

}
