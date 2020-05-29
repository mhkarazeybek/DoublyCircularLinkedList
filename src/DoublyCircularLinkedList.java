public class DoublyCircularLinkedList {
    public static int ogrCounter=0;
    static Student head,tail;

    public static void main(String[] args) {
        Student students[] = {new Student("Gökhan"), 
        new Student("Abdulkerim"), 
        new Student("Mehmet Faruk"), 
        new Student("Muhammed Hüseyin"),
        new Student("Mustafa"),
        new Student("Sena"),
        new Student("Zehra Şevval"),
        new Student("Bilge Sena") };
        
        for (Student student : students)
            setStudents2LinkedList(student);

        //dögü ile erişim

        // Student temp = head ;
        // do{
        //     System.out.println(temp.getName());
        //     temp = temp.next ;
        // }while(temp != head);

        //fonksiyonla erişim
        access2LinkedListWithFunc(head);

        System.out.println("-----------------Başa Ekleme---------------------");
        addStudent2Begin(new Student("Öykü"));
        access2LinkedListWithFunc(head);

        System.out.println("-----------------Sona Ekleme---------------------");
        addStudent2End(new Student("Sare"));
        access2LinkedListWithFunc(head);

        System.out.println("-----------------Araya Ekleme---------------------");
        addStudent2Between("Muhammed Hüseyin", new Student("Demiral"));
        access2LinkedListWithFunc(head);

        System.out.println("-----------------Başdan Silme---------------------");
        removeStudent2Begin();
        access2LinkedListWithFunc(head);

        System.out.println("-----------------Sondan Silme---------------------");
        removeStudent2End();
        access2LinkedListWithFunc(head);
        
        System.out.println("-----------------Aradan Silme---------------------");
        removeStudent2Between("Zehra Şevval");
        access2LinkedListWithFunc(head);
    }


    public static void access2LinkedListWithFunc(Student student){
        if(student == tail){
            System.out.println(student.getName());
            return;
        }
        System.out.println(student.getName());
        access2LinkedListWithFunc(student.next);
        //recursive fonk ile dongu arasindaki farklar
    }
    //bir problem verip o problemin hangi veri yapısı ile çözeceğinizi soracak ve bu veri yapısı niçin tercih ettiniz?

    /*
    Linked List Nedir?
    Niçin kullanmalıyız?
    Avantajları ve dezavantajları nelerdir?

    1- başa ekleme-silme
    2- araya ekleme-silme
    3- sona ekleme-silme
    */

    public static void setStudents2LinkedList(Student student){
		if (head == null) {
            student.next=student;
            student.prev=student;
            head=student;
            tail=student;
            return;
        }else {
            tail.next=student;
            student.prev=tail; 
        }
        tail = student;
        tail.next=head;
    }
    public static void addStudent2Begin(Student student) {
        student.next=head;
        student.prev=tail;
        tail.next=student;
        head=student;
        head.prev=tail;
    }
    public static void addStudent2End(Student student) {
        student.next=head;
        student.prev=tail;
        tail.next=student;
        tail=student;
        head.prev=tail;
    }
    public static void addStudent2Between(String name,Student student) {
        Student temp = head;
        while(!temp.getName().equals(name))
            temp = temp.next;

        student.next=temp.next;
        student.prev=temp;
        temp.next=student;
    }
    public static void removeStudent2Begin() {
        head = head.next;
		tail.next = head;
    }   
    public static void removeStudent2End(){

        Student temp = head;
        while(temp.next != tail)
            temp=temp.next;
        temp.next=head;
        tail=temp;
    }
    public static void removeStudent2Between(String name){

        Student temp = head;
        while(!temp.next.getName().equals(name)){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}