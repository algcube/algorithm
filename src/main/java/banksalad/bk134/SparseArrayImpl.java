package banksalad.bk134;

import java.util.HashMap;
import java.util.Map;

public class SparseArrayImpl implements SpareArray {

    private int size;

    private final Map<Integer, Integer> map = new HashMap<>();

    @Override
    public void init(int[] arr, int size) {
        this.size = size;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                map.put(i, arr[i]);
            }
        }
    }

    @Override
    public void set(int i, int val) {
        if (i > size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        map.put(i, val);
        if (i == size) {
            size += 1;
        }
    }

    @Override
    public Integer get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return map.getOrDefault(i, 0);

    }


    public static void main(String[] args) {
        SpareArray arr = new SparseArrayImpl();
        arr.init(new int[]{0, 0, 0}, 5);

        assert arr.get(0) == 0;
        assert arr.get(3) == 0;

        try {
            assert arr.get(-1) == 0;
            assert arr.get(5) == 0;
            arr.set(5, 0);
        } catch (IndexOutOfBoundsException e) {
            // Handle the exception
        }

        arr.set(0, 1);
        assert arr.get(0) == 1;

        arr.set(4, 1);
        assert arr.get(4) == 1;
    }
}
