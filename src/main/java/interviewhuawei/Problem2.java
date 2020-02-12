package interviewhuawei;

import java.util.*;


public class Problem2 {

    static class Node {
        public int i;
        public int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getx() {
            return this.i;
        }

        public int gety() {
            return this.j;
        }

        public void setx(int i) {
            this.i = i;
        }

        public void sety(int j) {
            this.j = j;
        }

        @Override
        public String toString() {
            return "i: " + i + ","+ "j: "+j;
        }
    }

    public static boolean legal(Node node, int n, int m) {
        if (node.getx() >= 0 && node.getx() < n && node.gety() >= 0 && node.gety() < m)
            return true;
        return false;
    }

    // 获取合法节点，包含不越域和数值为1
    public static Node getAdjacentnode(Node node, int n, int m, int[][] array) {
        Node rightnode = new Node(node.getx() + 1, node.gety());
        Node downnode = new Node(node.getx(), node.gety() + 1);
        Node leftnode = new Node(node.getx() + 1, node.gety());
        Node upnode = new Node(node.getx() + 1, node.gety());
        if (legal(rightnode, n, m) && array[rightnode.getx()][rightnode.gety()] == 1)
            return rightnode;
        else if (legal(downnode, n, m) && array[downnode.getx()][downnode.gety()] == 1)
            return downnode;
        else if (legal(leftnode, n, m) && array[leftnode.getx()][leftnode.gety()] == 1)
            return leftnode;
        else if (legal(upnode, n, m) && array[upnode.getx()][upnode.gety()] == 1)
            return upnode;
        return null;
    }

    public static boolean notvisited(Node node, List<Node> vistednodes) {
        Iterator<Node> iterator = vistednodes.iterator();
        while (iterator.hasNext()) {
            if (node == iterator)
                return false;
            iterator.next();
        }
        return true;
    }

    public static List<Node> mazepath(int[][] maze, Node startnode, Node endnode) {
        int n = maze.length;
        int m = maze[0].length;
        List<Node> path = new LinkedList<Node>();
        Stack<Node> nodestack = new Stack<Node>();
        Stack<Node> visitednodes = new Stack<Node>();
        // 初始节点进栈
        nodestack.push(startnode);
        // 将初始节点加入路径
        path.add(startnode);
        while (nodestack.empty() == false) {
            Node currentnode = nodestack.pop();
            System.out.println(currentnode);
            if (currentnode == endnode)
                return path;
            Node adjacentnode = getAdjacentnode(currentnode, n, m, maze);
            // 当邻接节点不为空时，
            if (adjacentnode != null && notvisited(adjacentnode, nodestack) && notvisited(adjacentnode,visitednodes)) {
                nodestack.push(adjacentnode);
                path.add(adjacentnode);
                continue;
            } else if (adjacentnode == null) {
                // 当没有合法邻接节点
                visitednodes.push(adjacentnode);
                continue;
            }


        }
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        Node startnode = new Node(0, 0);
        Node endnode = new Node(n - 1, n - 1);

        List<Node> mazepath = mazepath(array, startnode, endnode);
        System.out.println(" ");
        for (Node node : mazepath) {
            System.out.println(node);
        }

    }


}
