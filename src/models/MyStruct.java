package models;

public class MyStruct<K> {
    K key;
    int value;


    public MyStruct(K key, int value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void showInfo() {
        System.out.println("Key = " + key + " Value = " + value);
    }
}
