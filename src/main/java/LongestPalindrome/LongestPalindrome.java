package LongestPalindrome;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babbad";
        Solution solution = new Solution();
//        solution.longestPalindrome(s);
        System.out.println(solution.longestPalindrome(s));
    }
}

class Solution {
    public String longestPalindrome(String s) {

//------V4 108ms
        StringBuilder tempString = new StringBuilder();
        StringBuilder sb = new StringBuilder("$" + s + "#");
        StringBuilder longestPalindrome = new StringBuilder();
        String longestPalindromeString;

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                int k = 1;
                int beginPolindrom = i;
                int endPolindrom = 0;
                tempString.setLength(0);
                tempString.append(sb.substring(i, i + 2));
                while (sb.charAt(i + k) == sb.charAt(i + k + 1)) {
                    tempString.append(sb.substring(i + k, i + k + 1));
                    k++;
                }
                k = 1;
                endPolindrom = beginPolindrom + tempString.length() - 1;
                while (sb.charAt(beginPolindrom - k) == sb.charAt(endPolindrom + k)) {
                    tempString.setLength(0);
                    tempString.append(sb.substring(beginPolindrom - k, endPolindrom + k + 1));
                    k++;
                }
            } else {
                int k = 0;
                while (sb.charAt(i - k) == sb.charAt(i + k) && i - k > 0 && i + k < sb.length()) {
                    tempString.setLength(0);
                    tempString.append(sb.substring(i-k, i + k + 1));
                    k++;
                }
            }
            if (tempString.length() > longestPalindrome.length()) {
                longestPalindrome.setLength(0);
                longestPalindrome.append(tempString);
            }
        }

        longestPalindromeString = String.valueOf(longestPalindrome);
        return longestPalindromeString;

//------V3 Ploho rabotaet
//        StringBuilder tempString = new StringBuilder();
//        StringBuilder sb = new StringBuilder(s);
//        StringBuilder longestPalindrome = new StringBuilder();
//        String longestPalindromeString;
//
////        if (s.length() % 2 != 0) {
//        for (int i = 0; i <= sb.length() - 1; i++) {
//            int k = 0;
//            if (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1) && sb.substring(i, i + 1).length() > longestPalindrome.length()) {
//                while (sb.charAt(i - k) == sb.charAt(i + 1 + k)) {
//                    if (sb.substring(i - k, i + k + 1).length() > longestPalindrome.length()) {
//                        longestPalindrome.setLength(0);
//                        longestPalindrome.append(sb.substring(i - k, i + k + 1));
//                    }
//                    k++;
//                }
//                longestPalindrome.setLength(0);
//                longestPalindrome.append(sb.substring(i, i + 2));
//            } else {
//                while (i - k >= 0 && i + k <= sb.length() - 1 && sb.charAt(i - k) == sb.charAt(i + k)) {
//                    if (sb.substring(i - k, i + k + 1).length() > longestPalindrome.length()) {
//                        longestPalindrome.setLength(0);
//                        longestPalindrome.append(sb.substring(i - k, i + k + 1));
//                    }
//                    k++;
//                }
//            }
//        }
////        } else {
////            for (int i = 0; i <= sb.length() - 1; i++) {
////                int k = 0;
////                if (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1) && sb.substring(i, i + 1).length() > longestPalindrome.length()) {
////                    longestPalindrome.setLength(0);
////                    longestPalindrome.append(sb.substring(i, i + 2));
////                }
////                while (i - k >= 0 && i + k <= sb.length() - 1 && sb.charAt(i - k) == sb.charAt(i + k)) {
////                    if (sb.substring(i - k, i + k + 1).length() > longestPalindrome.length()) {
////                        longestPalindrome.setLength(0);
////                        longestPalindrome.append(sb.substring(i - k, i + k + 1));
////                    }
////                    k++;
////                }
////            }
////        }
//        longestPalindromeString = String.valueOf(longestPalindrome);
//        return longestPalindromeString;

//------V2 Algoritm Manakera, reshal chatGPT , ochen' bistro rabotaet 6ms
        // Преобразуем строку для обработки четких и нечетких палиндромов
//        StringBuilder sb = new StringBuilder();
//        sb.append("^#");
//        for (char c : s.toCharArray()) {
//            sb.append(c).append('#');
//        }
//        sb.append('$');
//
//        String T = sb.toString();
//        int n = T.length();
//        int[] P = new int[n];
//        int center = 0, right = 0;
//
//        for (int i = 1; i < n - 1; i++) {
//            if (i < right) {
//                P[i] = Math.min(right - i, P[2 * center - i]);
//            }
//
//            // Расширяем палиндром
//            while (T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1)) {
//                P[i]++;
//            }
//
//            // Обновляем центр и правую границу
//            if (i + P[i] > right) {
//                center = i;
//                right = i + P[i];
//            }
//        }
//
//        // Находим максимальную длину палиндрома
//        int maxLen = 0;
//        int centerIndex = 0;
//        for (int i = 1; i < n - 1; i++) {
//            if (P[i] > maxLen) {
//                maxLen = P[i];
//                centerIndex = i;
//            }
//        }
//
//        // Извлекаем палиндром из исходной строки
//        int start = (centerIndex - maxLen) / 2;
//        return s.substring(start, start + maxLen);


//------V1 Time Limit Exceeded
//        String longestPalindrome = "";
//        StringBuilder tempStrring = new StringBuilder("");
//        StringBuilder leftPartTS = new StringBuilder("");
//        StringBuilder rightPartTS = new StringBuilder("");
//        for (int i = 0; i < s.length(); i++) {
//            tempStrring.setLength(0);
//            for (int j = 1 + i; j <= s.length(); j++) {
//                tempStrring.append(s.substring(j - 1, j));
//                if (tempStrring.length() % 2 == 0) {
//                    leftPartTS.append(tempStrring.substring(0, tempStrring.length() / 2));
//                    rightPartTS.append(tempStrring.substring(tempStrring.length() / 2, tempStrring.length()));
//                    rightPartTS = rightPartTS.reverse();
//                } else if (tempStrring.length() != 1) {
//                    leftPartTS.append(tempStrring.substring(0, tempStrring.length() / 2 + 1));
//                    rightPartTS.append(tempStrring.substring(tempStrring.length() / 2, tempStrring.length()));
//                    rightPartTS = rightPartTS.reverse();
//                }
//                if (leftPartTS.toString().equals(rightPartTS.toString()) && tempStrring.length() > longestPalindrome.length()) {
//                    longestPalindrome = String.valueOf(tempStrring);
//                }
//                leftPartTS.setLength(0);
//                rightPartTS.setLength(0);
//            }
//        }
//        return longestPalindrome;
    }
}