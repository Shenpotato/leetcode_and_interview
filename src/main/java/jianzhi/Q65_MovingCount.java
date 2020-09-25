package jianzhi;

/*
 * 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * */
public class Q65_MovingCount {
    boolean[][] visited;
    int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        travel(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public void travel(int threshlod, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || compute(row, col) > threshlod) return;
        if (!visited[row][col]) {
            count++;
            visited[row][col] = true;
            travel(threshlod, rows, cols, row, col + 1, visited);
            travel(threshlod, rows, cols, row + 1, col, visited);
            travel(threshlod, rows, cols, row - 1, col, visited);
            travel(threshlod, rows, cols, row, col - 1, visited);
        }
    }

    public int compute(int row, int col) {
        int sum = 0;
        while (row / 10 != 0) {
            sum += row % 10;
            row /= 10;
        }
        sum += row;
        while (col / 10 != 0) {
            sum += col % 10;
            col /= 10;
        }
        sum += col;
        return sum;
    }

}
