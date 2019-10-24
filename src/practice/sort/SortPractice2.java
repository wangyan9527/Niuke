package practice.sort;

import java.util.Arrays;

public class SortPractice2 {

    /**
     * 约瑟夫环问题---N个人围成一圈，从第一个人开始报数，报到m的人出圈，剩下的人继续从1开始报数，报到m的人出圈；如此往复，直到所有人出圈。（模拟此过程，输出出圈的人的序号）
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] result = method3(5, 2);
        System.out.println("result = " + Arrays.toString(result));
    }

    /**
     * 循环圈内还存在的人数，用数组下标来表示人的位置，数组的值为0和1，0表示没有出圈，1表示出圈
     *
     * 将数学题转化为程序题，不要用代码来实现数学逻辑
     *
     * @param n
     * @param m
     * @return
     */
    public static int[] method1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return new int[0];
        }
        int[] array = new int[n];
        int remainNum = n;// 剩余未出圈的人数
        int countNum = 0;// 用于计数,如果countNum = m,则淘汰该人
        int[] member = new int[n];
        int memberIndex = 0;// 人数组的下标
        int index = 0;// 用于表示人是第几个出圈的

        while (remainNum > 0) {// 直到取出所有人之后结束
            countNum += 1 - member[memberIndex];// 1表示出圈，则计数器不需要加一
            if (countNum == m) {// 此时进行出圈操作
                array[index++] = memberIndex + 1;
                countNum = 0;
                member[memberIndex] = 1;// 设置为1表示已经出圈了
                remainNum--;
            }
            memberIndex = ++memberIndex % n;
        }
        return array;
    }

    /**
     * 将已经出圈了的进行移除
     * 而此处并不是真正的物理移除(占内存)，而是逻辑上移除
     * 例：a[0]=1,a[1]=2,a[2]=3,a[3]=4 此处的value类似链表中的next，指向下一个节点的下标
     * 若此时号码3的出圈，则将a[1]=2改为a[1]=3即可跳过已经出圈了的a[2]=3
     *
     * @param n
     * @param m
     * @return
     */
    public static int[] method2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return new int[0];
        }
        int[] array = new int[n];
        // 初始化
        int[] member = new int[n];
        for (int i = 0; i < n; i++) {
            member[i] = (i + 1) % n;
        }

        int remainNum = n;// 剩余未出圈的人数
        int countNum = 0;// 用于计数,如果countNum = m,则淘汰该人
        int index = 0;// 用于表示人是第几个出圈的
        int curIndex = 0;// 当前人的下标
        int preIndex = n - 1;

        while(remainNum > 0) {
            countNum++;
            if (countNum == m) {// 出圈操作
                array[index++] = curIndex + 1;
                countNum = 0;
                remainNum--;
                member[preIndex] = member[curIndex];// 这个是重点，进行逻辑删除
            } else {// 下一个人
                preIndex = curIndex;
            }
            curIndex = member[curIndex];// 通过类似链表的方式进行循环
        }
        return array;
    }

    /**
     * 直接找出需要出队的人，而不是一个一个遍历
     *
     * @param n
     * @param m
     * @return
     */
    public static int[] method3(int n, int m) {
        if (n <= 0 || m <= 0) {
            return new int[0];
        }
        int[] array = new int[n];

        // 初始化链表
        int[] member = new int[n];
        for (int i = 0; i < n; i++) {
            member[i] = (i + 1) % n;
        }
        int remainNum = n;// 剩余未出圈的人数
        int index = 0;// 用于表示人是第几个出圈的
        int curIndex = 0;// 当前人的下标
        int preIndex = n - 1;

        while(remainNum > 0) {
            // 获得需要移动的量
            int needMoveCount = m % remainNum - 1;
            // 直接移动到需要出来的元素
            for (int i = 0; i < (needMoveCount == -1 ? remainNum - 1 : needMoveCount); i++) {
                preIndex = curIndex;
                curIndex = member[curIndex]; // 移动元素
            }
            // 取出元素
            array[index++] = curIndex + 1;
            remainNum--;
            member[preIndex] = member[curIndex];
            curIndex = member[curIndex];
        }
        return array;
    }

}
