public class Histogram {
    // Internal data (private fields)
    public int[] bins = new int[10];

    /**
     * Default constructor with 10 bins values -1;
     */
    public Histogram(){
        // this.bins = new int[10]; 
        // for (int i = 0; i < bins.length; i++)
        // {
        //     bins[i] = -1;
        // } OR
        this (10);
    }

    /**
     * Default constructor with 10 bins values -1;
     */
    public Histogram (int numberofBins){
        this.bins = new int[numberofBins]; 
        for (int i = 0; i < bins.length; i++)
        {
            bins[i] = -1;
        }
    }

    //Method for bin class
    public void setBin (int binNumber, int binValue)
    {
        this.bin[binNumber] = binValue;
    }

    public void setAllBin (int binValue)
    {
        for (int i = 0; i < bins.length; i++)
        {
            setBin (i, binValue);
        } 
    }
    
    public int getBin (int binNumber)
    {
        return bins[binNumber];
    }

    // Operations (public methods)  
    // Sets the number of bins (previous data is deleted)
    public void setNumberOfBins(int numberBins) 

    // Prints the histogram
    public void printHistogram() 

    public static void main(String[] args){
        //CHeck a Histogram object with 30 bins
        Histogram H30 = new Histogram (30);
        H30.setAllBin (5);
        //CHeck a Histogram object
        Histogram H = new Histogram();
        h.setBin(2, 45);
    }
}


