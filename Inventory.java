public class Inventory {
    private Item[] items;
    private int index;

    public Inventory(){
        items = new Item[20];
        index = 0;
    }

    /* Add an item to the inventory array
     * returns: 
     * 0 on success
     * -1 on duplicate ID
     * -2 on out of space
     */
    public int addItem(Item item){
        if(index > 0){
            for(int i = 0; i < index;i++){
                if(items[i].getId() == item.getId()){
                    return -1;
                }
            }
        }

        if(index < 20){
            items[index] = item;
            index++;
            return 0;
        }
        
        return -2;
    }   
}
