import java.util.Arrays;

public class MyList<E> {
    public int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    public Object[] elements;

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size) {
        elements = new Object[size];
    }

    public int getSize() {
        return size;
    }

    public void ensureCapacity (int minCapacity){
        elements = Arrays.copyOf(elements, minCapacity);
    }

    public void add(E element, int index) {
        if (size == elements.length) {
            ensureCapacity(size*2);
        }
        for (int elementIndex = size - 1; elementIndex >= index; elementIndex--) {
            elements[elementIndex + 1] = elements[elementIndex];
        }
        elements[index] = element;
        size++;
    }

    public void add(E element) {
        if (size == elements.length) {
            ensureCapacity(size*2);
        }
        elements[size++] = element;
    }


    public E remove(int index){
        E temp = (E) elements[index];
        for (int i = index; i < size; i++){
            this.elements[i] = this.elements[i+1];
        }
        this.size--;
        return temp;
    }

    public E get(int index) {
        if (index>= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        return (E) elements[index];
    }

    public Object clone() {
        MyList<E> myCloneList = new MyList<E>();
        myCloneList.elements = this.elements;
        myCloneList.size = this.size;
        return myCloneList;
    }

    public boolean isContain(E element) {
        for (int index = 0; index < size; index++) {
            if (elements[index] == element) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int index = 0; index < size; index++) {
            if (elements[index] == element) {
                return index;
            }
        }
        return -1;
    }

    public void clear() {
        this.size = 0;
        this.elements = null;
    }

}
