
import java.util.Arrays;

public class CompareArrays {

    private static Object[]arr1;
    private static Object[]arr2;
    private static Object[]arr3;

   private static  <T> boolean compareArrays(T[]arr1, T[]arr2){
       return Arrays.equals(arr1, arr2);
   }

    public static void main(String[] args) {
       arr1 = new Object[]{1, 3, 4, 5, "One", "Two", "Three", 1.0f, 2.0f, 3.0f, 'a', 'b', 'c'};
       arr2 = new Object[]{1, 3, 4, 5, "One", "Two", "Three", 1.0f, 2.0f, 3.0f, 'a', 'b', 'c'};
       arr3 = new Object[]{1, 3, 4, 5, "One", "Two", "Three", 1.0f, 2.0f, 3.0f, 'a', 'b', 'c','d'};

        System.out.printf("Сравним arr1 и arr2, результат: %s \n", compareArrays(arr1, arr2));
        System.out.printf("Сравним arr1 и arr3, результат: %s \n", compareArrays(arr1, arr3));

    }
}
