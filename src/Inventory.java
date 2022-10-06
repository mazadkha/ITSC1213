import java.util.ArrayList;
/**
 * This class takes care of the entire inventory of products and members in this project.
 * @author Mohammad Azad | mazad@uncc.edu
 * Professor - Geoffrey Grimaud
 */
public class Inventory {
    
    //fields for storing items and members.

    /**
     * this list will hold the list of all the items
     */
    private static ArrayList<Item> items = new ArrayList<>();

    /**
     * this list will hold all the members
     */
    private static ArrayList<Member> member = new ArrayList<>();

    /**
     * this method returns the item list
     * @return ArrayList this list will be the list of items
     */
    public  ArrayList<Item> getItems() {
        return items;
    }

    /**
     * this method will return list of the members
     * @return ArrayList the list of members
     */
    public ArrayList<Member> getMember() {
        return member;
    }

    /**
     * this method sets the item list to the list passed in the parameter
     * @param items an ArrayList of items
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * this method sets the member list to the list passed in the parameter
     * @param member an ArrayList of members
     */
    public void setMember(ArrayList<Member> member) {
        this.member = member;
    }
    
    /**
     * this method adds a number to the member list
     * @param member A member object
     */
    public void addMember(Member member){
        this.member.add(member);
    }
    
    /**
     * this method adds an item to the item list
     * @param item an item object
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * this message removes an item by asking the user, the item ID.
     */
    public void removeItem(){
        displayItems();
        int n = -1;
        System.out.println("------------------------------\n"
                                +"\tRemoving an Item"
                       + "\n------------------------------");
        if(items.size()>0){
            while(n<0 || n > items.size()){
                System.out.print("------> Look up the Item List & Enter a Valid item ID: ");
                n = Excptns.invalidInt();
                
            }
        System.out.println("Removed: "+items.get(n-1).getType()+" - "+items.get(n-1).getName());
        items.remove(n-1);
        displayItems();
        }
        else{
            System.out.println("There is no item to be removed");
        }
    }

    /**
     * this method displays all the items in the item list in a table format.
     */
    public void displayItems() {
        insertionSortItems();
        System.out.format("\n%32s","Items");
        System.out.println("\n---------------------------------------------------------------------");
        System.out.format("%-9s%-1s\t%-32s%-13s%s","Type","ID","Name","Price","In Stock");
        System.out.println("\n---------------------------------------------------------------------");
        if(!items.isEmpty()){
            for(int i =0; i < items.size();i++){
                System.out.format("%s\t| %-1d \t%-32s$ %5.2f%10d\n",items.get(i).getType(),(i+1),items.get(i).getName(),items.get(i).getPrice(),items.get(i).getAmount()); 
            }
        }
        else{
            System.out.println("There are no Items to be displayed, add Item");
        }
    }
        
    /**
     * this is a insertion sort method to sort the items according to their type.
     */
    public void insertionSortItems(){
        ArrayList<Item> temp = new ArrayList<>();
        if (!items.isEmpty()){
            for (int i = 0; i < items.size()-1; i++){
                int pointer = i;
                while(pointer > 0 && ((items.get(pointer).getType().compareToIgnoreCase(items.get(pointer+1).getType()))>0)){
                    temp.add(0, items.remove(pointer+1));
                    //temp[0] = orderList.remove(pointer-1);
                    items.add(pointer, temp.get(0));
                    pointer--;
                }
            }
       }
    }
    
    /**
     * this method displays all member in the table format.
     */
    public void displayMember() {
        insertionSortMembers();
        System.out.format("\n%22s","Members");
        System.out.println("\n-----------------------------------------");
        System.out.format("%-20s%-15s%s","Membersip Type","ID","Paid");
        System.out.println("\n-----------------------------------------");
        if(!member.isEmpty()){
            for(int i =0; i < member.size();i++){
                if (member.get(i).getType().equalsIgnoreCase("free")){
                    System.out.format("  %-18s%-15d%s\n", member.get(i).getType(), member.get(i).getId(),"-");
                }
                else if (member.get(i).getType().equalsIgnoreCase("premium")){
                    System.out.format("  %-18s%-15d%b\n", member.get(i).getType(), member.get(i).getId(), member.get(i).isHasPaid());
                }
            }
        }
        else{
            System.out.println("There are no Member to be displayed, add Member");
        }
    }
    
    /**
     * this is insertion sort method to sort all the members according to their type.
     */
    public void insertionSortMembers(){
        ArrayList<Member> temp = new ArrayList<>();
        if (!member.isEmpty()){
            for (int i = 0; i < member.size()-1; i++){
                int pointer = i;
                while(pointer > 0 && ((member.get(pointer).getType().compareToIgnoreCase(member.get(pointer+1).getType()))>0)){
                    temp.add(0, member.remove(pointer+1));
                    //temp[0] = orderList.remove(pointer-1);
                    member.add(pointer, temp.get(0));
                    pointer--;
                }
            }
       }
    }
    
    
}
