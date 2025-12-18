package examples;
//
//public class RightTrianglePerimeter {
//    public static void main(String[] args) {
//        int P = 120; // Example perimeter
//        int sumHypotenuse = 0;
//
//        for (int a = 1; a < P; a++) {
//            for (int b = a; b < P; b++) {
//                int c = P - a - b;
//                if (a * a + b * b == c * c && c > 0) {
//                	System.out.println("Triangle: " + a + "," + b + "," + c);
//                    sumHypotenuse += c;
//                }
//                
//            }
//            
//        }
//        System.out.println("Sum of Hypotenuse: " + sumHypotenuse);
//    }
//}
import java.util.*;

import java.util.Arrays;

public class BalancedArray {
    public static void main(String[] args) {
        int[] arr = {12, 9, 6, 3, 5, 15, 9, 8, 4, 1};

        // Step 1: Sort array
        Arrays.sort(arr);

        // Step 2: Arrange in balanced order
        int[] balanced = new int[arr.length];
        int left = 0, right = arr.length - 1;
        boolean toggle = true;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (toggle)
                balanced[left++] = arr[i];
            else
                balanced[right--] = arr[i];
            toggle = !toggle;
        }

        // Step 3: Print original and balanced arrays
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Balanced Array: " + Arrays.toString(balanced));
    }
}

