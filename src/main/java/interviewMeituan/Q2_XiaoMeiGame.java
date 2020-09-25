package interviewMeituan;

import sun.jvm.hotspot.debugger.Page;

import java.util.Scanner;

/*
* 小美和小团合作开发了一款新游戏！他们相信这款游戏一定可以大火。
* 游戏规则是这样的，现在有一个方格地图，你控制一个机器人位于初始位置(x, y)，然后你可以向上下左右的地块移动。
* 其中一些地块上会有得分点，经过这些点可以获得分数。当然，路上还会有一些陷阱点，如果想要通过陷阱点，就需要付出一定的分数来清除这个陷阱点。
* 注意陷阱点付出分数清除后就会变成普通的地块。即反复经过陷阱点只需付出一次代价。同样的，得分点也只能获得一次分数。
* 小美想到了一个策划案来让这个游戏变得难一些。小美把地图和机器人的初始位置给了小团，并且告诉了小团他操控机器人的行进路线。小美想试试小团能不能算出来他的最终得分。
* 小团完美地完成了这个任务。现在，小美和小团想找一些测试人员看看这款游戏的难度如何。他们找到了你，希望你帮他们测试一下这个游戏。而你能否挑战成功呢？
* 注意分数允许为负。初始分数为0
*
* 输入描述
* 第一行四个数字N，M，P，Q，表示这张地图是N行M列的，得分点的得分是P，陷阱点清除的代价是Q。
* 接下来N行，每行M个字符，表示这张地图。其中，字符S表示初始机器人位置。字符#表示墙壁，字符O代表得分点。字符X代表陷阱点。字符+代表普通的地块。
* 接下来一行一个连续的字符串表示机器人的移动路线，只由大写字母WASD构成，W向上，A向左，S向下，D向右。机器人可以上下左右移动。
* 不能超出地图边界。也不能走到墙壁之上。试图走出边界和走到墙壁的行动会停留在原来的位置不动。
*
* 输出描述
* 一个整数，表示小团的机器人最终获得了多少分
*
* 样例输入
* 6 6 20 10
* S#++O#
* OXX#X#
* ++++++
* ###XX#
* ++#O#+
* OXO++X
* SSDDDDDAWWSSSAWSSSADDD
* 样例输出
* 40

提示
其中地图大小对全体数据都有 1<=N,M<=500
对于得分点分数和陷阱点分数P和Q对全体数据都有 1<=P,Q<=1000
接下来是机器人行进路线，有行进路线长度小于等于100000*/
public class Q2_XiaoMeiGame {

    char maps[][];
    char actions[];
    int curRow, curCol;
    int n, m, reward, punish;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        reward = scanner.nextInt();
        punish = scanner.nextInt();
        maps = new char[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String temp = scanner.nextLine();
//            System.out.println(temp);
            maps[i] = temp.toCharArray();
        }
        actions = scanner.nextLine().toCharArray();
    }

    // justify the wall and border
    public boolean constraint(char action) {
        if (action == 'W') {
            if (curRow == 0) {
                return false;
            } else {
                if (maps[curRow-1][curCol] == '#') {
                    return false;
                }
                curRow--;
            }
        } else if (action == 'A') {
            if (curCol == 0) {
                return false;
            } else {
                if (maps[curRow][curCol-1] == '#') {
                    return false;
                }
                curCol--;
            }
        } else if (action == 'S') {
            if (curRow == n-1) {
                return false;
            } else {
                if (maps[curRow+1][curCol] == '#') {
                    return false;
                }
                curRow++;
            }
        } else if (action == 'D') {
            if (curCol == m-1) {
                return false;
            } else {
                if (maps[curRow][curCol+1] == '#') {
                    return false;
                }
                curCol++;
            }
        }
        return true;
    }

    public int result(int curRow, int curCol) {
        if (maps[curRow][curCol] == 'O') {
            return reward;
        } else if (maps[curRow][curCol] == 'X') {
            maps[curRow][curCol] = '+';
            return -punish;
        } else {
            return 0;
        }
    }

    public void grade() {

        int score = 0;

        // find the start place
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j] == 'S') {
                    curRow = i;
                    curCol = j;
                }
            }
        }

        // action
        for (int i = 0; i < actions.length; i++) {
            char action = actions[i];
//            System.out.println("curRow: "+curRow + ", curCol: "+ curCol);
            if (constraint(action)) {
                score += result(curRow, curCol);
            } else {
                continue;
            }
        }
        System.out.println(score);

    }

    public static void main(String[] args) {
        Q2_XiaoMeiGame q2_xiaoMeiGame = new Q2_XiaoMeiGame();
        q2_xiaoMeiGame.input();
        q2_xiaoMeiGame.grade();

    }
}
