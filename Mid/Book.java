import java.util.ArrayList;

public class Book {
    private String isbn;
    private String title;
    private ArrayList<String> authors;
    private int edition;
    private int pages;
    private double price;

    // Default constructor
    public Book() {
        this.title = "No Title Yet";
        this.authors = new ArrayList<>();
    }

    // Constructor with parameters
    public Book (String isbn, String title, int edition) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.authors = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getIsbn() 
    {
        return isbn;
    }

    public void setIsbn(String isbn) 
    {
        this.isbn = isbn;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    // public ArrayList<String> getAuthors() 
    // {
    //     return authors; // does this even work?
    // }

    public int getEdition() 
    {
        return edition;
    }

    public void setEdition(int edition) 
    {
        this.edition = edition;
    }

    public int getPages() 
    {
        return pages;
    }

    public void setPages(int pages) 
    {
        this.pages = pages;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    // Method to add an author
    public void addAuthor(String author) 
    {
        this.authors.add(author);
    }

    // Method to remove a specific author
    public void removeAuthor(String author) 
    {
        this.authors.remove(author);
    }

    // Method to change an author
    public void changeAuthor (String currentAuthor, String newAuthor) 
    {
        // int index = this.authors.indexOf(currentAuthor); // index return -1 if failed
        // Search for currentAuthor in the authors's ArrayList
        boolean found = false;
        int index = 0;  
        while ( (!found) && (index < authors.size()) ) 
        {
            if (authors.get(index).equals(currentAuthor)) 
            {
                found = true; 
                break;
            }
            ++index;
        }
        // If there is a valid Author in the ArrayList, replace using set()
        if (found) 
        {
            this.authors.set(index, newAuthor);
        }
    }

    // Method to print all author
    public String printAuthor() 
    {
        String addAuthor = "";
        for (int i = 0; i < this.authors.size(); ++i) 
        {
            //System.out.println("" + authors.get(i) + ", ");
            if (i == (this.authors.size() - 1))
            {
                addAuthor += authors.get(i);
                break;
            }
            addAuthor += authors.get(i) + ", " ;
        }
        return addAuthor;
    }    

    // Override toString method
    @Override
    public String toString() {
        return "Title: " + title +'\n' +
                "Edition: " + edition +'\n' +
                "ISBN: " + isbn +'\n' +
                "Authors: " + printAuthor() +'\n' +
                "Pages: " + pages +'\n' +
                "Price: " + price               
                ;
    }
}
