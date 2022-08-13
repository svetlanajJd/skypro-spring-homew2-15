package pro.sky.skyprospringhomew215;

import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.sort;

public class ListImpl implements IntegerList {

    private Integer[] list;

    public ListImpl(Integer[] list) {
        this.list = list;
    }

//    Integer[] arr = new Integer[100_000];


    @Override
    public Integer add(Integer item) {
        Integer[] listCopy;
        if (item == null) {
            throw new ListIndexException();
        } else {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    list[i] = item;
                    break;
                } else {
                    listCopy = Arrays.copyOf(list, list.length + 1);
                    listCopy[list.length] = item;
                }
            }
            return item;
        }
    }

    @Override
    public Integer add(int index, Integer item) {
        Integer[] listCopy = new Integer[list.length + 1];
        if (index > list.length - 1 || item == null) {
            throw new ListIndexException();
        } else
            for (int i = 0; i < index + 1; i++) {
                list[index] = item;
                listCopy[i] = list[i];
                for (int j = index + 1; j < list.length; j++) {
                    listCopy[j] = list[j - 1];
                }
            }
        return listCopy[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        int count = 0;
        Integer[] listCopy = new Integer[list.length - 1];
        for (int n = 0; n < list.length; n++) {
            if (list != null) {
                count++;
            }
        }
        if (index > list.length - 1 || index > count || item == null) {
            throw new ListIndexException();
        } else
            list[index] = item;
        return list[index];
    }

    @Override
    public Integer remove(Integer item) {
        Integer[] listCopy = new Integer[list.length - 1];
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == item) {
                System.arraycopy(list, 0, listCopy, 0, i);
                System.arraycopy(list, i + 1, listCopy, i, list.length - (i + 1));
                list = listCopy;
            }
        }
        return item;
    }

    @Override
    public Integer removeInd(int index) {
        Integer[] listCopy = new Integer[list.length - 1];
        if (index > list.length - 1) {
            throw new ListIndexException();
        } else {
            for (int i = 0; i < list.length - 1; i++) {
                if (i == index) {
                    for (int k = 0; k < i; k++) {
                        listCopy[k] = list[k];
                    }
                    for (int j = i; j < list.length - 1; j++) {
                        listCopy[j] = list[j + 1];
                    }
                    break;
                }

            }
        }
        list = listCopy;
        return list[index];
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] listCopy = toArray();
        sort(listCopy);
        return binarySearch(listCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int i = list.length - 1;
        while (i >= 0) {
            if (list[i] == item) {
                return i;
            }
            i = i - 1;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        for (int i = 0; i < list.length - 1; i++) {
            if (i == index) {
                return list[i];
            }
        }
        return list[index];
    }

    public boolean equals(Integer[] otherList) {
        if (Arrays.equals(list, otherList) == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isEmpty() {
        if (list.length != 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void clear() {
        list = new Integer[0];
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArr = new Integer[list.length];
        for (int i = 0; i < list.length; i++) {
            newArr[i] = list[i];
        }
        return newArr;
    }

    @Override
    public Integer[] print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);

        }
        return list;
    }

    @Override
    public boolean equals(Object other) {
        ListImpl listImpl = (ListImpl) other;
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return Arrays.equals(list, listImpl.list);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(list);
    }


    private static Integer random() {
        Random random = new Random();
        int randomNum = random.nextInt();
        return randomNum;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        Integer tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private void sortSelection(Integer[] arr) {
        arr = new Integer[100_000];
        for (int m = 0; m < arr.length; m++) {
            arr[m] = random();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (item == arr[mid]) {
                return true;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    public void method() {
        Integer[] arr = new Integer[100_000];
        sortSelection(arr);
        long start = System.currentTimeMillis();
        sortSelection(arr);
        System.out.println(System.currentTimeMillis() - start);
    }
}