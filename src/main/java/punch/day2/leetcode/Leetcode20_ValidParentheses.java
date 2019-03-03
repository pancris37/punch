package punch.day2.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-03 21:21
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     利用stack 的思想匹配括号
 *    return stack.empty();
 * <br>
 */
public class Leetcode20_ValidParentheses {

    private static Map<Character,Character> map = new HashMap<Character,Character>(){
        {
            put(']','[');
            put('}','{');
            put(')','(');
        }
    };
    public boolean isValid(String s) {
        if("".equals(s) || null == s) return true;
        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if(map.containsKey(c)){
                 char left = map.get(c);
                 if(stack.isEmpty()) return false;
                 if(left == stack.pop()){
                         continue;
                 }else{
                     return false;
                 }

            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
