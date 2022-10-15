package view;

import models.MyStruct;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        String[] arrayOfStr = {"apple", "orange", "peanut", "banana", "corn"};
        Integer[] arrayOfInt = {1, 2, 3, 4, 5};
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            list1.add(arrayOfStr[(int) (Math.random() * 5)]);
            list2.add(arrayOfInt[(int) (Math.random() * 5)]);
        }

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(countOccurance(list1, "orange"));
        System.out.println(toList(arrayOfStr));
        System.out.println(findUnique(list2));
        System.out.println(calcOccurance(list1));

        for (MyStruct obj :findOccurance(list1)) {
            obj.showInfo();
        }

    }

    public static int countOccurance(List<String> list, String target) {
        int result = 0;

        if (!isNull(list) && !isNull(target)) {
            for (String word : list) {
                if (word.equals(target)) result++;
            }
        }

        return result;
    }

    public static <T> List toList(T[] targetArray) {
        List<T> outList = new ArrayList<T>();

        if (isNull(targetArray)) {
            return null;
        }

        for (T item : targetArray) {
            outList.add(item);
        }

        return outList;
    }

    public static <T> List<T> findUnique(List<T> target) {
        List<T> result = new ArrayList<T>();

        if (isNull(target)) {
            return null;
        }

        for (T i : target) {
            if (!result.contains(i)) result.add(i);
        }

        return result;
    }

    private static <T> Map<T, Integer> arrayListToHashMap(List<T> arrayList) {
        Map<T, Integer> hashMap = new HashMap<>();

        if (isNull(arrayList)) {
            return null;
        }

        for (T str : arrayList) {
            hashMap.put(str, (Integer) (0));
        }

        return hashMap;
    }

    public static <T> Map<T, Integer> calcOccurance(List<T> target) {
        if (isNull(target)) {
            return null;
        }

        Map<T, Integer> result = arrayListToHashMap(findUnique(target));

        for (T obj : target) {
            if (result.containsKey(obj)) {
                result.replace(obj, (result.get(obj) + 1));

            }
        }

        return result;
    }

    public static <T> List<MyStruct<T>> findOccurance(List<T> target){
        if (isNull(target)) {
            return null;
        }

        List<MyStruct<T>> result = new ArrayList<>();
        List<T> temp = findUnique(target);

        for (T obj : temp) {
            result.add(new MyStruct<>(obj, 0));
        }
        for (T obj : target) {
            for (MyStruct struct: result){
                if(struct.getKey().equals(obj)){
                    struct.setValue(struct.getValue() + 1);
                }
            }
        }

        return result;
    }

    public static <T> boolean isNull(T obj) {
        if (obj == null) {
            return true;
        } else return false;
    }

}