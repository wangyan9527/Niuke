package practice.list;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ListOrder {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        reOrderArray1(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 利用System.arraycopy(),或者利用队列先进先出
     *
     * @param array
     */
    public static void reOrderArray(int[] array) {
        int oddIndex = 0;
        int[] evenArray = new int[array.length];
        int evenIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArray[evenIndex++] = array[i];
            } else {
                array[oddIndex++] = array[i];
            }
        }
        System.arraycopy(evenArray, 0, array, oddIndex, evenIndex);
    }

    /**
     * 采用类似冒泡排序的算法，前一个元素是偶数，后一个元素是奇数时进行交换
     *
     * @param array
     */
    public static void reOrderArray1(int[] array) {
        for (int i = 0; i< array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                // 前一个偶数后一个奇数
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int a = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = a;
                }
            }
        }
    }

}
