import java.util.*;

public class BinaryInsertionSortTest{
  public static void main(String[] args){
    test(0);
    test(1);
    test(2);
    test(3);
    test(4);
    test(10);
    test(20);
  }

  public static void test(int size){
    Random random = new Random();
    Integer[] array = new Integer[size];
    for(int i=0; i<size; i++)
      array[i] = random.nextInt(size + 1);

    // System.out.println("before: ");
    // System.out.println(Arrays.toString(array));

    BinaryInsertionSort.sort(array);
    //
    // System.out.println("after: ");
    // System.out.println(Arrays.toString(array));

    for(int i = 0; i < array.length-2; i++){
      if(array[i] > array[i+1])
        System.out.println("wrong answer");
    }
    System.out.println("test done");
  }
}

class BinaryInsertionSort{
  public static <E extends Comparable<? super E>> void sort(E[] array){
    if(array == null)
      throw new IllegalArgumentException("wrong input");

    for(int i=1; i<array.length; i++){
      int newIndex = findPosition(array, i-1, array[i]);
      // System.out.println("new item = " + array[i] + ", new index = " + newIndex);
      shiftUp(array, i, newIndex);
      // System.out.println("shifup i = " + i + ", new index = " + newIndex);
      // System.out.println(Arrays.toString(array));
    }
  }

  private static <E extends Comparable<? super E>> void shiftUp(E[] array, int oldIndex, int newIndex){
    if(oldIndex < newIndex)
      throw new IllegalArgumentException("cannot shift up");

    E temp = array[oldIndex];
    for(int i = oldIndex; i > newIndex; i--)
      array[i] = array[i-1];

    array[newIndex] = temp;
  }

  private static <E extends Comparable<? super E>> int findPosition(E[] array, int right, E item){
    if(right < 0 || right >= array.length)
      throw new IllegalArgumentException("RIGHT is wrong");

    if(item == null)
      throw new IllegalArgumentException("ITEM cannot be null");

    int left = 0;
    int mid = left;
    while(left <= right){
      mid = (right-left)/2 + left;
      if(array[mid].compareTo(item) > 0)
        right = mid - 1;
      else if(array[mid].compareTo(item) < 0)
        left = mid + 1;
      else
        return mid;
    }

    if(array[mid].compareTo(item) < 0)
      mid++;
    return mid;
  }
}
