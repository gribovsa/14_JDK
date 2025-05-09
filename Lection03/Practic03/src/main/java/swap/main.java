package swap;

/*todo
     1. Написать метод, который меняет два элемента массива местами (массив
        может быть любого ссылочного типа);
 */


import java.util.Arrays;

public class main {

    //from - откуда, to - куда
    private static void swap(Object[]arr, int from, int to){
        Object temp = arr[from]; //временная переменная для сохранения исходного массива

        arr[from] = arr[to];
        arr[to] = temp;
    }

    public static void main(String[] args) {
        Object[]arr = {1, 2.0f, "hello"};
        System.out.println(Arrays.toString(arr));


        swap(arr, 0,2); //меняем местами 0 и 2й
        System.out.println(Arrays.toString(arr));
    }

}
