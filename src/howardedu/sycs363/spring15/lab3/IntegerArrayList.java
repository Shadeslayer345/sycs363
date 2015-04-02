package howardedu.sycs363.spring15.lab3;

/**
 * Class to handle storage of integers in an array, mimicing dynamic allocation.
 */
public class IntegerArrayList {
    
    private int[] array; // Initial array
    private int size; // Size of the array
    private int end; // The last used index in the array

    /**
     * Basic constructor that initializes our base array and the larger array
     *     to be used to imitate dynamic sizing.
     * @constructor
     */
    public IntegerArrayList() {
        size = 25;
        end = 0;
        array = new int[size];
    }

    /**
     * Constructor that initializes both the base array and larger array with a
     *     a given size value.
     * @param  newSize The size of the array.
     * @constructor
     */
    public IntegerArrayList(int newSize) {
        size = newSize;
        end = 0;
        array = new int[size];
    }

    /**
     * Appends a new value to the end of the array.
     * @param value New integer to append to the array.
     */
    public void add(int value) {
        if (end > size - 1) {
            System.out.println("Array out of space! Expanding array...\n");
            int[] new_array = new int[size*2];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
            size = size * 2;
            System.out.println("Array expanded and new elements added!\n\n");
        }
        array[end] = value;
        end++;
    }

    /**
     * Inserts a new element into a specified position in the array.
     * @param index Position to insert element.
     * @param value Element to insert.
     */
    public void add(int index, int value) {
        if (index > size - 1) {
            System.out.println("Array out of space! Expanding array...\n\n");
            int[] new_array = new int[((Math.abs(size - index ) / size) + 2 ) * size];
            System.arraycopy(array, 0, new_array, 0, array.length);
            array = new_array;
            size = ((size - index) / size) * size;
            end = index;
            System.out.println("Array expanded and new elements added!\n\n");
        }
        array[index] = value;
        if (end == index) {
            end++;
        } else if (index > end) {
            end = index;
        }
    }

    /**
     * Return the integer value at the specified index
     * @param  index The position in the array.
     * @return  index value or -1 if not in the array
     */
    public int get(int index) {
        return (index <= end && index < size) ? array[index] : -1;
    }

    /**
     * Return the firsst index of specifc value in the list/array. Return -1 if
     *     not present.
     * @param  value Integer used as the search values when checking array.
     * @return value's index
     */
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Determines if the array is populated.
     * @return true if empty
     *         false if populated
     */
    public boolean isEmpty() {
        return (end == 0) ? true : false;
    }

    /**
     * Remove and return the value from the specified index in the array/list,
     *     all values after the removed position are moved forward one index.
     * @param  index The position in the array where the value to be removed is.
     * @return removed value or -1 if the value is not in the list
     */
    public int remove(int index) {
        if (index > end) {
            return -1;
        } else {
            int removed_value = array[index];
            for (int i = index; i < end - 1; i++) {
                array[i] = array[i+1];
            }
            end--;
            return removed_value;
        }
    }
}

