package phonebook;

import java.util.*;

public class PhoneBook extends ArrayList {

    private static final int MAX_CAPACITY = 1000;
    private int length = 0;
    private Note[] noteArray;


    public PhoneBook() {
        noteArray = new Note[MAX_CAPACITY];
    }

    public boolean add(Note note) {
        if (isNull(note)) {
            return false;
        } else {
            noteArray[length] = note;
            length++;
            return true;
        }

    }

    public boolean add(String name, String number) {
        if (isNull(name) || isNull(number)) {
            return false;
        } else {
            noteArray[length].setName(name);
            noteArray[length].setNumber(name);
            return true;
        }

    }

    public Note find(String name) {
        if (isNull(name)) {
            return null;
        }

        for (int i = 0; i < length; i++) {
            if (noteArray[i].getName().equals(name)) {
                return noteArray[i];
            }
        }
        return null;
    }

    public ArrayList<Note> findAll(String name) {
        if (isNull(name)) {
            return null;
        }

        ArrayList<Note> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (noteArray[i].getName().equals(name)) {
                result.add(noteArray[i]);
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