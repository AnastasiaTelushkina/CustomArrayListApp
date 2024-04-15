import org.example.CustomArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
public class CustomArrayListTest {
        public static CustomArrayList<Integer> list;
        @BeforeEach
        public void arrayInit(){
            list = new CustomArrayList<>();
            list.add(1);
            list.add(4);
            list.add(3);
            list.add(28);
            list.add(2);
            list.add(55);
            list.add(10);

        }
        @Test
        public void testSizeIncrease(){
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            Assertions.assertEquals(17, list.size());
        }
        @Test
        public void testRemove(){
            Assertions.assertEquals(28, list.remove(4));
        }

        @Test
        public void testAddByIndex(){
            list.add(3, 3);
            Assertions.assertEquals(3, list.get(3));
        }

        @Test
        public void testClear(){
            list.clear();
            Assertions.assertEquals(0, list.size());
        }

        @Test
        public void testSort(){
            Comparator<Integer> comparator = Integer::compare;
            list.sort(comparator);
            Assertions.assertEquals(1,list.get(0));
            Assertions.assertEquals(2,list.get(1));
            Assertions.assertEquals(3,list.get(2));
            Assertions.assertEquals(4,list.get(3));
            Assertions.assertEquals(10,list.get(4));
            Assertions.assertEquals(28,list.get(5));
            Assertions.assertEquals(55,list.get(6));
        }

        @Test
        public void testSortString(){
            CustomArrayList<String> listString = new CustomArrayList<>();
            listString.add("1");
            listString.add("22");
            listString.add("88888888");
            listString.add("333");
            listString.add("55555");
            listString.add("7777777");
            Comparator<String> comparator = Comparator.comparingInt(String::length);
            listString.sort(comparator);
            Assertions.assertEquals("1",listString.get(0));
            Assertions.assertEquals("22",listString.get(1));
            Assertions.assertEquals("333",listString.get(2));
            Assertions.assertEquals("55555",listString.get(3));
            Assertions.assertEquals("7777777",listString.get(4));
            Assertions.assertEquals("88888888",listString.get(5));
        }

     }
