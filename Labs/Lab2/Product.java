import java.util.Scanner;

public class Product {
    // Build Product class with public methods and private fields listed above
    private String productCode;
    private double productPrice;
    private int numInventory;

    public Product(String code, double price, int count) //- set the member fields using the three parameters
    {
        this.productCode = code;
        this.productPrice = price;
        this.numInventory = count;
    }

    public void setCode(String code) //- set the product code (i.e. SKU234) to parameter code
    {
        this.productCode = code;
    }

    public String getCode() //- return the product code
    {
        return productCode;
    }

    public void setPrice(double p) //- set the price to parameter p
    {
        this.productPrice = p;
    }
    public double getPrice() //- return the price
    {
        return productPrice;
    }

    public void setCount(int num) //- set the number of items in inventory to parameter num
    {
        this.numInventory = num;
    }

    public int getCount() //- return the count
    {
        return numInventory;
    }
    public void addInventory(int amt) //- increase inventory by parameter amt
    {
        this.numInventory += amt;
    }

    public void sellInventory(int amt) //- decrease inventory by parameter amt
    {
        this.numInventory -= amt;
    }

    // main
    public static void main(String args[]) {
        String name = "Apple";
        double price = 0.40;
        int num = 3;
        Product prod = new Product(name, price, num);

        // Test 1 - Are instance variables set/returned properly?
        System.out.println("Name: " + prod.getCode()); 
        System.out.printf("Price: %.2f\n", prod.getPrice()); 
        System.out.println("Count: " + prod.getCount());
        System.out.println();

        // Test 2 - Are instance variables set/returned properly after adding and selling?
        num = 10;
        prod.addInventory(num);
        num = 5;
        prod.sellInventory(num);
        System.out.println("Name: " + prod.getCode()); 
        System.out.printf("Price: %.2f\n", prod.getPrice());
        System.out.println("Count: " + prod.getCount());
        System.out.println();

        // Test 3 - Do setters work properly?
        name = "Golden Delicious";
        prod.setCode(name);
        price = 0.55;
        prod.setPrice(price);
        num = 4;
        prod.setCount(num);
        System.out.println("Name: " + prod.getCode()); 
        System.out.printf("Price: %.2f\n", prod.getPrice()); 
        System.out.println("Count: " + prod.getCount()); 
    }
}