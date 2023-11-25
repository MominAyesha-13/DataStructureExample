package src.java.main.list1;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList {
    private int[] array ;
    private static final int DEFAULT_ARRAY_SIZE = 10;
    private int size = 0;

    public ArrayList() {
        this.array = new int[DEFAULT_ARRAY_SIZE];
    }
    public void add(int element){
        if (size == array.length){
            int length = size * 2;
            array = Arrays.copyOf(array, length);
        }
        array[size] = element;
        size++;
    }

    public int size(){
        return size;
    }
    public void add(int element, int index){
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length){
            int length = size * 2;
            array = Arrays.copyOf(array, length);
        }
        array[index] = element;
        size++;
    }

    public int remove(int index) {
        Objects.checkIndex(index, size);
        int[] tempArray = array;
        int oldValue = array[index];
        fastRemove(tempArray, index);
        return oldValue;
    }
    private int checkIndex(int index, int size){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        return index;
    }
    private void oldRemove(int[] array, int index){
        for (int i = index; i <= size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
    private void fastRemove(int[] array, int index){
        int newSize = size - index;
        if (newSize > index )
            System.arraycopy(array, index + 1, array, index, newSize - index);
        size = newSize;
        array[size] = 0;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "[ ");
        for (int i = 0; i < size; i++) {
            if (i>0)
                stringBuilder.append(" ,");
            stringBuilder.append(array[i]);
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
