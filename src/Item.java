/**
 * This class has the basic data structure for an item that can be a Book or CD or a DVD
 * @author Mohammad Azad | mazad@uncc.edu
 * Professor - Geoffrey Grimaud
 */
public class Item {
    
    // Fields for Item / products with following variable type
    private String type;
    private String name;
    private double price;
    private int amount;

    /**
     * Items Constructor without the type. This will be used when user adds any item manually.
     * @param name string value
     * @param price double value
     * @param amount integer value
     */
    public Item(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    /**
     *Items Constructor. This will be used when user adds item from a file.
     * @param type string value
     * @param name String value
     * @param price double value
     * @param amount integer value
     */
    public Item(String type, String name, double price, int amount) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    /**
     * This method gets the item type.
     * @return string value of the type
     */
    public String getType() {
        return type;
    }

    /**
     * this method gets the name of the item
     * @return string type value of name
     */
    public String getName() {
        return name;
    }

    /**
     * this method gets the price of the item
     * @return double type value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * this method gets the quantity of the item
     * @return integer type value of the price
     */
    public int getAmount() {
        return amount;
    }

    /**
     * this method sets the type of the item
     * @param type the string type for name of the type of item
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * this method sets the name of the item
     * @param name string type
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * this method sets the price of the item
     * @param price double type
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * this method sets the quantity of the item
     * @param amount integer type
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
