import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
  
  List<String> stringList;
  
  @BeforeMethod
  public void setUp() {
    stringList = new ArrayList<String>();
  }
  
  @Test
  public void addingString() {
    boolean isAdd = stringList.add("A");
    
    assert isAdd;
  }
  
  @Test
  public void addingNull() {
    boolean isAdd = stringList.add(null);
    
    assert isAdd;
  }
  
  @Test
  public void addingEmpty() {
    boolean isAdd = stringList.add("");
    
    assert isAdd : "Not added";
  }
  
  @Test
  public void addStringAtFirstIndex() {
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
  public void addEmptyAtFirstIndex() {
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
  public void addNullAtFirstIndex() {
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
  public void add_atNegativeIndex() {
    //given
    //setUp
    
    //when
    stringList.add("A");
    stringList.add(-1, "B");
  }
  
  @Test
  public void addAllOnFilledList() {
    //given
    stringList.add("1");
    stringList.add("2");
    stringList.add("3");
    
    List<String> secondStringList = new ArrayList<String>();
    
    //when
    boolean isListAdded = secondStringList.addAll(stringList);
    int secondListSize = secondStringList.size();
    
    //then
    assert isListAdded : "List was not added successfully";
    int expectedSize = 3;
    assert secondListSize == expectedSize : "List size is other than: " + expectedSize;
  }
  
  @Test
  public void addAll_onEmptyList() {
    //given
    List<String> secondStringList = new ArrayList<String>();
    
    //when
    boolean isListAdded = secondStringList.addAll(stringList);
    int secondListSize = secondStringList.size();
    
    //then
    assert !isListAdded : "List WAS added successfully";
    
    int expectedSize = 0;
    assert secondListSize == expectedSize : "List size is other than: " + expectedSize;
  }
  
  @Test
  public void addAll_listWithNullObject() {
    //given
    stringList.add(null);
    List<String> secondStringList = new ArrayList<String>();
    
    //when
    boolean isListAdded = secondStringList.addAll(stringList);
    int secondListSize = secondStringList.size();
    
    //then
    assert isListAdded : "List was NOT added successfully";
    
    int expectedSize = 1;
    assert secondListSize == expectedSize : "List size is other than: " + expectedSize;
  }
  
  @Test
  public void addAllWithIndex_onFilledList() {
    //given
    stringList.add("1");
    stringList.add("2");
    stringList.add("3");
    
    List<String> secondStringList = new ArrayList<String>();
    secondStringList.add("Nothing");
    
    //when
    boolean isListAdded = secondStringList.addAll(1, stringList);
    
    //then
    assert isListAdded : "List was NOT added successfully";
    
    int secondListSize = secondStringList.size();
    int expectedListSize = 4;
    assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
  }
  
  @Test
  public void addAllWithIndex_onEmptyList() {
    //given
    List<String> secondStringList = new ArrayList<String>();
    secondStringList.add("Nothing");
    
    //when
    boolean isListAdded = secondStringList.addAll(1, stringList);
    
    //then
    assert !isListAdded : "List WAS added successfully";
    
    int secondListSize = secondStringList.size();
    int expectedListSize = 1;
    assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
  }
  
  @Test
  public void addAllWithIndex_onListWithNullObject() {
    //given
    stringList.add(null);
    
    List<String> secondStringList = new ArrayList<String>();
    secondStringList.add("Nothing");
    
    //when
    boolean isListAdded = secondStringList.addAll(1, stringList);
    
    //then
    assert isListAdded : "List WAS added successfully";
    
    int secondListSize = secondStringList.size();
    int expectedListSize = 2;
    assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
  }
  
  @Test
  public void addAllWithIndex_filledListOnZeroIndex() {
    //given
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    
    List<String> secondStringList = new ArrayList<String>();
    secondStringList.add("Nothing");
    
    //when
    boolean isListAdded = secondStringList.addAll(0, stringList);
    
    //then
    assert isListAdded : "List WAS added successfully";
    
    int secondListSize = secondStringList.size();
    int expectedListSize = 4;
    assert secondListSize == expectedListSize : "Second list size was other than: " + expectedListSize;
  }
  
  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void addAllWithIndex_onNegativeIndex() {
    //given
    stringList.add(null);
    
    List<String> secondStringList = new ArrayList<String>();
    secondStringList.add("Nothing");
    
    //when
    boolean isListAdded = secondStringList.addAll(-1, stringList);
  }
  
  @Test
  public void clear_onFilledList() {
    //given
    stringList.add("A");
    stringList.add("C");
    stringList.add("B");
    
    //when
    stringList.clear();
    
    //then
    int listSize = stringList.size();
    int emptySize = 0;
    assert listSize == emptySize : "List is not empty";
    
    assert stringList.isEmpty() : "List is not empty";
  }
  
  @Test
  public void clear_onEmptyList() {
    //given
    //setUp
    
    //when
    stringList.clear();
    
    //then
    int listSize = stringList.size();
    int emptySize = 0;
    assert listSize == emptySize : "List is not empty";
    
    assert stringList.isEmpty() : "List is not empty";
  }
  
  @Test
  public void clear_onListWithNullObject() {
    //given
    stringList.add(null);
    
    //when
    stringList.clear();
    
    //then
    int listSize = stringList.size();
    int emptySize = 0;
    assert listSize == emptySize : "List is not empty";
    
    assert stringList.isEmpty() : "List is not empty";
  }
  
  @Test
  public void contains_A() {
    //given
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    
    //when
    boolean isThereA = stringList.contains("A");
    
    //then
    assert isThereA : "There is no A in this list";
  }
  
  @Test
  public void contains_emptyObject() {
    //given
    stringList.add("A");
    stringList.add("");
    stringList.add("C");
    
    //when
    boolean isThereA = stringList.contains("");
    
    //then
    assert isThereA : "There is no A in this list";
  }
  
  @Test
  public void contains_null() {
    //given
    stringList.add("A");
    stringList.add("");
    stringList.add(null);
    stringList.add("D");
    
    //when
    boolean isThereA = stringList.contains(null);
    
    //then
    assert isThereA : "There is no A in this list";
  }
  
  @Test
  public void notContains_E() {
    //given
    stringList.add("A");
    stringList.add("");
    stringList.add(null);
    stringList.add("D");
    
    //when
    boolean isThereA = stringList.contains("E");
    
    //then
    assert !isThereA : "There is E in this list";
  }
  
  @Test
  public void containsAll_filledList() {
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
    assert containsAll : "Don't contains specified list";
    
    int secondListSize = secondStringList.size();
    int expectedSize = 4;
    assert secondListSize == expectedSize : "List is other than: " + expectedSize;
  }
  
  @Test
  public void containsAll_filledListOnLinkedList() {
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
    assert containsAll : "Don't contains specified list";
    
    int secondListSize = secondStringList.size();
    int expectedSize = 4;
    assert secondListSize == expectedSize : "List is other than: " + expectedSize;
  }
  
  @Test(expectedExceptions = NullPointerException.class)
  public void containsAll_onNullList() {
    //given
    stringList = null;
    List<String> secondStringList = new LinkedList<String>();
    
    //when
    secondStringList.add("Nothing");
    stringList.containsAll(secondStringList);
    
    //then
    //exception
  }
  
  @Test
  public void get_onFilledList() {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    String stringAtFirst = stringList.get(0);
    
    //then
    
    String expectedString = "A";
    assert stringAtFirst.equals(expectedString) : "Was: " + stringAtFirst + " Should be: " + expectedString;
  }
  
  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void get_onEmptyList_zeroIndex() {
    //given
    //setUp
    
    //when
    stringList.get(0);
    
    //then
    //exception
  }
  
  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void get_OnFilledList_upperOutBounds() {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    stringList.get(2);
    
    //then
    //exception
  }
  
  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void get_OnFilledList_negativeIndex() {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    stringList.get(-1);
    
    //then
    //exception
  }
  
  @Test
  public void indexOf_OnFilledList_existingValue() {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    int indexOfA = stringList.indexOf("B");
    
    // then
    int expectedIndex = 1;
    assert indexOfA == expectedIndex : "Was : " + expectedIndex + " Expected: " + indexOfA;
  }
  
  @Test()
  public void indexOf_OnEmptyList() {
    //given
    //setUp
    
    //when
    int indexOfA = stringList.indexOf("B");
    
    // then
    int expectedIndex = -1;
    assert indexOfA == expectedIndex : "Was : " + expectedIndex + " Expected: " + indexOfA;
  }
  
  @Test()
  public void indexOf_OnFilledList_notExistingValue() {
    //given
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    
    //when
    int indexOfA = stringList.indexOf("D");
    
    // then
    int expectedIndex = -1;
    assert indexOfA == expectedIndex : "Was : " + expectedIndex + " Expected: " + indexOfA;
  }
  
  @Test
  public void isEmpty_onFilledList() {
    //given
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    
    //when
    boolean isEmpty = stringList.isEmpty();
    
    //then
    boolean notEmpty = false;
    assert isEmpty == notEmpty : "List is empty, when should be filled";
  }
  
  @Test
  public void isEmpty_onEmptyList() {
    //given
    //setUp
    
    //when
    boolean isEmpty = stringList.isEmpty();
    
    //then
    boolean empty = true;
    assert isEmpty == empty : "List is filled, when should be empty";
  }
  
  @Test(expectedExceptions = NullPointerException.class)
  public void isEmpty_onNullList() {
    //given
    stringList = null;
    
    //when
    stringList.isEmpty();
    
    //then
    //exception
  }
  
  @Test
  public void iterator_OnFilledList() {
    //given
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    
    //when
    Iterator<String> listIterator= stringList.iterator();
  
    //then
    assert  : "";
  
  }
  
}