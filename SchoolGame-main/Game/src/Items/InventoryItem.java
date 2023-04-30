package Items;

/**
 * Inventory item, combines quantity and item type
 */
public class InventoryItem {
    public Item type;
    public byte quantity;

    public InventoryItem(Item type, byte quantity){
        this.type = type;
        this.quantity = quantity;
    }

    public boolean isFull() {
        return quantity == 64;
    }
}
