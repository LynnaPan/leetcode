package io.lynna.leetcode;
import java.util.regex.*;
/**
 * Created by lynna on 2017/11/20.
 */
public class ValidNumber {

    public static boolean isNumber(String s) {
        String pattern = " *[-+]?(((\\d+)?(\\.)?\\d+)|(\\d+(\\.)?(\\d+)?))((e|E)[-+]?\\d+)? *";

        Pattern r = Pattern.compile(pattern);
        r.matcher(s).matches();
        return Pattern.matches(pattern, s);
    }

    public static void main(String args[]){
        String s0 = "+890";
        String s1 = "2353.24325   ";
        String s2 = " -3343e-23";

        System.out.println(isNumber(s0));
        System.out.println(isNumber(s1));
        System.out.println(isNumber(s2));

    }

}
