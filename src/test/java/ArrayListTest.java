import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    List<String> stringList;

    @BeforeClass
    public void setUp() {
        stringList = new ArrayList<String>();
    }

    @Test
    public void testAddingString() {
        boolean isAdd = stringList.add("A");

        assert isAdd;
    }

    @Test
    public void testAddingNull() {
        boolean isAdd = stringList.add(null);

        assert isAdd;
    }

    @Test
    public void testAddingEmpty() {
        boolean isAdd = stringList.add("");

        assert isAdd : "Not added";
    }

    @Test
    public void testAddStringAtFirstIndex() {
        //given
        //setUp

        //when
        stringList.add("A");
        stringList.add(1, "AA");
        int listSize = stringList.size();

        //given
        int expectedListSize = 2;
        assert listSize == expectedListSize : "List has size other than 3";
    }

    @Test
    public void testAddEmptyAtFirstIndex() {
        //given
        //setUp

        //when
        stringList.add("A");
        stringList.add(1, "");
        int listSize = stringList.size();

        //given
        int expectedListSize = 2;
        assert listSize == expectedListSize : "List has size other than 3";
    }

    @Test
    public void testAddNullAtFirstIndex() {
        //given
        //setUp

        //when
        stringList.add("A");
        stringList.add(1, null);
        int listSize = stringList.size();

        //given
        int expectedListSize = 2;
        assert listSize == expectedListSize : "List has size other than 3";
    }

    @Test
    public void testAddAllOnFilledList() {
        //given
        //setUp

        //when

        //given
//        assert  : "";
    }
}