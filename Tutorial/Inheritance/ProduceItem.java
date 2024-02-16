public class ProduceItem extends GenericItem { 
   public String expirationDate;

   public void setExpiration(String newDate) 
   {
      expirationDate = newDate;
   }

   public String getExpiration() 
   {
      return expirationDate;
   }  

   @Override
   public void printItem() 
   {
        // System.out.println (this.getName() + " " + this.getQuantity() + " " + this.getExpiration());
        // New method replace above
        super.printItem(); //will do newline
        System.out.println (". Expired date: " + this.getExpiration());
   }

    @Override
    public String toString()
    {
        return super.toString() + ", Expire date: " + this.expirationDate;
    }

    public static void main(String[] args) {
        GenericItem item1 = new GenericItem();
        item1.setName ("Book1");
        item1.setQuantity (10);

        GenericItem item4 = new GenericItem();
        item4.setName ("Book1");
        item4.setQuantity (10);

        ProduceItem item3 = new ProduceItem();
        item3.expirationDate = "May 1 2025";
        item3.setName ("Orange");
        // item3.itemQuantity = 8;
        item3.setQuantity (8);

        item1.printItem();
        item3.printItem();
        
        System.out.println (item1.toString());

        ProduceItem item2 = new ProduceItem();
        item2.setExpiration ("May 1 2025");
        item2.setName("Orange");
        item2.setQuantity (8);

        System.out.println (item2); // Dont need toString

        System.out.println (item1.equals(item4));
    }
}