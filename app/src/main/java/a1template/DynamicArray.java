package a1template; 
import java.util.Arrays;

public class DynamicArray<T> implements IndexAccess<T> {
    private T[] array;
    private int size;

    // Constructor that takes only the input array and sets size based on it
    public DynamicArray(T[] inputed_array) {
        this.array = inputed_array;
        this.size = inputed_array.length;
    }

    public DynamicArray(int capacity, T[] inputed_array) {
        // Ensure the internal array has at least the size of the inputed_array
        this.array = (T[]) new Object[Math.max(capacity, inputed_array.length)];
        // Copy elements from inputed_array to the internal array
        System.arraycopy(inputed_array, 0, this.array, 0, inputed_array.length);
        this.size = inputed_array.length;
        System.out.println(inputed_array.length);  // Set the correct size
    }

    /** Returns the value stored at a given index
     * @param i index of element to read
     * @return value stored at the given index
     */
    public T get(int i) {
        if (i >= 0 && i < size) {  // Only access within the current size
            System.out.println(array[i]);
            return array[i];  // Return the element at index i
        }
        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
    }

    /** Returns the value stored at a given index plus the offset
     * @param i index of element to read
     * @param offset adjust index by this value
     * @return value stored at the given index
     */
    @Override
    public T get(int i, int offset) {
        int newIndex = i + offset;
        
        // Ensure newIndex is within bounds (0 to size-1)
        if (newIndex >= 0 && newIndex < size) {
            return array[newIndex];
        }  
        // If out of bounds, throw the exception
        throw new IndexOutOfBoundsException("Index " + newIndex + " is out of bounds.");
    }

    /** Stores the given value at the given index
     * @param i index of location to store
     * @param val value to store at given index
     */
    @Override
    public void set(int i, T val) {
        if (i >= 0 && i < size) {  // Ensure valid index
            array[i] = val;
        } else {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
        }
    }

    // Adds an element to the dynamic array
    public void add(T element) {
        if (size == array.length) {
            // Resize if needed
            array = Arrays.copyOf(array, array.length * 2);  // Double the size
        }
        array[size++] = element;  // Add the element and increment size
    }

    // Return the current size of the array
    public int size() {
        return size;
    }
}