import org.example.CustomArrayList;
import org.example.CustomQuickSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomQuickSortTest {
    @Test
    void quickSortTest() {
        CustomQuickSort<Integer> qs = new CustomQuickSort<>();
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(28);
        list.add(2);
        list.add(55);
        list.add(10);

        CustomArrayList<Integer> sortList = qs.quickSort(list);
        Assertions.assertEquals(1, sortList.get(0));
        Assertions.assertEquals(2, sortList.get(1));
        Assertions.assertEquals(3, sortList.get(2));
        Assertions.assertEquals(4, sortList.get(3));
        Assertions.assertEquals(10, sortList.get(4));
        Assertions.assertEquals(28, sortList.get(5));
        Assertions.assertEquals(55, sortList.get(6));
    }
}
