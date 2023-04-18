import java.io.IOException;

public class inventoryLogic {
    Inventory inventory = new Inventory();

    public inventoryLogic(){}

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

    public void saveRecentToCSV() throws IOException{
        Item recent = inventory.getRecentItem();
        String[] recentValues = recent.getItemValues();
        CsvWriter.writeCSV(recentValues);
    }
}
