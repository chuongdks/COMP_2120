public class BookTester {
    //Main() method
    public static void main(String[] args) {
        System.out.println("List of my books");
        System.out.println("----------------");

        //Create an instance object of class Counter
        Book book1 = new Book(); //Implicitly call the Contructor method
        book1.setTitle("War and Peace");
        book1.setEdition(0);
        book1.setIsbn(null);
        book1.addAuthor("Tolstoy");
        book1.setPages(250);
        book1.setPrice(99.95);
        System.out.println(book1);
        System.out.println("------");
        
        Book book2 = new Book();
        book2.setTitle("The Hunchback");
        book2.setEdition(2);
        book2.setIsbn("1239812482912");
        book2.addAuthor("Victor Hugo");
        book2.setPages(0);
        book2.setPrice(120.0);
        System.out.println(book2);
        System.out.println("------");

        Book book3 = new Book("2923981728291", "Mind and Cosmos" , 1);
        book3.addAuthor(null);
        book3.setPages(0);
        book3.setPrice(0);
        System.out.println(book3);
        System.out.println("------");

        Book book4 = new Book("2923981728291", "Another Book", 1); //Implicitly call the Contructor method
        book4.addAuthor("Bernard");
        book4.addAuthor("Kyle");
        book4.changeAuthor("Kyle", "Chuck");
        System.out.println(book4); 
        book4.removeAuthor("Bernard");
        book4.setPages(0);
        book4.setPrice(0.0);
        System.out.println(book4);  
        System.out.println("------"); 

        TextBook book5 = new TextBook("3295016510492", "Big Java", 5, "Computer Science"); //Implicitly call the Contructor method
        book5.addAuthor("Horstmann");
        book5.setPages(983);
        book5.setPrice(85.0);
        book5.setIsElectronicVersion(true);
        book5.setElectronicPrice(50.0);        
        System.out.println(book5);   
        System.out.println("------");
    }
}
