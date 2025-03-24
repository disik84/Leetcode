package LengthOfLongestSubstring;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
//        String s = "abcabcbabcde";
//        String s = "bcbabcde";
        String s = "pwwkew";
//        String s = "abcabcbb";
        Solution solution = new Solution();
        // Запись времени начала
        long startTime = System.currentTimeMillis();
        System.out.println(solution.lengthOfLongestSubstring(s));
        // Запись времени окончания
        long endTime = System.currentTimeMillis();
        // Вычисление времени выполнения
        long duration = endTime - startTime;
        System.out.println("Время выполнения: " + duration + " миллисекунд");
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {

//--------V6 10 ms надо попробовать чере Stream Api
        int count = 0;
        int lengthItog = 0;
        int checkSymb = -1;
        int i = 0;
        StringBuilder currentStr = new StringBuilder(s);

        while (i < currentStr.length()) {
            checkSymb = currentStr.indexOf(String.valueOf(currentStr.charAt(i)));
            if (checkSymb < i && checkSymb != -1 && i > 0) {
                if (lengthItog < count) {
                    lengthItog = count;
                }
                currentStr.delete(0, checkSymb + 1);
                i = i - (checkSymb + 1);
                count = i + 1;
            } else {
                count++;
            }
            i++;
        }
        if (lengthItog < count) {
            lengthItog = count;
        }
        return lengthItog;

//--------V5 11 ms
//        int count = 0;
//        int lengthItog = 0;
//        int checkSymb = -1;
//        StringBuffer currentStr = new StringBuffer(s);
//        StringBuffer tempStr = new StringBuffer();
//
//        for (int i = 0; i < currentStr.length(); i++) {
//            if (i > 0) {
//                checkSymb = currentStr.indexOf(String.valueOf(currentStr.charAt(i)));
//            }
//            if (checkSymb < i && checkSymb != -1) {
//                if (lengthItog < count) {
//                    lengthItog = count;
//                }
//                currentStr.delete(0, checkSymb + 1);
//                i = i - (checkSymb + 1);
//                count = i + 1;
//            } else {
//                count++;
//            }
//        }
//        if (lengthItog < count) {
//            lengthItog = count;
//        }
//        return lengthItog;

//--------V4 38 ms
//        int count = 0;
//        int lengthItog = 0;
//        int checkSymb = -1;
//        StringBuffer tempStr = new StringBuffer();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (i == 0) {
//                tempStr.append(s.charAt(i));
//                count++;
//            } else {
//                checkSymb = tempStr.indexOf(String.valueOf(s.charAt(i)));
//                if (checkSymb > -1) {
//                    if (lengthItog < count) {
//                        lengthItog = count;
//                    }
//                    s = s.substring(checkSymb + 1);
//                    tempStr.setLength(0);
//                    tempStr.append(s);
//                    tempStr.setLength(i - checkSymb);
//                    i = i - (checkSymb + 1);
//                    count = tempStr.length();
//                } else {
//                    tempStr.append(s.charAt(i));
//                    count++;
//                }
//            }
//        }
//        if (lengthItog < count) {
//            lengthItog = count;
//        }
//        return lengthItog;

//--------V3 26 ms
//        int count = 0;
//        int lengthItog = 0;
//        int checkSymb = -1;
//        StringBuffer currentStr = new StringBuffer(s);
//        StringBuffer tempStr = new StringBuffer();
//
//        for (int i = 0; i < currentStr.length(); i++) {
//            if (i == 0) {
//                tempStr.append(currentStr.charAt(i));
//                count++;
//            } else {
//                checkSymb = tempStr.indexOf(String.valueOf(currentStr.charAt(i)));
//                if (checkSymb > -1) {
//                    if (lengthItog < count) {
//                        lengthItog = count;
//                    }
//                    currentStr.delete(0, checkSymb + 1);
//                    tempStr.setLength(0);
//                    tempStr.append(currentStr);
//                    tempStr.setLength(i - checkSymb);
//                    i = i - (checkSymb + 1);
//                    count = tempStr.length();
//                } else {
//                    tempStr.append(currentStr.charAt(i));
//                    count++;
//                }
//            }
//        }
//        if (lengthItog < count) {
//            lengthItog = count;
//        }
//        return lengthItog;

//--------V2 212 ms
//    int count = 0;
//    int lengthItog = 0;
//    int checkSymb = -1;
//    StringBuffer tempStr = new StringBuffer();
//
//    for (int i = 0; i < s.length(); i++) {
//        if (i == 0) {
//            tempStr.append(s.charAt(i));
//            count++;
//        } else {
//            checkSymb = tempStr.indexOf(String.valueOf(s.charAt(i)));
//            if (checkSymb > -1) {
//                if (lengthItog < count) {
//                    lengthItog = count;
//                }
//                tempStr.setLength(0);
//                count = 0;
//                s = s.substring(checkSymb + 1);
////                    tempStr.append(s.charAt(i));
////                    count++;
//                i = -1;
//            } else {
//                tempStr.append(s.charAt(i));
//                count++;
//            }
//        }
//    }
//    if (lengthItog < count) {
//        lengthItog = count;
//    }
//    return lengthItog;

//--------V1
//        int count = 0;
//        int lengthItog = 0;
//        int checkSymb = -1;
//        StringBuffer currentStr = new StringBuffer(s);
//        StringBuffer tempStr = new StringBuffer();
//
//        for (int i = 0; i < currentStr.length(); i++) {
//            if (i == 0) {
//                tempStr.append(currentStr.charAt(i));
//                count++;
//            } else {
//                checkSymb = tempStr.indexOf(String.valueOf(currentStr.charAt(i)));
//                if (checkSymb > -1) {
//                    if (lengthItog < count) {
//                        lengthItog = count;
//                    }
//                    tempStr.setLength(0);
//                    count = 0;
//                    currentStr.delete(0, checkSymb + 1);
////                    tempStr.append(s.charAt(i));
////                    count++;
//                    i = -1;
//                } else {
//                    tempStr.append(currentStr.charAt(i));
//                    count++;
//                }
//            }
//        }
//        if (lengthItog < count) {
//            lengthItog = count;
//        }
//        return lengthItog;
    }
}