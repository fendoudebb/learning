package sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] chess = new int[11][11];
        chess[1][2] = 1;
        chess[2][3] = 2;
        System.out.println(chess.length);
        System.out.println(chess[0].length);

        int nonValueCount = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.printf("%d\t", chess[i][j]);
                if (chess[i][j] != 0) {
                    nonValueCount++;
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        int[][] sparseArr = new int[1 + nonValueCount][3];
        sparseArr[0][0] = chess.length;
        sparseArr[0][1] = chess[0].length;
        sparseArr[0][2] = nonValueCount;

        int row = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                int data = chess[i][j];
                if (data != 0) {
                    row++;
                    sparseArr[row][0] = i;
                    sparseArr[row][1] = j;
                    sparseArr[row][2] = data;
                }
            }
        }


        System.out.println("稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        int[][] chessRecover = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessRecover[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        System.out.println();
        System.out.println("恢复后的二维数组：");
        for (int[] rows : chessRecover) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

}
