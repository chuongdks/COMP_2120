public class GenericItem {
    public String itemName;
    public int itemQuantity;
 
    public void setName(String newName) 
    {
       itemName = newName;
    }

    public String getName () 
    {
       return itemName;
    }
 
    public void setQuantity(int newQty) 
    {
       itemQuantity = newQty;
    }

    public int getQuantity () 
    {
       return itemQuantity;
    }
 
    public void printItem() 
    {
       System.out.println(itemName + " " + itemQuantity);
    }

    @Override
    public String toString()
    {
        return "Name: " + this.itemName + ", Quantity: " + this.itemQuantity;
    }

    @Override
    public boolean equals (Object obj)
    {
      if (obj instanceof GenericItem)
      {
         GenericItem otherObject = (GenericItem) obj;
         return this.itemName.equals(otherObject.itemName);//  && this.itemQuantity == otherObject.itemQuantity;
      }
      else
      {
         return false;
      }
    }
 }