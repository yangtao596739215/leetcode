package 字符串;

import java.util.Stack;

public class IP2Long {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String ipFrom = "192.168.1.1";
        long ip = ipToNumber(ipFrom);
        System.out.println(ip);
        System.out.println(numberToIp(ip));
//        String ipTo = "192.168.2.10";
//
//        String ip = "192.168.2.11";
//
//        if(ipToNumber(ip)>ipToNumber(ipFrom) &&  ipToNumber(ip)<ipToNumber(ipTo)){
//            System.out.println("ip在范围内");
//        }else{
//            System.out.println("ip不在范围内");
//        }

    }


    private static Long ipToNumber(String ip) {
        String[] split = ip.split("\\.");
        long result = 0L;
        for (int i = 0; i < 4; i++) {
            result= result <<8 | Integer.parseInt(split[i]);
        }
        return result;
    }

    private static String numberToIp(Long number) {
        StringBuilder stringBuilder = new StringBuilder();

        // 这里先解析后面的8位，如果直接加上去，则会
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < 4; i++) {
            strings.push(String.valueOf(number & 0xff));
            number = number>>8;
        }
        while (!strings.empty()){
            stringBuilder.append(strings.pop());
            stringBuilder.append(".");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);

    }

    }
