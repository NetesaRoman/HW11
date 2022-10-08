package view;

import phonebook.Note;
import phonebook.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookLauncher {
    public static void main(String[] args) {
        int command = 1;
        Scanner in = new Scanner(System.in);
        PhoneBook phonebook = new PhoneBook();

        while (command != 0) {
            System.out.println("Введите команду: ");
            System.out.println("1 - добавить запись");
            System.out.println("2 - найти запись по имени");
            System.out.println("3 - найти все записи по имени");
            System.out.println("0 - выход");

            command = in.nextInt();

            switch (command) {
                case 1:
                    phonebook.add(createNote());
                    System.out.println("Запись добавлена");
                    break;
                case 2:
                    findNote(phonebook);
                    break;
                case 3:
                    findAllNotes(phonebook);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неизвестная команда");
                    break;
            }
        }
    }

    public static void findNote(PhoneBook phonebook) {
        Scanner instr = new Scanner(System.in);
        String name;

        System.out.println("Введитя имя");
        name = instr.nextLine();
        if (!isNull(phonebook.find(name))) {
            phonebook.find(name).showInfo();
        }
    }

    public static void findAllNotes(PhoneBook phonebook) {
        Scanner instr = new Scanner(System.in);
        String name;
        ArrayList<Note> list;

        System.out.println("Введитя имя");
        name = instr.nextLine();

        if (!isNull(phonebook.findAll(name))) {
            list = phonebook.findAll(name);

            for (Note obj : list) {
                obj.showInfo();
            }
        }
    }

    public static Note createNote() {
        Scanner instr = new Scanner(System.in);
        String name;
        String number;

        do {

            System.out.println("Введите имя");
            name = instr.nextLine();
            System.out.println("Введите номер");
            number = instr.nextLine();
        } while (isNull(name) || isNull(number));

        return new Note(name, number);
    }

    private static <T> boolean isNull(T obj) {
        if (obj == null) {
            return true;
        } else return false;
    }
}
