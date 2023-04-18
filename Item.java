//item class for item object and attributes
public class Item {
    private int id;
    private int weight;
    private String sender;
    private String reciever;
    private String description;

    public Item(int id, int weight, String sender, String reciever, String desc){
        this.id = id;
        this.weight = weight;
        this.sender = sender;
        this.reciever = reciever;
        this.description = desc;
    }

    //returns all values of the item as a String array
    public String[] getItemValues(){
        String[] values = new String[5];
        values[0] = String.valueOf(this.id);
        values[1] = String.valueOf(this.weight);
        values[2] = this.sender;
        values[3] = this.reciever;
        values[4] = this.description;
        return values;
    }

    //returns int id for the current item object
    public int getId(){
        return this.id;
    }
}
