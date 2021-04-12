import java.util.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> arr = new MyList<>();
        arr.add(2);
        arr.add(5);
        arr.add(5);

        arr.add(0,0);
        arr.add(2,4);
        for (int i = 0; i < arr.getSize(); i++) {
            System.out.println(arr.get(i));
        }

        System.out.println();
        System.out.println(arr.indexOf(4));



    }
}
