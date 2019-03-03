package punch.day2.task2;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-03 18:58
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     递归
 * 1.编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
 * 2.编程实现求阶乘 n!
 * 3.编程实现一组数据集合的全排列
 * <br>
 */
public class IRecursive {

    /**
     * 1. 递归实现求fabnacii 数列第n项数值
     * @param n
     * @return
     */
    public static int fabnaciiByRecursive(int n){
        if(n == 1 || n == 2) return 1;
        return fabnaciiByRecursive(n-1) + fabnaciiByRecursive( n-2);
    }

    /**
     * 递归实现
     * 2.阶乘 n!
     */

    public static int factorialByRecursive(int n){
        if(n == 0|| n == 1) return 1;
        return factorialByRecursive(n-1) * n;
    }

    /**
     * todo more 其他实现 [字典序法] important!!!
     *
     * 一组数据集合的全排列
     */

    public static List<List<Integer>> fullyArranged(){
        //todo
        return null;
    }



}
