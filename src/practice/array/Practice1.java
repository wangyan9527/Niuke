package practice.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Practice1 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        ArrayList<Integer> result = printMatrix(arr);
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 将二维数组分为上、右、下、左四边分别进行计算
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int totalRowCount = matrix.length;
        int totalColCount = matrix[0].length;
        for (int count = 0, rowIndex = 0, colIndex = 0, changeCount = 1, ringCount = 0; count < totalColCount * totalRowCount; count++) {
            ringCount = changeCount / 4;// 循环了多少圈
            result.add(matrix[rowIndex][colIndex]);
            if (changeCount % 4 == 1) {// 上边
                if (colIndex < totalColCount - 1 - ringCount) {
                    colIndex++;
                } else if (colIndex == totalColCount - 1 - ringCount) {
                    rowIndex++;
                    changeCount++;
                }
            } else if (changeCount % 4 == 2) {// 右边
                if (rowIndex < totalRowCount - 1 - ringCount) {
                    rowIndex++;
                } else if (rowIndex == totalRowCount - 1 - ringCount) {
                    colIndex--;
                    changeCount++;
                }
            } else if (changeCount % 4 == 3) {// 下边
                if (colIndex > ringCount) {
                    colIndex--;
                } else if (colIndex == ringCount) {
                    rowIndex--;
                    changeCount++;
                }
            } else if (changeCount % 4 == 0) {// 左边
                if (rowIndex > ringCount) {
                    rowIndex--;
                } else if (rowIndex == ringCount) {
                    colIndex++;
                    changeCount++;
                }
            }
        }
        return result;
    }

}
