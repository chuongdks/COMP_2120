public class TextBook extends Book {
    private String subject;
    private boolean isElectronicVersion;
    private double ePrice;

    // Default constructor
    public TextBook() {
        super();
        this.subject = "No Subject";
    }

    // Constructor with parameters
    public TextBook (String isbn, String title, int edition, String subject) {
        super(isbn, title, edition);
        this.subject = subject;
    }

    // Getter and Setter methods
    public String getSubject() 
    {
        return subject;
    }

    public void setSubject (String subject) 
    {
        this.subject = subject;
    }

    public boolean isElectronicVersion() 
    {
        return isElectronicVersion;
    }

    public void setHasElectronicVersion (boolean isElectronicVersion) 
    {
        this.isElectronicVersion = isElectronicVersion;
    }

    public double getElectronicPrice() 
    {
        return ePrice;
    }

    public void setElectronicPrice (double ePrice) 
    {
        this.ePrice = ePrice;
    }

    // Method to add "(TextBook)" to the end of the book title
    public void addTextBookTag() 
    {
        setTitle (getTitle() + " (TextBook)");
    }

    // Override toString method
    @Override
    public String toString() {
        String eBookString = isElectronicVersion ? "Yes" : "No";
        double ePriceString = isElectronicVersion ? ePrice : 0;

        return super.toString() +
                "Subject: " + subject + '\n' +
                "eBook: " + eBookString + '\n' +
                "ePrice: " + ePriceString + '\n' +
                "------";
    }
}
