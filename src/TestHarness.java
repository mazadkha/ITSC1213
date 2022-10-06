import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a system that allows a bookstore owner to keep track of their inventory and members utilizing inheritance and importing data. 
 * @author Mohammad Azad | mazad@uncc.edu
 * Professor - Geoffrey Grimaud
 */
public class TestHarness {
    
    /**
     * Instance of Inventory
     */
    public static Inventory inventory = new Inventory();
    
    /**
     * Main Method
     * @param args strings
     * @throws InterruptedException Time delay
     * @throws FileNotFoundException no file
     */
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        
        // Sample Items
        Item item1 = new Item("Book", "Harry Potter", 19.99, 20);
        Item item2 = new Item("Book", "Madame Bovary", 22.99, 15);
        Item item3 = new Item("Book", "War and Peace", 15.99, 10);
        
        Item item4 = new Item("CD", "What's Going On", 19.99, 20);
        Item item5 = new Item("CD", "Pet Sounds", 22.99, 15);
        Item item6 = new Item("CD", "Songs in the Key of Life", 15.99, 10);
        
        Item item7 = new Item("Dvd", "Spider-Man: No Way Home", 19.99, 20);
        Item item8 = new Item("Dvd", "Judas and the Black Messiah", 22.99, 15);
        Item item9 = new Item("Dvd", "In the Heights", 15.99, 10);
        
        //Sample members
        Member member1 = new Member("free", 84318);
        Member member2 = new Member("premium", 84319, true);
        
