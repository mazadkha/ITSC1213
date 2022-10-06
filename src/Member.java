/**
 * This class maintains the list of the members which are free and premium and creates new member through files.
 * @author Mohammad Azad | mazad@uncc.edu
 * Professor - Geoffrey Grimaud
 */
public class Member {
    
    // fields for the members with following details or information.
    private String type;
    private int id;
    private boolean hasPaid;

    /**
     * constructor with two perimeter
     * @param type string 
     * @param id integer
     */
    public Member(String type, int id) {
        this.type = type;
        this.id = id;
    }

    /**
     * Constructor with three parameter
     * @param type string
     * @param id integer
     * @param hasPaid boolean
     */
    public Member(String type, int id, boolean hasPaid) {
        this.type = type;
        this.id = id;
        this.hasPaid = hasPaid;
    }

    /**
     * this method gets the type of the member
     * @return string type
     */
    public String getType() {
        return type;
    }

    /**
     * this method gets the ID of the member
     * @return integer type
     */
    public int getId() {
        return id;
    }

    /**
     * this method gets true or false if the member has paid or no.
     * @return boolean type
     */
    public boolean isHasPaid() {
        return hasPaid;
    }

    /**
     * this method sets the type of the member
     * @param type string
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * this method sets the ID of the member
     * @param id integer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * this method sets true or false if the member has paid or no.
     * @param hasPaid boolean
     */
    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    /**
     * Display the members list.
     * @return string
     */
    @Override
    public String toString() {
        return "Member{" + "type=" + type + ", id=" + id + ", hasPaid=" + hasPaid + '}';
    }
    
    
    
}
