package phonebook;

public class Note {
    private String name;
    private String number;

    public Note(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public void showInfo() {
        System.out.println("Имя: " + name + " Номер: " + number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
