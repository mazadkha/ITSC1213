
import java.util.ArrayList;
/**
 * This class takes care for all the purchases done and add items to the cart and creates invoice.
 * @author Mohammad Azad | mazad@uncc.edu
 * Professor - Geoffrey Grimaud
 */
public class Order {
    //Colored Output Options.
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    /**
     * This fields collects the item and acts as a cart.
     */
    private static ArrayList<Item> order = new ArrayList<>();

    /**
     * This fields store the original item ID and the quantity requested by the user.
     */
    private static ArrayList<int[][]> idAndQuantityList = new ArrayList<>();

    /**
     *
     */
    private String paymentMethod;

    /**
     * this method gets original item ID and the quantity requested by the user when an item is added to the cart.
     * @return ArrayList of integer 2 D array
     */
    public static ArrayList<int[][]> getIdAndQuantityList() {
        return idAndQuantityList;
    }

    /**
     * this method gets payment method used to checkout.
     * @return string type
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * this method sets original item ID and the quantity requested by the user in a 2D array when an item is added to the cart.
     * @param idAndQuantityList Array list of 2d Array
     */
    public static void setIdAndQuantityList(ArrayList<int[][]> idAndQuantityList) {
        Order.idAndQuantityList = idAndQuantityList;
    }

    /**
     * this method sets payment method as per the users choice.
     * @param paymentMethod string type
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
        
    /**
     * This method gets the list of the ordered items as a list.
     * @return ArrayList of items
     */
    public ArrayList<Item> getOrder() {
        return order;
    }

    /**
     * This method sets the list of the ordered items as a list.
     * @param order ArrayList of Items
     */
    public void setOrder(ArrayList<Item> order) {
        this.order = order;
    }
    
    /**
     * This method adds adds and item to the cart list.
     */
    public void addToCart(){
        Inventory inventory = new Inventory();
        inventory.displayItems();
        int inInt = 0;
        int quanInt = 0;
        while (inInt<1 || inInt>inventory.getItems().size()){
            System.out.print("\n------> Look at the Items Above & Enter a Valid ID: ");
            inInt = Excptns.invalidInt();
        }
        while (quanInt<1 || quanInt>inventory.getItems().get(inInt-1).getAmount()){
            System.out.print("------> Enter a Valid Quantity: ");
            quanInt = Excptns.invalidInt();
        }
        
        int[][] idAndQuantity = new int[1][2];
        idAndQuantity[0][0]=inInt-1;
        idAndQuantity[0][1]=quanInt;
        idAndQuantityList.add(idAndQuantity);
        Item temp = new Item(inventory.getItems().get(inInt-1).getType(), inventory.getItems().get(inInt-1).getName(), inventory.getItems().get(inInt-1).getPrice(), inventory.getItems().get(inInt-1).getAmount());
        order.add(temp);
        order.get(order.size()-1).setAmount(quanInt);
        System.out.println(ANSI_GREEN+"\nItem Added to Cart Successfully"+ANSI_RESET);
        
        if (quanInt == inventory.getItems().get(inInt-1).getAmount()){
                    inventory.getItems().remove(inInt-1);
        }
        else{
            inventory.getItems().get(inInt-1).setAmount(inventory.getItems().get(inInt-1).getAmount()- quanInt);
        }
//        for (int i =0; i < idAndQuantityList.size();i++){
//            System.out.println("Index: "+i+" | ["+idAndQuantityList.get(i)[0][0]+"], ["+idAndQuantityList.get(i)[0][1]+"]");
//        }
    }
    
    /**
     * This method displays order carts items and the total value for the cart.
     */
    public void displayOrder() {
        System.out.println("\n----------------------------------------------------------------------------------");
        System.out.format("%-9s%-1s\t%-32s%-13s%-16s%s","Type","ID","Name","Price","Quantity","Total");
        System.out.println("\n----------------------------------------------------------------------------------");
        if(!order.isEmpty()){
            for(int i =0; i < order.size();i++){
                System.out.format("%s\t| %-1d  \t%-32s$ %5.2f \t%-9d$ %7.2f\n"
                        ,order.get(i).getType(),(idAndQuantityList.get(i)[0][0]+1)
                        ,order.get(i).getName(),order.get(i).getPrice()
                        ,order.get(i).getAmount(),(order.get(i).getPrice()*(double)order.get(i).getAmount())); 
            }
            double total = 0.0;
            double unitPrice = 0.0;
            for(int i =0; i < order.size();i++){
                unitPrice = idAndQuantityList.get(i)[0][1]*order.get(i).getPrice();
                total += unitPrice; 
            }
            System.out.println("----------------------------------------------------------------------------------");
            System.out.format("%72s $ %7.2f\n","Sub Total: ",total);
        }
        else{
            System.out.println("No Item in the cart");
        }
    }
    
    /**
     * This methods makes the cart empty.
     */
    public void checkout(){
        choosePayment();
        displayOrder();
        if(!order.isEmpty()){
            System.out.format("%75s%7s\n","Payment Method: ",paymentMethod);
        }
        order.clear();
    }
    
    /**
     * This method lists out the various payment methods and lets the user select one and then creates and Invoice ID.
     */
    public void choosePayment() {
        if(!order.isEmpty()){
            askPayment();
            System.out.println("1. Cash");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. BitCoin");
            int inInt = 0;
            while (inInt<1 || inInt>4){
                System.out.print("------> Enter a Valid Choice: ");
                inInt = Excptns.invalidInt();
                if (inInt == 1){
                    setPaymentMethod("Cash");
                }
                else if(inInt == 2){
                    setPaymentMethod("Credit");
                }
                else if(inInt == 3){
                    setPaymentMethod("Debit");
                }
                else if(inInt == 4){
                    setPaymentMethod("BitCoin");
                }
            }
            System.out.format("\n%40s%7d","Invoice -",(int)(Math.random()*1000000));
        }
    }
        
    /**
     * This is just the header display for selection.
     */
    private void askPayment() {
        System.out.println("\n--------------------------------------------------------------\n"
                + "\tPlease enter your Payment choice, by selecting a number: "
                + "\n--------------------------------------------------------------");
    }
    
}
