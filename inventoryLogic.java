import java.io.IOException;

//class for handling the logic between the UI and inventory storage objects 
public class inventoryLogic {
    Inventory inventory = new Inventory();

    public inventoryLogic(){}

    //checks for creating items (duplicate id) and 
    //storing the item into the inventory (inventory space)
    public int saveInventoryEntry(int id, int weight, String sender, String reciever, String desc){
        if(inventory.checkID(id) == -1){
            return -1;
        }
        Item item = new Item(id, weight, sender, reciever, desc);
        if(inventory.addItem(item) == -1){
            return -2;
        }
        return 0;
    }

    //retrieves the most recent item  from the inventory and writes it into the csv file
    public void saveRecentToCSV() throws IOException{
        Item recent = inventory.getRecentItem();
        String[] recentValues = recent.getItemValues();
        CsvWriter.writeCSV(recentValues);
    }
}
