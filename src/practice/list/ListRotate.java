package practice.list;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序(后面的值>=前面的值)的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class ListRotate {

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 2, 2, 2};
        System.out.println(minNumberInRotateArray1(array));
    }

    /**
     * 采用二分法的方式进行查询
     *
     *
     * 思路：以旋转数组之前的第一个元素作为零界点，旋转之后，零界点左边的元素不会小于零界点右边的元素
     * 1.如果中间元素大于左边元素，则下次取右边的数组进行判断;
     * 2.如果中间元素小于左边元素，则取左边数组;
     * 3.如果中间元素等于左边元素，再与右边元素比较，
     * 1.如果比右边的元素小，取该值
     * 2.如果比右边元素大，取右边数组
     * 3.如果和右边元素相等，则需要对左右两个数组再进行处理
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array != null && array.length > 0) {
            int leftIndex = 0;
            int rightIndex = array.length - 1;
            while (rightIndex - leftIndex > 1) {
                int centreIndex = (rightIndex - leftIndex) / 2 + leftIndex;
                if (array[centreIndex] > array[leftIndex]) {
                    leftIndex = centreIndex;
                } else if (array[centreIndex] < array[leftIndex]) {
                    rightIndex = centreIndex;
                } else {
                    if (array[centreIndex] < array[rightIndex]) {
                        return array[centreIndex];
                    } else if (array[centreIndex] > array[rightIndex]) {
                        leftIndex = centreIndex;
                    } else {
                        return array[centreIndex];// todo 需要修改,有问题
                    }
                }
            }
            return array[rightIndex];
        }
        return 0;
    }

    /**
     * 思路:旋转之后的数组只会有一个地方是递减的，既最小元素和它前一个元素
     * 如果全局没有一个地方递减，只有可能是所有元素的值相等
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                // 证明所有元素的值相等
                if (i == array.length - 2) {
                    return array[0];
                }
            }
        }
        return 0;
    }

}
