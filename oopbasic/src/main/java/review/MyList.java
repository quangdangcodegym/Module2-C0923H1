package review;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private Object[] elements;
    private int size;

    private int DEFAULT_CAPACITY = 5;


    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }


    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size] = e;
        size++;
        return true;
    }

    public E get(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elements[index];
    }


    public void add(E e, int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == elements.length) {
            ensureCapa();
        }
//        for(int i = size; i > index; i--){
//            elements[i] = elements[i-1];
//        }
//        elements[index] = e;
//        size++;

        E temp = (E) elements[index];
        for (int i = index; i <= size-1; i++){
            E temp1 = (E) elements[i + 1];
            elements[i + 1] = temp;
            temp = temp1;
        }
        elements[index] = e;
    }


    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(5);


        /*
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
         */

    }
}
