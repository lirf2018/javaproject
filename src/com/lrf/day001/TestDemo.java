package com.lrf.day001;

/**
 * 创建人: lirf
 * 创建时间:  2019/1/14 16:48
 * 功能介绍:java 1到100的递归算法
 * 递归其实就是 按照相同的规则，将自己剥离，并将自己的下一级按照相同规则进行操作。
 */
public class TestDemo {

    public static void main(String[] args) {
// TODO Auto-generated method stub
//        System.out.println("sum:" + dg(1, 100));
        System.out.println("sum:" + dj(100));
    }

    public static int dj(int i) {
        int sum;
        if (i == 1) {//当i=1的时候，返回1 ，不存在下一级，递归结束
            return i;
        } else {//当i!=1的时候，返回 i + <(i-1)递加和> 的和
            sum = i + dj(i - 1);
        }
        return sum;
    }

    public static int dg(int a, int b) {//输入a,b,判断a递加到b的递加和
        int n;
        if (a > b) {//如果a比b大，交换a，b的值
            b += a;
            a = b - a;
            b = b - a;
        }
        if (a == b) {//如果a和b相等，则返回该值
            return a;
        } else {
            n = a + dg(a + 1, b);//计算 a +  <（a+1）到 b 的递加和>
        }
        return n;
    }

}
