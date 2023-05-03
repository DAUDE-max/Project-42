package Items;

/**
 * Inventory item, combines quantity and item type
 */
public class InventoryItem {
    public Item type;
    public byte quantity;
    public int itemID;

    public InventoryItem(Item type, byte quantity, int itemID){
        this.type = type;
        this.quantity = quantity;
        this.itemID = itemID;
    }

    public boolean isFull() {
        return quantity == 64;
    }
}
