package 字符串;

public class 字符串正则 {


    public static void main(String[] args) {
        字符串正则 p = new 字符串正则();
//        char[] chars = p.subChar(new char[]{'a', 'f', 'v', 'b'}, 2);
//        System.out.println(chars[0]);
        System.out.println(p.match("a".toCharArray(), "a*".toCharArray()));

    }

    public boolean match(char[] str, char[] pattern) {

        // 两者都为空，返回true
        if (str.length < 1 && pattern.length < 1) return true;
        // pattern为空，string不为空，返回false
        if (str.length > 0 && pattern.length < 1) return false;
        // str为空，pattern不为空
        if (str.length < 1) {
            return pattern[pattern.length - 1] == '*';
        }

        // pattern str 都不为空
        if (pattern.length > 1) {
            // 下一个是*的情况
            if (pattern[1] == '*') {
                if (str[0] == pattern[0] || pattern[0] == '.') {
                    return match(subChar(str, 1), pattern);
                } else {
                    // 避免 a， .* 这种情况
                    if (str.length > 1)
                        return pattern.length > 2 && match(str, subChar(pattern, 2));
                    return true;
                }
            } else {
                // 下一个不是* 的情况

                //pattern这个是. ,匹配任意字符，都往后一位
                if (pattern[0] == '.') {
                    return match(subChar(str, 1), subChar(pattern, 1));
                } else {
                    // pattern这个不是.,且下一个不是*，正常匹配， 如果匹配成功则递归向下
                    return str[0] == pattern[0] && match(subChar(str, 1), subChar(pattern, 1));
                }
            }
        } else {
            // 如果pattern完了以后string还有，也返回false
            return (pattern[0] == str[0] || pattern[0] == '.' || pattern[0] == '*') && str.length <= 1;
        }

    }

    public char[] subChar(char[] old, int start) {
        if (old.length <= start) {
            return "".toCharArray();
        }
        char[] chars = new char[old.length - start];
        for (int i = start; i < old.length; i++) {
            chars[i - start] = old[i];
        }
        return chars;
    }
}
