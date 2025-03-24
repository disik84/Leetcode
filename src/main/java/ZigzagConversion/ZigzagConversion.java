package ZigzagConversion;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(solution.convert(s, numRows));
//        System.out.println(solution.convert(s, numRows));
    }
}

class Solution {
    public String convert(String s, int numRows) {

//------ V1 5ms
        StringBuilder[] arr = new StringBuilder[numRows];
        int indexArr = 0;
        boolean directionUp = false;

        for (int j = 0; j < numRows; j++) {
            arr[j] = new StringBuilder("");
        }
        while (indexArr < s.length()) {
            if (!directionUp) {
                //for (int j = 0; j < numRows; j++) {
                int j = 0;
                while (j < numRows && indexArr < s.length()) {
                    arr[j] = arr[j].append(s.charAt(indexArr));

                    j++;
                    indexArr++;
                }
                directionUp = true;
            } else {
                int j = numRows;
                while (j > 0 && indexArr < s.length()) {
//                for (int j = numRows - 1 ; j > 0; j--) {
                    if (j < numRows - 1) {
                        arr[j] = arr[j].append(s.charAt(indexArr));

                        indexArr++;
                    }
                    j--;
                }
                directionUp = false;
            }
        }
        for (int j = 1; j < numRows; j++) {
          arr[0].append(arr[j]);
        }

        return String.valueOf(arr[0]);
    }
}