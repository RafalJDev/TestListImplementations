import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class ArrayListTest {
  
  @DataProvider(name = "collectionImpl")
  public Object[] collectionImpl() {
    return new Object[]{
        new ArrayList<String>(),
        new LinkedList<String>()
    };
  }
  
  @Test(dataProvider = "collectionImpl")
  public void addingString(List<String> stringList) {
    boolean isAdd = stringList.add("A");
    
    assert isAdd;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void addingNull(List<String> stringList) {
    boolean isAdd = stringList.add(null);
    
    assert isAdd;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void addingEmpty(List<String> stringList) {
    boolean isAdd = stringList.add("");
    
    assert isAdd : "Not added";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void addStringAtFirstIndex(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addEmptyAtFirstIndex(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addNullAtFirstIndex(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
  public void add_atNegativeIndex(List<String> stringList) {
    //given
    //setUp
    
    //when
    stringList.add("A");
    stringList.add(-1, "B");
  }
  
  @Test(dataProvider = "collectionImpl")
  public void addAllOnFilledList(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addAll_onEmptyList(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addAll_listWithNullObject(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addAllWithIndex_onFilledList(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addAllWithIndex_onEmptyList(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addAllWithIndex_onListWithNullObject(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void addAllWithIndex_filledListOnZeroIndex(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
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
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
  public void addAllWithIndex_onNegativeIndex(List<String> stringList) {
    //given
    stringList.add(null);
    
    List<String> secondStringList = new ArrayList<String>();
    secondStringList.add("Nothing");
    
    //when
    boolean isListAdded = secondStringList.addAll(-1, stringList);
  }
  
  @Test(dataProvider = "collectionImpl")
  public void clear_onFilledList(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void clear_onEmptyList(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void clear_onListWithNullObject(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void contains_A(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
    //when
    boolean isThereA = stringList.contains("A");
    
    //then
    assert isThereA : "There is no A in this list";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void contains_emptyObject(List<String> stringList) {
    //given
    stringList.add("A");
    stringList.add("");
    stringList.add("C");
    
    //when
    boolean isThereA = stringList.contains("");
    
    //then
    assert isThereA : "There is no A in this list";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void contains_null(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void notContains_E(List<String> stringList) {
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
  
  @Test(dataProvider = "collectionImpl")
  public void containsAll_filledList(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
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
  
  @Test(dataProvider = "collectionImpl")
  public void containsAll_filledListOnLinkedList(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
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
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = NullPointerException.class)
  public void containsAll_onNullList(List<String> stringList) {
    //given
    stringList = null;
    List<String> secondStringList = new LinkedList<String>();
    
    //when
    secondStringList.add("Nothing");
    stringList.containsAll(secondStringList);
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl")
  public void get_onFilledList(List<String> stringList) {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    String stringAtFirst = stringList.get(0);
    
    //then
    
    String expectedString = "A";
    assert stringAtFirst.equals(expectedString) : "Was: " + stringAtFirst + " Should be: " + expectedString;
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
  public void get_onEmptyList_zeroIndex(List<String> stringList) {
    //given
    //setUp
    
    //when
    stringList.get(0);
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
  public void get_OnFilledList_upperOutBounds(List<String> stringList) {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    stringList.get(2);
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
  public void get_OnFilledList_negativeIndex(List<String> stringList) {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    stringList.get(-1);
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl")
  public void indexOf_OnFilledList_existingValue(List<String> stringList) {
    //given
    stringList.add("A");
    stringList.add("B");
    
    //when
    int indexOfA = stringList.indexOf("B");
    
    // then
    int expectedIndex = 1;
    assert indexOfA == expectedIndex : "Was : " + expectedIndex + " Expected: " + indexOfA;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void indexOf_OnEmptyList(List<String> stringList) {
    //given
    //setUp
    
    //when
    int indexOfA = stringList.indexOf("B");
    
    // then
    int expectedIndex = -1;
    assert indexOfA == expectedIndex : "Was : " + expectedIndex + " Expected: " + indexOfA;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void indexOf_OnFilledList_notExistingValue(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
    //when
    int indexOfA = stringList.indexOf("D");
    
    // then
    int expectedIndex = -1;
    assert indexOfA == expectedIndex : "Was : " + expectedIndex + " Expected: " + indexOfA;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void isEmpty_onFilledList(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
    //when
    boolean isEmpty = stringList.isEmpty();
    
    //then
    boolean notEmpty = false;
    assert isEmpty == notEmpty : "List is empty, when should be filled";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void isEmpty_onEmptyList(List<String> stringList) {
    //given
    //setUp
    
    //when
    boolean isEmpty = stringList.isEmpty();
    
    //then
    boolean empty = true;
    assert isEmpty == empty : "List is filled, when should be empty";
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = NullPointerException.class)
  public void isEmpty_onNullList(List<String> stringList) {
    //given
    stringList = null;
    
    //when
    stringList.isEmpty();
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl")
  public void iterator_onFilledList_notNull(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
    //when
    Iterator<String> listIterator = stringList.iterator();
    
    //then
    assert listIterator != null : "List iterator can't be null !";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void iterator_onFilledList_hasNext(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C");
    
    //when
    Iterator<String> listIterator = stringList.iterator();
    
    //then
    assert listIterator.hasNext() == true : "There is no next object";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void iterator_onEmptyList(List<String> stringList) {
    //given
    //setUp
    
    //when
    Iterator<String> listIterator = stringList.iterator();
    
    //then
    assert listIterator != null : "List iterator can't be null !";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void lastIndexOf_onFilledList_findC(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C", "B", "C");
    
    //when
    int lastIndexOfC = stringList.lastIndexOf("C");
    
    //then
    int expectedIndex = 4;
    assert lastIndexOfC == expectedIndex : "Actual value: " + lastIndexOfC + " Should be: " + expectedIndex;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void lastIndexOf_onEmptyList(List<String> stringList) {
    //given
    //setUp
    
    //when
    int lastIndexOfC = stringList.lastIndexOf("C");
    
    //then
    int expectedIndex = -1;
    assert lastIndexOfC == expectedIndex : "Actual value: " + lastIndexOfC + " Should be: " + expectedIndex;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void lastIndexOf_onFilledList_findD(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C", "B", "C");
    
    //when
    int lastIndexOfC = stringList.lastIndexOf("D");
    
    //then
    int expectedIndex = -1;
    assert lastIndexOfC == expectedIndex : "Actual value: " + lastIndexOfC + " Should be: " + expectedIndex;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void listIterator_onFilledList_notNull(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C", "B", "C");
    
    //when
    ListIterator<String> stringListIterator = stringList.listIterator();
    
    //then
    assert stringListIterator != null : "List iterator can't be null!";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void listIterator_onEmptyList_notNull(List<String> stringList) {
    //given
    //setUp
    
    //when
    ListIterator<String> stringListIterator = stringList.listIterator();
    
    //then
    assert stringListIterator != null : "List iterator can't be null!";
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
//, expectedExceptionsMessageRegExp = ".*Index 1 .*")
  public void listIterator_atIndex_onEmptyList_throwException(List<String> stringList) {
    //given
    //setUp
    
    //when
    ListIterator<String> stringListIterator = stringList.listIterator(1);
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl")
  public void listIterator_atIndex_onFilledList_notNull(List<String> stringList) {
    //given
    stringList = Arrays.asList("A", "B", "C", "B", "C");
    
    //when
    ListIterator<String> stringListIterator = stringList.listIterator(1);
    
    //then
    assert stringListIterator != null : "List iterator can't be null!";
  }
  
  @Test(dataProvider = "collectionImpl")
  public void remove_onFilledList_(List<String> stringList) {
    //given
    createDefaultList(stringList);
    
    //when
    String removedString = stringList.remove(1);
    
    //then
    assert removedString.equals("B") : "Should be B";
    
    int expectedSize = 4;
    int actualSize = stringList.size();
    assert expectedSize == actualSize : "Actual size: " + actualSize + " Should be: " + expectedSize;
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
//, expectedExceptionsMessageRegExp = ".*Index 1 .*")
  public void remove_onEmptyList(List<String> stringList) {
    //given
    //setUp
    
    //when
    String removedString = stringList.remove(1);
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = IndexOutOfBoundsException.class)
//, expectedExceptionsMessageRegExp = ".*Index 4 .*")
  public void remove_onFilledList_indexGreaterThanSize(List<String> stringList) {
    //given
    createDefaultList(stringList);
    
    //when
    String removedString = stringList.remove(stringList.size());
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl")
  public void removeObject_onFilledListWithDuplicates(List<String> stringList) {
    //given
    createDefaultList(stringList);
    
    //when
    boolean isRemoved = stringList.remove("C");
    
    //then
    assert isRemoved : "Should be TRUE!";
    
    int actualListSize = stringList.size();
    int expectedSize = 4;
    assert actualListSize == expectedSize : "Actual size: " + actualListSize + " Expected: " + expectedSize;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void removeObject_onEmptyList(List<String> stringList) {
    //given
    //collectionImpl
    
    //when
    boolean isRemoved = stringList.remove("C");
    
    //then
    assert !isRemoved : "Should be FALSE!";
    
    int actualListSize = stringList.size();
    int expectedSize = 0;
    assert actualListSize == expectedSize : "Actual size: " + actualListSize + " Expected: " + expectedSize;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void removeObject_onFilledList_noSuchObject(List<String> stringList) {
    //given
    createDefaultList(stringList);
    
    //when
    boolean shouldNotBeRemoved = stringList.remove("D");
    
    //then
    assert !shouldNotBeRemoved : "Shouldn't be TRUE!";
    
    int actualListSize = stringList.size();
    int expectedSize = 5;
    assert actualListSize == expectedSize : "Actual size: " + actualListSize + " Expected: " + expectedSize;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void removeObject_onFilledList_null(List<String> stringList) {
    //given
    createDefaultList(stringList);
    
    //when
    boolean shouldNotBeRemoved = stringList.remove(null);
    
    //then
    assert !shouldNotBeRemoved : "Shouldn't be TRUE!";
    
    int actualListSize = stringList.size();
    int expectedSize = 5;
    assert actualListSize == expectedSize : "Actual size: " + actualListSize + " Expected: " + expectedSize;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void removeAll_onFilledList_correct(List<String> stringList) {
    //given
    createDefaultList(stringList);
    
    List<String> tempStringList = Arrays.asList("A", "B", "C");
    
    //when
    boolean shouldNotBeRemoved = stringList.removeAll(tempStringList);
    
    //then
    assert shouldNotBeRemoved : "Should be TRUE!";
    
    int actualListSize = stringList.size();
    int expectedSize = 0;
    assert actualListSize == expectedSize : "Actual size: " + actualListSize + " Expected: " + expectedSize;
  }
  
  @Test(dataProvider = "collectionImpl")
  public void removeAll_onEmptyList(List<String> stringList) {
    //given
    List<String> tempStringList = Arrays.asList("A", "B", "C");
    
    //when
    boolean removedAll = stringList.removeAll(tempStringList);
    
    //then
    assert !removedAll : "Should be FALSE!";
  }
  
  @Test(dataProvider = "collectionImpl", expectedExceptions = NullPointerException.class)
  public void removeAll_onFilledList_nullParameter(List<String> stringList) {
    //given
    List<String> tempStringList = null;
    
    //when
    boolean removedAll = stringList.removeAll(tempStringList);
    
    //then
    //exception
  }
  
  @Test(dataProvider = "collectionImpl")
  public void retainAll_onFilledList_correct(List<String> stringList) {
    //given
    createDefaultList(stringList);
    List<String> tempStringList = Arrays.asList("A", "B");
    
    //when
    boolean isRetained = stringList.retainAll(tempStringList);
    
    //then
    assert isRetained : "Should be TRUE!";
  
    boolean containsLetterC = stringList.contains("C");
    assert !containsLetterC : "Shouldn't contain C!";
  }
  
  public void createDefaultList(List<String> stringList) {
    stringList.add("A");
    stringList.add("B");
    stringList.add("C");
    stringList.add("B");
    stringList.add("C");
  }
  
}