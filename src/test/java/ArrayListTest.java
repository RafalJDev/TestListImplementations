import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {

    List<String> stringList;

    @BeforeMethod
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

        //then
        int expectedListSize = 2;
        assert listSize == expectedListSize : "List has size other than: " + expectedListSize;
    }

    @Test
    public void testAddEmptyAtFirstIndex() {
        //given
        //setUp

        //when
        stringList.add("A");
        stringList.add(1, "");
        int listSize = stringList.size();

        //then
        int expectedListSize = 2;
        assert listSize == expectedListSize : "List has size other than: " + expectedListSize;
    }

    @Test
    public void testAddNullAtFirstIndex() {
        //given
        //setUp

        //when
        stringList.add("A");
        stringList.add(1, null);
        int listSize = stringList.size();

        //then
        int expectedListSize = 2;
        assert listSize == expectedListSize : "List has size other than: " + expectedListSize;
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void test_Add_AtNegativeIndex() {
        //given
        //setUp

        //when
        stringList.add("A");
        stringList.add(-1, "B");
    }

    @Test
    public void testAddAllOnFilledList() {
        //given
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        List<String> secondStringList = new ArrayList<String>();

        //when
        boolean isListAdded = secondStringList.addAll(stringList);
        int secondListSize = secondStringList.size();

        //then
        assert  isListAdded: "List was not added successfully";
        int expectedSize = 3;
        assert secondListSize == expectedSize : "List size is other than: " + expectedSize;
    }

    @Test
    public void test_AddAll_OnEmptyList() {
        //given
        List<String> secondStringList = new ArrayList<String>();

        //when
        boolean isListAdded = secondStringList.addAll(stringList);
        int secondListSize = secondStringList.size();

        //then
        assert !isListAdded: "List WAS added successfully";

        int expectedSize = 0;
        assert secondListSize == expectedSize : "List size is other than: " + expectedSize;
    }

    @Test
    public void test_AddAll_ListWithNullObject() {
        //given
        stringList.add(null);
        List<String> secondStringList = new ArrayList<String>();

        //when
        boolean isListAdded = secondStringList.addAll(stringList);
        int secondListSize = secondStringList.size();

        //then
        assert isListAdded: "List was NOT added successfully";

        int expectedSize = 1;
        assert secondListSize == expectedSize : "List size is other than: " + expectedSize;
    }

    @Test
    public void test_AddAllWithIndex_OnFilledList() {
        //given
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        List<String> secondStringList = new ArrayList<String>();
        secondStringList.add("Nothing");

        //when
        boolean isListAdded = secondStringList.addAll(1, stringList);

        //then
        assert isListAdded: "List was NOT added successfully";

        int secondListSize = secondStringList.size();
        int expectedListSize = 4;
        assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
    }

    @Test
    public void test_AddAllWithIndex_OnEmptyList() {
        //given
        List<String> secondStringList = new ArrayList<String>();
        secondStringList.add("Nothing");

        //when
        boolean isListAdded = secondStringList.addAll(1, stringList);

        //then
        assert !isListAdded: "List WAS added successfully";

        int secondListSize = secondStringList.size();
        int expectedListSize = 1;
        assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
    }

    @Test
    public void test_AddAllWithIndex_OnListWithNullObject() {
        //given
        stringList.add(null);

        List<String> secondStringList = new ArrayList<String>();
        secondStringList.add("Nothing");

        //when
        boolean isListAdded = secondStringList.addAll(1, stringList);

        //then
        assert isListAdded: "List WAS added successfully";

        int secondListSize = secondStringList.size();
        int expectedListSize = 2;
        assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
    }

    @Test
    public void test_AddAllWithIndex_FilledListOnZeroIndex() {
        //given
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        List<String> secondStringList = new ArrayList<String>();
        secondStringList.add("Nothing");

        //when
        boolean isListAdded = secondStringList.addAll(0, stringList);

        //then
        assert isListAdded: "List WAS added successfully";

        int secondListSize = secondStringList.size();
        int expectedListSize = 4;
        assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void test_AddAllWithIndex_OnNegativeIndex() {
        //given
        stringList.add(null);

        List<String> secondStringList = new ArrayList<String>();
        secondStringList.add("Nothing");

        //when
        boolean isListAdded = secondStringList.addAll(-1, stringList);
    }

    @Test
    public void test_Clear_OnFilledList() {
        //given
        stringList.add("A");
        stringList.add("C");
        stringList.add("B");

        //when
        stringList.clear();

        //then
        int listSize = stringList.size();
        int emptySize = 0;
        assert  listSize == emptySize: "List is not empty";

        assert stringList.isEmpty() : "List is not empty";
    }

    @Test
    public void test_Clear_OnEmptyList() {
        //given
        //setUp

        //when
        stringList.clear();

        //then
        int listSize = stringList.size();
        int emptySize = 0;
        assert  listSize == emptySize: "List is not empty";

        assert stringList.isEmpty() : "List is not empty";
    }

    @Test
    public void test_Clear_OnListWithNullObject() {
        //given
        stringList.add(null);

        //when
        stringList.clear();

        //then
        int listSize = stringList.size();
        int emptySize = 0;
        assert  listSize == emptySize: "List is not empty";

        assert stringList.isEmpty() : "List is not empty";
    }

    @Test
    public void test_Contains_A() {
        //given
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        //when
        boolean isThereA = stringList.contains("A");

        //then
        assert  isThereA : "There is no A in this list";
    }

    @Test
    public void test_Contains_EmptyObject() {
        //given
        stringList.add("A");
        stringList.add("");
        stringList.add("C");

        //when
        boolean isThereA = stringList.contains("");

        //then
        assert  isThereA : "There is no A in this list";
    }

    @Test
    public void test_Contains_Null() {
        //given
        stringList.add("A");
        stringList.add("");
        stringList.add(null);
        stringList.add("D");

        //when
        boolean isThereA = stringList.contains(null);

        //then
        assert  isThereA : "There is no A in this list";
    }

    @Test
    public void test_NotContains_E() {
        //given
        stringList.add("A");
        stringList.add("");
        stringList.add(null);
        stringList.add("D");

        //when
        boolean isThereA = stringList.contains("E");

        //then
        assert  !isThereA : "There is E in this list";
    }

    @Test
    public void test_ContainsAll_FilledList() {
        //given
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        List<String> secondStringList = new ArrayList<String>();
        secondStringList.add("Nothing");
        secondStringList.addAll(stringList);

        //when
        boolean containsAll = secondStringList.containsAll(stringList);

        //then
        assert  containsAll: "Don't contains specified list";
    }

    @Test
    public void test_ContainsAll_FilledListOnLinkedList() {
        //given
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        List<String> secondStringList = new LinkedList<String>();
        secondStringList.add("Nothing");
        secondStringList.addAll(stringList);

        //when
        boolean containsAll = secondStringList.containsAll(stringList);

        //then
        assert  containsAll: "Don't contains specified list";
    }
}