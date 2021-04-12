import java.util.Arrays;

public class MyList<E>{
    public int size =0;
    private static final int DEFALUT_CAPACITY = 10;
    private Object[] elements;
    public MyList() {
        elements = new Object[DEFALUT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static int getDefalutCapacity() {
        return DEFALUT_CAPACITY;
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

    public void add(int index, E ele) {
        if (size == elements.length) {
            ensureCapa();
        }
        for (int i = size; i >= index ; i--) {
            Object temp = elements[i+1];
            elements[i+1] = elements[i];
            elements[i] = temp;
        }
        elements[index] = ele;
        size++;
    }

    public E remove(int index){
        for (int i = index; i < size  ; i++) {
            Object temp = elements[i];
            elements[i] = elements[i+1];
            elements[i+1] = temp;

        }
        elements[size--] = null;
        return (E) this;
    }

    public MyList<E> clone(){
        MyList<E> cloneObject = new MyList();

        for (int i = 0; i < size; i++) {
            cloneObject.elements[i] = (elements[i]);
        }
        cloneObject.size= this.size;
        return  cloneObject;
    }

    public boolean contains(E o){
        for (int i = 0; i < size; i++) {
            if (this.get(i) == o) return true;
        }
        return false;
    }

    public int indexOf(E o){
        for (int i = 0; i < size; i++) {
            if (this.get(i) == o) return i;
        }
        return -1;
    }

    public void clear(){
        for (int i = size-1; i >= 0 ; i++) {
            elements[i] = null;
        }
    }




}