        //Items added to inventory.
        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item7);
        inventory.addItem(item8);
        inventory.addItem(item9);
        inventory.addItem(item4);
        inventory.addItem(item5);
        inventory.addItem(item6);
        
        //Members added to inventory
        inventory.addMember(member1);
        inventory.addMember(member2);
        
        Level1_0(); // Calling the level 0 selection
        
    }
    
    /**
     * This method returns a Book item after getting details from the user.
     * @return
     */
    private static Item book(){
        System.out.println("------------------------------\n"
                        + "\tAdding a Book"
                        + "\n------------------------------");
        Item itemBook = itemDetails();
        itemBook.setType("Book");
        return itemBook;
    }
    
    /**
     * This methods saves the item to item list after it has been read from a file.
     * @param type
     * @param name
     * @param price
     * @param amount
     * @return
     */
    private static Item itemFromFile(String type, String name, double price, int amount){
        Item itembook = new Item(type, name, price, amount);
        return itembook;
    }
        
    /**
     * This method returns a cd item after getting details from the user.
     * @return
     */
    private static Item cd(){
        System.out.println("------------------------------\n"
                        + "\tAdding a CD"
                        + "\n------------------------------");
        System.out.println("Enter Details for CD");
        Item itemCD = itemDetails();
        itemCD.setType("CD");
        return itemCD;
    }
   
    /**
     * This method returns a dvd item after getting details from the user.
     * @return
     */
    private static Item dvd(){
        System.out.println("------------------------------\n"
                        + "\tAdding a DVD"
                        + "\n------------------------------");
        System.out.println("Enter Details for DVD");
        Item itemDVD = itemDetails();
        itemDVD.setType("DVD");
        return itemDVD;
    }
    
    /**
     * This method asks the user for details of the Item.
     * @return
     */
    private static Item itemDetails(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scnr.nextLine();
        System.out.print("Price: ");
        double price = Excptns.invalidDouble();
        System.out.print("Total quantity: ");
        int amount = Excptns.invalidInt();
        Item item = new Item(name, price, amount);
        return item;
    }
    
    /**
     * This method adds a free member to the member list after getting details from the user.
     */
    private static void addFreeMember(){
        System.out.println("------------------------------\n"
                        + "\tAdding a Free Membership"
                        + "\n------------------------------");
        System.out.print("Enter member id: ");
        int id = Excptns.invalidInt();
        if(Excptns.checkDuplicateMember(id)){
            
        }
        else{
            Member member = new Member("free", id);
            inventory.addMember(member);
            System.out.println("Member added Successfully");
        }
    }
    
    /**
     * This method adds a premium member to the member list after getting details from the user.
     */
    private static void addPremiumMember(){
        System.out.println("------------------------------\n"
                         + "  Adding a Premium Membership"
                       + "\n------------------------------");
        System.out.print("Enter member id: ");
        int id = Excptns.invalidInt();
        if(Excptns.checkDuplicateMember(id)){
            
        }
        else{
            Member member = new Member("premium", id, true);
            inventory.addMember(member);
            System.out.println("Member added Successfully");
        }
    }
        
    /**
     * This method adds a free member from a file to the member list after getting details from the file.
     * @param membership
     * @param id
     * @return
     */
    private static Member freeMemberFromFile(String membership, int id){
        Member member = new Member(membership, id);
        return member;
    }
    
    /**
     * This method adds a premium member from a file to the member list after getting details from the file.
     * @param membership
     * @param id
     * @param hasPaid
     * @return
     */
    private static Member premiumMemberFromFile(String membership, int id, boolean hasPaid){
        Member member = new Member(membership, id, hasPaid);
        return member;
    }
    
    /**
     * This method asks the user to select from the menu.
     * @throws InterruptedException
     * @throws FileNotFoundException
     */
    private static void Level1_0() throws InterruptedException, FileNotFoundException{
        askSelection();
        System.out.println("1. Inventory");
        System.out.println("2. Order");
        System.out.println("3. Membership");
        System.out.println("4. Exit");
        int inInt = 0;
        while (inInt<1 || inInt>4){
            System.out.print("------> Enter a Valid Choice: ");
            inInt = Excptns.invalidInt();
            if (inInt == 1){
                Level1_1();
            }
            else if(inInt == 2){
                Level1_2();
            }
            else if(inInt == 3){
                Level1_3();
            }
            else if(inInt == 4){
                System.out.println("Thank you for using our shop");
            }
        } 
    }
    
    /**
     * This method asks the user to select from the menu.
     * @throws InterruptedException
     * @throws FileNotFoundException
     */
    private static void Level1_1() throws InterruptedException, FileNotFoundException{
        askSelection();
        System.out.println("1. Display Items");
        System.out.println("2. Add item manually");
        System.out.println("3. Add item from file");
        System.out.println("4. Remove item");
        System.out.println("5. Previous Menu");
        System.out.println("6. Exit");
        double inInt = 0;
        while (inInt<1 || inInt>6){
            System.out.print("------> Enter a Valid Choice: ");
            inInt = Excptns.invalidInt();
            
            if (inInt == 1){
                inventory.displayItems();
                Level1_1();
            }
            else if (inInt == 2){
                Level1_1_1();
            }
            else if(inInt == 3){
                itemFromFile();
                Level1_0();
            }
            else if(inInt == 4){
                inventory.removeItem();
                Level1_0();
            }
            else if(inInt == 5){
                Level1_0();
            }
            else if(inInt == 6){
                System.out.println("Thank you for using our shop");
            }
        }
    }
    
    /**
     * This method asks the user to select from the menu.
     * @throws InterruptedException
     * @throws FileNotFoundException
     */
    private static void Level1_2() throws InterruptedException, FileNotFoundException{
        askSelection();
        System.out.println("1. Add Item to Cart");
        System.out.println("2. View Cart/Order Summary");
        System.out.println("3. Checkout");
        System.out.println("4. Previous Menu");
        System.out.println("5. Exit");
        int inInt = 0;
        while (inInt<1 || inInt>5){
            System.out.print("------> Enter a Valid Choice: ");
            inInt = Excptns.invalidInt();
            if (inInt == 1){
                Order order = new Order();
                order.addToCart();
                Level1_2();
            }
            else if(inInt == 2){
                System.out.format("\n%40s","Cart");
                Order order = new Order();
                order.displayOrder();
                Level1_2();
            }
            else if(inInt == 3){
                Order order = new Order();
                order.checkout();
                Level1_0();
            }
            else if(inInt == 4){
                Level1_0();
            }
            else if(inInt == 5){
                System.out.println("Thank you for using our shop");
            }
        } 
    }
    
    /**
     * This method asks the user to select from the menu.
     * @throws InterruptedException Time delay
     * @throws FileNotFoundException no file
     */
    public static void Level1_1_1() throws InterruptedException, FileNotFoundException{
        askSelection();
        System.out.println("1. Add a Book");
        System.out.println("2. Add a Cd");
        System.out.println("3. Add a Dvd");
        System.out.println("4. Previous Menu");
        System.out.println("5. Exit");
        int inInt = 0;
        while(inInt<1 || inInt>5) {    
            System.out.print("------> Enter a Valid Choice: ");
            inInt = Excptns.invalidInt();
            if (inInt == 1){
                inventory.addItem(book());
                //Thread.sleep(2000);
                Level1_1();
            }
            else if(inInt == 2){
                inventory.addItem(cd());
                //Thread.sleep(2000);
                Level1_1();
            }
            else if(inInt == 3){
                inventory.addItem(dvd());
                //Thread.sleep(2000);
                Level1_1();
            }
            else if(inInt == 4){
                Level1_1();
            }
            else if(inInt == 5){
                System.out.println("Thank you for using our shop");
            }
        }
        
    }
    
    /**
     * This method asks the user to select from the menu.
     * @throws InterruptedException Time delay
     * @throws FileNotFoundException no file
     */
    public static void Level1_1_2() throws InterruptedException, FileNotFoundException{
        askSelection();
        System.out.println("1. Remove an Item");
        System.out.println("2. Remove a Cd");
        System.out.println("3. Remove a Dvd");
        System.out.println("4. Previous Menu");
        System.out.println("5. Exit");
        int inInt=0;
        while(inInt<1 || inInt>5) {    
            System.out.print("------> Enter a Valid Choice: ");
            inInt = Excptns.invalidInt();
            if (inInt == 1){
                inventory.addItem(book());
                //Thread.sleep(2000);
                Level1_1();
            }
            else if(inInt == 2){
                inventory.addItem(cd());
                //Thread.sleep(2000);
                Level1_0();
            }
            else if(inInt == 3){
                inventory.addItem(dvd());
                //Thread.sleep(2000);
                Level1_0();
            }
            else if(inInt == 4){
                Level1_1();
            }
            else if(inInt == 5){
                System.out.println("Thank you for using our shop");
            }
        }
        
    }
    
    /**
     * This method asks the user to select from the menu.
     * @throws InterruptedException
     * @throws FileNotFoundException
     */
    private static void Level1_3() throws InterruptedException, FileNotFoundException{
        askSelection();
        System.out.println("1. Add member Manually");
        System.out.println("2. Add member from file");
        System.out.println("3. Display all members");
        System.out.println("4. Previous menu");
        System.out.println("5. Exit");
        int inInt = 0;
        while (inInt<1 || inInt>5){
            System.out.print("------> Enter a Valid Choice: ");
            inInt = Excptns.invalidInt();
            if (inInt == 1){
                Level1_3_1();
            }
            else if(inInt == 2){
                memberFromFile();
                Level1_3();
            }
            else if(inInt == 3){
                inventory.displayMember();
                Level1_3();
            }
            else if(inInt == 4){
                Level1_0();
            }
            else if(inInt == 5){
                System.out.println("Thank you for using our shop");
            }
        } 
    }
    
    /**
     * This method asks the user to select from the menu.
     * @throws InterruptedException
     * @throws FileNotFoundException
     */
    private static void Level1_3_1() throws InterruptedException, FileNotFoundException{
        askSelection();
        System.out.println("1. Add free member");
        System.out.println("2. Add premium member");
        System.out.println("3. Previous menu");
        System.out.println("4. Exit");
        int inInt = 0;
        while (inInt<1 || inInt>4){
            System.out.print("------> Enter a Valid Choice: ");
            inInt = Excptns.invalidInt();
            if (inInt == 1){
                addFreeMember();
                Level1_3();
            }
            else if(inInt == 2){
                addPremiumMember();
                Level1_3();
            }
            else if(inInt == 3){
                Level1_3();
            }
            else if(inInt == 4){
                System.out.println("Thank you for using our shop");
            }
        } 
    }
    
    /**
     * This is just the header part fro the selection menu.
     */
    private static void askSelection(){
        System.out.println("\n--------------------------------------------------------------\n"
                + "\tPlease enter your choice, by selecting a number: "
                + "\n--------------------------------------------------------------");
    }
    
    /**
     * This method reads the information from a file and passes those 
     * information to item constructor and adds it to item list.
     * @throws FileNotFoundException no file
     */
    public static void itemFromFile() throws FileNotFoundException{
        System.out.print("Enter the file name: ");
        String fileName = Excptns.fileNotFoundExc();
        Scanner input = new Scanner(new File(fileName));
        input.useDelimiter("[^A-Za-z .0-9]+");
        while(input.hasNext()){
            String isItem = input.next();
            if (isItem.equalsIgnoreCase("item")){
                String type = input.next();
                String name = input.next();
                double price = Excptns.stringToDouble(input.next());
                int amount = Excptns.stringToInt(input.next());
                inventory.addItem(itemFromFile(type, name, price, amount));
            }
        }
        inventory.displayItems();
    }
    
    /**
     * This method reads the information from a file and passes those 
     * information to member constructor and adds it to member list.
     * @throws FileNotFoundException no file
     */
    public static void memberFromFile() throws FileNotFoundException{
        System.out.print("Enter the file name: ");
        String fileName = Excptns.fileNotFoundExc();
        Scanner input = new Scanner(new File(fileName));
        input.useDelimiter("[^A-Za-z .0-9]+");
        boolean memberAdded = false;
        while(input.hasNext()){
            String isItem = input.next();
            if (isItem.equalsIgnoreCase("member")){
                String membership = input.next();
                if(membership.equalsIgnoreCase("free")){
                    int memberId = Excptns.stringToInt(input.next());
                    if(Excptns.checkDuplicateMember(memberId));
                    else{
                        inventory.addMember(freeMemberFromFile(membership, memberId));
                        memberAdded = true;
                    }
                }
                else if(membership.equalsIgnoreCase("premium")){
                    int memberId = Excptns.stringToInt(input.next());
                    boolean hasPaid = Boolean.parseBoolean(input.next());
                    if(Excptns.checkDuplicateMember(memberId));
                    else{
                        inventory.addMember(premiumMemberFromFile(membership, memberId, hasPaid));
                        memberAdded = true;
                    }
                }
            }
        }
        if(memberAdded){
            System.out.println("Member Added Successfully");
        }
    }
}
