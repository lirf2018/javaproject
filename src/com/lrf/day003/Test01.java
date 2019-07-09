package com.lrf.day003;


import com.alibaba.fastjson.JSONObject;

/**
 * 创建人: lirf
 * 创建时间:  2017-07-21 14:50
 * 功能介绍:
 */
public class Test01 {

    public static void main(String[] args) {
        mytest2();
    }

    /**
     * 冒泡排序(依次比较相邻的两个数，将小数放在前面，大数放在后面)
     */
    public static void mytest1() {
        int[] arr = {23, 12, 46, 24, 87, 65, 18, 14, 43, 434, 65, 76};
        int l = arr.length;
        System.out.println(l);
        //冒泡排序(依次比较相邻的两个数，将小数放在前面，大数放在后面)
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j + 1];//大数
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            System.out.println(JSONObject.toJSON(arr));
        }

    }

    /**
     * 选择排序(第一次从下标为0的开始下标为0的这个数与后面的n-1个进行比较；找出最小或者最大的放在下标为0的这个位置)
     */
    public static void mytest3() {
        int[] arr = {23, 12, 46, 24, 87, 65, 18, 14, 43, 434, 65, 76};
        int l = arr.length;
        System.out.println(l);
        //选择排序(第一次从下标为0的开始下标为0的这个数与后面的n-1个进行比较；找出最小或者最大的放在下标为0的这个位置)
        for (int i = 0; i < l - 1; i++) {
            int min = arr[i];//用于比较的值,位置为i
            for (int j = i + 1; j <= l - 1; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                }
            }
            int j;//最小的数据的位置
            for (j = i; j < l - 1; j++) {
                if (arr[j] == min) {
                    break;
                }
            }
            //交换位置
            int tem = arr[i];
            arr[i] = min;
            arr[j] = tem;
        }
//        System.out.println(JSONObject.toJSON(arr));
    }

    /**
     * 插入排序（原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入）
     */
    public static void mytest2() {

        int[] arr = {23, 12, 46, 24, 87, 65, 18, 14, 43, 434, 65, 76};
        int l = arr.length;
        System.out.println(l);

        //插入排序（原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入）
        //下面例子是错的,应该是从后面往前
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j <= i; j++) {//
                if (arr[i + 1] < arr[j]) {
                    int tem = arr[i + 1];
                    arr[i + 1] = arr[j];
                    arr[j] = tem;
                }
            }
            System.out.println(JSONObject.toJSON(arr));
        }
//        System.out.println(JSONObject.toJSON(arr));

    }

    /**
     * 网上冒泡排序
     */
    public static void test() {
        int arr[] = {23, 12, 46, 24, 87, 65, 18, 14, 43, 434, 65, 76};
        //int arr[]={23,12,46,24,76};
        int k = 0;
        //冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    k++;
                }
            }

            System.out.println(JSONObject.toJSON(arr));
        }
    }

    /**
     * 网上选择排序
     */
    public static void test2() {
        int arr[] = {23, 12, 46, 24, 87, 65, 18, 14, 43, 434, 65, 76};
        //int arr[]={23,12,46,24,76};
        int k = 0;
        //选择排序
        int l = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] < arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    l++;
                }
            }
        }
    }

    /**
     * 网上插入排序2
     */
    public static void test3() {
        int[] arr = {23, 12, 46, 24, 87, 65, 18, 14, 43, 434, 65, 76};
        int l = arr.length;
        int i, j, tmp;
        for (i = 1; i < l; i++) {
            tmp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
            System.out.println(JSONObject.toJSON(arr));
        }
    }
}
