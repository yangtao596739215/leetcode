package 字符串;

/**
 *
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 *
 *
 */
public class 字符串转整数 {
    public int StrToInt(String str) {
        char[] chars = str.toCharArray();
        if(chars.length<1) return 0;
        int res = 0;
        int size=0;
        if(chars[size]=='-' || chars[size]=='+') size++;
        while (size<chars.length){
            int i = chars[size++] - '0';
            if(i<0 || i>9) return 0;
            res=res*10+i;
        }

        if(chars[0]=='-'){
            return -res;
        }else {
            return res;
        }
    }
}
