package a1template;

import java.util.Arrays;

/**
 * A generic dynamic array implementation that supports indexed access,
 * resizing, and setting values. It also implements the IndexAccess interface.
 *
 * @param <T> the type of elements in the array
 */
public class DynamicArray<T> implements IndexAccess<T> {
    private T[] array;
    private int size;

    /**
     * Constructs a DynamicArray from an existing array.
     * Sets the size to the length of the input array.
     *
     * @param inputed_array the initial array of elements
     */
    public DynamicArray(T[] inputed_array) {
        this.array = inputed_array;
        this.size = inputed_array.length;
    }

    /**
     * Constructs a DynamicArray with a specified capacity and initial elements.
     * If the capacity is smaller than the input array length, the capacity is increased.
     *
     * @param capacity the minimum capacity of the internal array
     * @param inputed_array the array of elements to initialize the dynamic array with
     */
    public DynamicArray(int capacity, T[] inputed_array) {
        this.array = (T[]) new Object[Math.max(capacity, inputed_array.length)];
        System.arraycopy(inputed_array, 0, this.array, 0, inputed_array.length);
        this.size = inputed_array.length;
    }

    /**
     * Returns the value stored at a given index.
     *
     * @param i index of the element to retrieve
     * @return the value stored at index i
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public T get(int i) {
        if (i >= 0 && i < size) {
            return array[i];
        }
        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
    }

    /**
     * Returns the value stored at a given index plus an offset.
     *
     * @param i the base index
     * @param offset the value to add to the base index
     * @return the value at index (i + offset)
     * @throws IndexOutOfBoundsException if the resulting index is out of bounds
     */
    @Override
    public T get(int i, int offset) {
        int newIndex = i + offset;
        if (newIndex >= 0 && newIndex < size) {
            return array[newIndex];
        }  
        throw new IndexOutOfBoundsException("Index " + newIndex + " is out of bounds.");
    }

    /**
     * Stores a given value at a specified index.
     *
     * @param i the index to store the value at
     * @param val the value to store
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    @Override
    public void set(int i, T val) {
        if (i >= 0 && i < size) {
            array[i] = val;
        } else {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
        }
    }

    /**
     * Adds a new element to the end of the dynamic array.
     * Automatically resizes the internal array if it's full.
     *
     * @param element the element to add
     */
    public void add(T element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = element;
    }

    /**
     * Returns the number of elements in the dynamic array.
     *
     * @return the current size of the array
     */
    public int size() {
        return size;
    }
}