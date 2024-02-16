public class ItemTester {
    //Main() method
    public static void main(String[] args) {
        GenericItem item1 = new GenericItem();
        item1.setName ("Book1");
        item1.setQuantity (10);

        ProduceItem item3 = new ProduceItem();
        item3.expirationDate = "May 1 2025";
        item3.setName("Orange");
        // item3.itemQuantity = 8;
        item3.setQuantity (8);

        item1.printItem();
        item3.printItem();
        
        System.out.println (item1.toString());

        ProduceItem item2 = new ProduceItem();
        item3.setExpiration ("May 1 2025");
        item3.setName("Orange");
        item3.setQuantity (8);

        System.out.println (item2); // DOnt need toString

        System.out.println (item1.equals(item3));
    }
}