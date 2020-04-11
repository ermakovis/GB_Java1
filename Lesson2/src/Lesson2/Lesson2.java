package Lesson2;

import java.util.Arrays;

public class Lesson2 {

    /*Возвращать arr[] как я понял не обязательно и по принципу
    атомарности функция должна возвращать void, но так удобнее печатать.
    Не знаю как правильно. И со скопами пока не знаю как это должно работать.
     */
    public static int[] revertArray (int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 1 ? 0 : 1);
        }
        return (arr);
    }


    public static int[] fillArray (int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + 3 * i;
        }
        return (arr);
    }

    public static int[] exrThree (int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        return (arr);
    }

    //Непонятно, что возвращать при длине массива 0.
    public static int getMin (int arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return (min);
    }

    public static int getMax (int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return (max);
    }

    public static int[][] markDiagonal(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - i - 1] = 1;
        }
        return (arr);
    }

    //Не нашел в доступных мне классах(?) необходимый метод.
    public static int getSum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (sum);
    }

    public static boolean checkBalance(int arr[]) {
        int left = 0;
        int right = getSum(arr);
        for (int i = 0; i < arr.length; i++) {
            left += arr[i];
            right -= arr[i];
            if (left == right) return (true);
        }
        return (false);
    }

    /* Уверен, что можно сделать в один проход, но пока не придумал как это
    сделать красиво. Возможно посмотрю на разборе домашки.
     */
    private static void rotOne(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = tmp;
        }
    }

    public static int[] rotBy (int arr[], int rot) {
        rot = rot % arr.length;
        if (rot < 0) rot = arr.length + rot;
        for (int i = 0; i < rot; i++) {
            rotOne(arr);
        }
        return (arr);
    }

    public static void main (String args[]) {
        int exr1[] = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int exr2[] = new int[8];
        int exr3[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int exr4[] = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int exr5[][] = new int [7][7];
        int exr61[] = {1, 1, 1, 2, 1};
        int exr62[] = {2, 1, 1, 2, 1};
        int exr63[] = {10, 1, 2, 3, 4};

        System.out.println(Arrays.toString(revertArray(exr1)));
        System.out.println(Arrays.toString(fillArray(exr2)));
        System.out.println(Arrays.toString(exrThree(exr3)));
        System.out.println(getMin(exr4));
        System.out.println(getMax(exr4));
        System.out.println(Arrays.deepToString(markDiagonal(exr5)));
        System.out.println(checkBalance(exr61));
        System.out.println(checkBalance(exr62));
        System.out.println(checkBalance(exr63));
        exr63 = new int[]{10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(rotBy(exr63, -1)));
        exr63 = new int[]{10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(rotBy(exr63, -6)));
        exr63 = new int[]{10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(rotBy(exr63, 4)));
        exr63 = new int[]{10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(rotBy(exr63, 9)));
        exr63 = new int[]{10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(rotBy(exr63, 4)));
        exr63 = new int[]{10, 1, 2, 3, 4};
        System.out.println(Arrays.toString(rotBy(exr63, 5)));

        return ;
    }
}
