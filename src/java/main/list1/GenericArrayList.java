package src.java.main.list1;



import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class GenericArrayList<T>  implements List<T> {
    private static final int DEFAULT_ARRAY_SIZE = 10;
    private int size = 0;
    private Object[] arrayList;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public GenericArrayList() {
        this.arrayList = new Object[DEFAULT_ARRAY_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(arrayList, 0, size);
    }

    @Override
    public boolean add(T o) {
        if (size == arrayList.length){
            grow();
        }
        arrayList[size] = o;
        size++;
        return true;
    }

    private void grow() {
        int length = size * 2;
        arrayList = Arrays.copyOf(arrayList, length);
    }

    @Override
    public boolean remove(Object o) {
        final Object[] tempArray = arrayList;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++) {
                    if (tempArray[i] == null)
                        break found;
                }
            } else {
                for (; i < size; i++) {
                    if (tempArray[i].equals(o))
                        break found;
                }
            }
            return false;
        }
        fastRemove(tempArray, i);
        return false;
    }
    private Object[] grow(int minCapacity) {
        int oldCapacity = arrayList.length;
        if (oldCapacity > 0 || arrayList != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = minCapacity * 2;
            return arrayList = Arrays.copyOf(arrayList, newCapacity);
        } else {
            return arrayList = new Object[Math.max(DEFAULT_ARRAY_SIZE, minCapacity)];
        }
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] array = c.toArray();
        int newNum = array.length;
        if (newNum == 0)
            return false;
        Object[] tempArray = arrayList;
        int size = this.size;
        if (newNum > tempArray.length - size)
            grow(newNum + size);
        System.arraycopy(array, 0, tempArray, size, newNum);
        this.size += size;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    private void fastRemove(Object[] ob, int index){
        int newSize = size - 1;
        if (newSize > index)
            System.arraycopy(ob, index + 1, ob, index, newSize - index);
        size = newSize;
        ob[size] = null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public T get(int index)  {
        Objects.checkIndex(index, size);
        return elementData(index);
    }
    @SuppressWarnings("unchecked")
    private T elementData(int index){
        return  (T) arrayList[index];
    }
    @Override
    public T set(int index, Object element) {
        Objects.checkIndex(index, size);
        T oldValue = elementData(index);
        arrayList[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, Object element) {
        Objects.checkIndex(index, size);
        if (size == arrayList.length) {
            grow();
        }
        Object[] tempArray = arrayList;
        int newSize = size ;
        System.arraycopy(tempArray, index, tempArray, index + 1, newSize - index);
        arrayList[index] = element;
        size = newSize + 1;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] tempArray = arrayList;
        @SuppressWarnings("unchecked") T oldElement = (T) arrayList[index];
        fastRemove(tempArray, index);
        return oldElement;
    }

    @Override
    public int indexOf(Object o) {
        Object[] tempArray = arrayList;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (tempArray[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (tempArray[i].equals(o))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Object[] tempArray = arrayList;
        int end = size - 1;
        if (o == null) {
            for (int i = end; i >= 0; i--) {
                if (tempArray[i] == null)
                    return i;
            }
        } else {
            for (int i = end; i >= 0; i--) {
                if (tempArray[i].equals(o))
                    return i;
            }
        }
        return -1 ;
    }
    public int myLastIndexOf(Object o){
        int lastIndex = -1;
        Object[] tempArray = arrayList;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (tempArray[i] == null)
                    lastIndex = i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (tempArray[i].equals(o))
                    lastIndex = i;
            }
        }
        return lastIndex;
    }
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override @SuppressWarnings("unchecked")
    public T[] toArray(Object[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(arrayList, size, a.getClass());
        System.arraycopy(arrayList, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return(T[]) a;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "[");
        for (int i = 0; i < size; i++) {
            if (i>0)
                stringBuilder.append(", ");
            stringBuilder.append(arrayList[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
