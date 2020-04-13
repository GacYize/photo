package test.dome.arithmetic;

/**
 * @author ghj
 * @Description
 * @date 2020/4/2 11:04
 */
public class BubblingDome {
    public static void main(String[] args) {
        int[] arr = {5, 4654, 232, 13, 352, 123, 467, 23};
        for (int i : ascSort(arr,true)) {
            System.out.println(i);
        }
        System.out.println("====================");
        for (int i : ascSort(arr,false)) {
            System.out.println(i);
        }
    }

    public static int[] ascSort(int[] arr,Boolean b) {
        if(b){
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }else {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }
}
