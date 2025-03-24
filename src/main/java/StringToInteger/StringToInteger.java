package StringToInteger;

import java.math.BigInteger;

public class StringToInteger {
    public static void main(String[] args) {
        String str = "    -111";
        Solution solution = new Solution();
//        solution.myAtoi(str);
        System.out.println(solution.myAtoi(str));
    }
}

class Solution {
    public int myAtoi(String s) {


//--------V4 5ms
        int result = 0;
        Boolean isPlus = null;
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Проверяем не пустая ли строка
        if ((s.length() < 1)) {
            System.out.println(result);
            return 0;
        }

        // Пропускам пробелы смещением указателя в право
        if (s.charAt(0) == 32) {
            s = s.trim();
        }

        // Определяем знак и смещаем указател на один вправо
        if (count < s.length()) {
            if (s.charAt(count) == 45) {
                isPlus = false;
                count++;
            } else if (s.charAt(count) == 43) {
                isPlus = true;
                count++;
            }
        }

        // Читаем цифры в sb , если попадается не цифра
        for (int i = count; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }

        // Проверяем длинну sb, есть ли считаные цифры
        if (sb.length() == 0) {
            System.out.println(result);
            return 0;
        } else if (isPlus != null && isPlus == false) {
            try {
                result = Integer.parseInt(sb.toString()) * -1;
            } catch (NumberFormatException e) {
                System.out.println(Integer.MIN_VALUE);
                return Integer.MIN_VALUE;
            }
        } else {
            try {
                result = Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
                System.out.println(Integer.MAX_VALUE);
                return Integer.MAX_VALUE;
            }
        }

        return result;

//--------V3 по моему работает, но на литкоде по моему нету BigInteger
//        int result = 0;
//        Boolean isPlus = null;
//        StringBuilder sb = new StringBuilder();
//        int count = 0;
//
//        // Проверяем не пустая ли строка
//        if ((s.length() < 1)) {
//            System.out.println(result);
//            return 0;
//        }
//
//        // Пропускам пробелы смещением указателя в право
//        if (s.charAt(0) == 32) {
//            count++;
//            while (count < s.length() && s.charAt(count) == 32) {
//                count++;
//            }
//        }
//
//        // Определяем знак и смещаем указател на один вправо
//        if (count < s.length()) {
//            if (s.charAt(count) == 45) {
//                isPlus = false;
//                count++;
//            } else if (s.charAt(count) == 43) {
//                isPlus = true;
//                count++;
//            }
//        }
//
//        // Читаем цифры в sb , если попадается не цифра
//        for (int i = count; i < s.length(); i++) {
//            if (s.charAt(i) >= 48 && s.charAt(i) <= 57 ) {
//                sb.append(s.charAt(i));
//            } else {
//                break;
//            }
//        }
//
//        // Проверяем длинну sb, есть ли считанные цифры
//        if (sb.length() == 0) {
//            System.out.println(result);
//            return 0;
//        } else if (isPlus != null && isPlus == false) {
//
//
//            if (new BigInteger(String.valueOf(sb)).compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) > 0) {
//                return Integer.MIN_VALUE;
//            }
//
//
//        } else {
//
//            if (new BigInteger(String.valueOf(sb)).compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
//                return Integer.MAX_VALUE;
//            }
//
//        }
//
//        return Integer.parseInt(sb.toString());



//--------V2 7ms
//        int result = 0;
//        Boolean isPlus = null;
//        StringBuilder sb = new StringBuilder();
//        int count = 0;
//
//        // Проверяем не пустая ли строка
//        if ((s.length() < 1)) {
//            System.out.println(result);
//            return 0;
//        }
//
//        // Пропускам пробелы смещением указателя в право
//        if (s.charAt(0) == 32) {
//            count++;
//            while (count < s.length() && s.charAt(count) == 32) {
//                count++;
//            }
//        }
//
//        // Определяем знак и смещаем указател на один вправо
//        if (count < s.length()) {
//            if (s.charAt(count) == 45) {
//                isPlus = false;
//                count++;
//            } else if (s.charAt(count) == 43) {
//                isPlus = true;
//                count++;
//            }
//        }
//
//        // Читаем цифры в sb , если попадается не цифра
//        for (int i = count; i < s.length(); i++) {
//            if (s.charAt(i) >= 48 && s.charAt(i) <= 57 ) {
//                sb.append(s.charAt(i));
//            } else {
//                break;
//            }
//        }
//
//        // Проверяем длинну sb, есть ли считанные цифры
//        if (sb.length() == 0) {
//            System.out.println(result);
//            return 0;
//        } else if (isPlus != null && isPlus == false) {
//            try {
//                result = Integer.parseInt(sb.toString()) * -1;
//            } catch (NumberFormatException e) {
//                System.out.println(Integer.MIN_VALUE);
//                return Integer.MIN_VALUE;
//            }
//        } else {
//            try {
//                result = Integer.parseInt(sb.toString());
//            } catch (NumberFormatException e) {
//                System.out.println(Integer.MAX_VALUE);
//                return Integer.MAX_VALUE;
//            }
//        }
//
//        System.out.println(result);
//        return result;

//--------V1 не до конца работает
//        StringBuilder sb = new StringBuilder();
//        int result = 0;
//        boolean isDigital = true;
//        boolean plus = true;
//        boolean firstMinus = false;
//        boolean firstPlus = false;
//        if (s.length() == 0) {
//            return 0;
//        }
//        if (s.length() > 1 && s.charAt(1) >= 48 && s.charAt(1) <= 57) {
//            if (s.charAt(0) == 45) {
//                plus = false;
//                firstMinus = true;
//            } else if (s.charAt(0) == 43) {
//                firstPlus = true;
//            }
//        }
//        for(int i = 0; i < s.length(); i++) {
//            int j = i;
//            while (i < s.length() && s.charAt(i) == 32 && sb.length() < 1) {
//                if (s.charAt(i + 1) == 45 && s.charAt(i + 2) >= 48 && s.charAt(i + 2) <= 57) {
//                    plus = false;
//                    i++;
//                }
//                i++;
//            }
//            if (firstMinus == true) {
//                i++;
//                firstMinus = false;
//            } else if (firstPlus == true) {
//                i++;
//                firstPlus = true;
//            }
//            if (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
//                sb.append(s.charAt(i));
//            } else {
//                break;
//            }
//        }
//        if (sb.length() == 0) {
//            System.out.println(result);
//            return result;
//        }
//        try {
//            result = Integer.parseInt(String.valueOf(sb));
//        } catch (NumberFormatException e) {
//            if (plus == true) {
//                return Integer.MAX_VALUE;
//            } else {
//                return Integer.MIN_VALUE;
//            }
//        }
//
//        if (plus == false) {
//            result *= -1;
//        }
//        return result;
    }
}