//inventory class to facilitate the storage of multiple items
public class Inventory {
    private Item[] items;
    private int index;
    private final int MAX_INVENTORY_ITEMS = 20;

    public Inventory(){
        items = new Item[MAX_INVENTORY_ITEMS];
        index = 0;
    }

    // Add an item to the inventory array
    // 0 for succesful add, -1 for out of space
    public int addItem(Item item){
        if(index < MAX_INVENTORY_ITEMS){
            items[index] = item;
            index++;
            return 0;
        }
        return -1;
    }
    
    //checks for duplicate id
    //-1 for duplicate spotted
    //0 for no duplicate spotted
    public int checkID(int ID){
        if(index > 0){
            for(int i = 0; i < index;i++){
                if(items[i].getId() == ID){
                    return -1;
                }
            }
        }
        return 0;
    }

    //returns most recent item
    public Item getRecentItem(){
        return items[index-1];
    }
}
