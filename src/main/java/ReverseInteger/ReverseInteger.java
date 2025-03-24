package ReverseInteger;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = -123;
        System.out.println(solution.reverse(x));
//        solution.reverse(x);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
class Solution {
    public int reverse(int x) {

//------V3
        int result = 0;
        try {
            if (x > 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(x));
                result = Integer.parseInt(String.valueOf(sb.reverse()));
            } else {
                x = x * -1;
                StringBuilder sb = new StringBuilder(String.valueOf(x));
                result = Integer.parseInt(String.valueOf(sb.reverse()));
                result = result * -1;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;

//------V2 2ms
//        long tempResult = 0;
//        int result = 0;
//
//        if (x > 0) {
//            StringBuilder sb = new StringBuilder(String.valueOf(x));
//            tempResult = Long.parseLong(String.valueOf(sb.reverse()));
//            if (2147483647 < tempResult) {
//                return  0;
//            }
//        } else {
//            long xLong = (long) x * -1;
//            StringBuilder sb = new StringBuilder(String.valueOf(xLong));
//            tempResult = Long.parseLong(String.valueOf(sb.reverse()));
//            tempResult = tempResult * -1;
//
//            if (-2147483648 > tempResult) {
//                return  0;
//            }
//        }
//        result = (int) tempResult;
//        return result;

//------V1 2ms
//        int result = 0;
//        try {
//            if (x > 0) {
//                StringBuilder sb = new StringBuilder(String.valueOf(x));
//                result = Integer.parseInt(String.valueOf(sb.reverse()));
//            } else {
//                x = x * -1;
//                StringBuilder sb = new StringBuilder(String.valueOf(x));
//                result = Integer.parseInt(String.valueOf(sb.reverse()));
//                result = result * -1;
//            }
//        } catch (NumberFormatException e) {
//            return 0;
//        }
//        return result;
    }
}