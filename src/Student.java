public class Student {
    private String name;
    private int ogrNo;
    public Student next,prev;

    public Student(String name) {
        super();
        this.name=name;
        this.ogrNo=++DoublyCircularLinkedList.ogrCounter;
    }

    public String getName(){return name;}
}