package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AsListTest {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(1, 2, 3));

    }
}
