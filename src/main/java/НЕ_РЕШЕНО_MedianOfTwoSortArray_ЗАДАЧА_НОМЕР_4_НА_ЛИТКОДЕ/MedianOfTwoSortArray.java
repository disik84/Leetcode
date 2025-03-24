package НЕ_РЕШЕНО_MedianOfTwoSortArray_ЗАДАЧА_НОМЕР_4_НА_ЛИТКОДЕ;

import java.util.LinkedList;
import java.util.List;

public class MedianOfTwoSortArray {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums1 = {1, 3, 5, 7, 8, 9};
//        int[] nums2 = {0, 2, 4, 6, 10, 11, 12};

        int[] nums1 = {0, 2, 4, 6};
        int[] nums2 = {1, 3, 5, 7};

        solution.findMedianSortedArrays(nums1, nums2);
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

//------V4
        List<Integer> list = new LinkedList<>();
        double mediane = 0;
        int j = 0;
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            while (j < nums1.length) {
                if (j == nums1.length) {
                    list.add(nums2[i]);
                    j++;
                    break;
                }

                if (nums2[i] <= nums1[j]) {
                    list.add(nums2[i]);
                    if (i + 1 < nums2.length && nums1[j] < nums2[i + 1]) {
                        list.add(nums1[j]);
                    } else if (i + 1 == nums2.length) {
                        list.add(nums1[j]);
                    }
                    j++;
                    break;
                } else {
                    list.add(nums1[j]);
                }
                j++;
            }
            k = i;
        }

        if (nums1.length < nums2.length) {
            for (int i = j; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        } else if (nums1.length > nums2.length) {
            for (int i = j; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }

        System.out.println(list);
        return mediane;

//------V3 57ms Сортировка методом пузырька
//        double mediane = 0;
//        Integer[] newArray = Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed()).toArray(Integer[]::new);
//        int n = newArray.length;
//        boolean swapped;
//
//        // Проходим по массиву n-1 раз
//        for (int i = 0; i < n - 1; i++) {
//            swapped = false; // Флаг для отслеживания, были ли произведены обмены
//
//            // Проходим по массиву от 0 до n-i-1
//            for (int j = 0; j < n - i - 1; j++) {
//                // Сравниваем соседние элементы
//                if (newArray[j] > newArray[j + 1]) {
//                    // Меняем их местами, если они в неправильном порядке
//                    int temp = newArray[j];
//                    newArray[j] = newArray[j + 1];
//                    newArray[j + 1] = temp;
//                    swapped = true; // Устанавливаем флаг, что обмен произошел
//                }
//            }
//
//            // Если не было обменов, массив уже отсортирован
//            if (!swapped) {
//                break;
//            }
//        }
//        if (newArray.length % 2 != 0) {
//            mediane = newArray[newArray.length / 2];
//        } else {
//            mediane = (double) (newArray[newArray.length / 2] + newArray[newArray.length / 2 - 1]) / 2;
//        }
//
//        for (int i = 0; i < newArray.length; i++) {
//            System.out.print(newArray[i] + "  ");
//        }
//
//        return mediane;

//--------V3 16 ms
//        double mediane = 0;
//        Integer[] newArray = Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed()).sorted().toArray(Integer[]::new);
//        if (newArray.length % 2 != 0) {
//            mediane = newArray[newArray.length / 2];
//        } else {
//            mediane = (double) (newArray[newArray.length / 2] + newArray[newArray.length / 2 - 1]) / 2;
//        }
//
////        for (int i = 0; i < newArray.length; i++) {
////            System.out.print(newArray[i] + "  ");
////        }
//
//        return mediane;

//--------V3 15 ms
//        double median = 0.0;
//        Integer[] integerArray1 = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
//        Integer[] integerArray2 = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
//        List<Integer> list = new LinkedList<>(Arrays.asList(integerArray1));
//        list.addAll(Arrays.asList(integerArray2));
//        list.sort(null);
//        if (list.size() % 2 != 0) {
//            median = list.get(list.size() / 2);
//        } else {
//            median = (double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
//        }
////        System.out.println(list);
////        System.out.println(median);
//        return median;

//--------V2 14 ms
//        double median = 0.0;
//        Integer[] integerArray1 = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
//        List<Integer> list = new ArrayList<>(Arrays.asList(integerArray1));
//        Integer[] integerArray2 = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
//        list.addAll(Arrays.asList(integerArray2));
//        list.sort(null);
//        if (list.size() % 2 != 0) {
//            median = list.get(list.size() / 2);
//        } else {
//            median = (double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
//        }
////        System.out.println(list);
////        System.out.println(median);
//        return median;

//--------V1 не доработанная версия
//        double median = 0.0;
//        List<Integer> list = new ArrayList<>();
//        int count = 0;
//        int j = 0;
//        if (nums1[0] < nums2[0]) {
//            while (j < nums1.length && nums1[j] < nums2[0]) {
//                list.add(nums1[j]);
//                j++;
//                count++;
//            }
//            list.addAll(Arrays.stream(nums2).boxed().toList());
//            if (count < nums1.length) {
//                for (int i = count; i < nums1.length; i++) {
//                    list.add(nums1[i]);
//                }
//            }
//        } else {
//            if (nums2[0] < nums1[0]) {
//                while (j < nums2.length && nums2[j] < nums1[0]) {
//                    list.add(nums2[j]);
//                    j++;
//                    count++;
//                }
//                list.addAll(Arrays.stream(nums1).boxed().toList());
//                if (count < nums2.length) {
//                    for (int i = count; i < nums2.length; i++) {
//                        list.add(nums2[i]);
//                    }
//                }
//            }
//        }
//        System.out.println(list);
//
//        if (list.size() % 2 == 0) {
//            median = (double) (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
//        } else {
//            median = list.get(list.size() / 2);
//        }
//
//        return median;
    }
}