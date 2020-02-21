package recursion;

/**
 * 迷宫问题
 * 回溯
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];


        int row = map.length;
        System.out.println(row);
        int column = map[0].length;
        System.out.println(column);

        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][column - 1] = 1;
        }

        for (int i = 0; i < column; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println("-----------------------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j + 1)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
