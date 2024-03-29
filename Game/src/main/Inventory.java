package main;


import Items.InventoryItem;
import Items.Item;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


/**
 * Inventory class
 * Contains methods for drawing inventory UI and managing content
 */
public class Inventory {
    public final GamePanel gp;

    // Dimensions
    private final int totalWidth;
    private final int totalHeight;
    private final int itemSize;


    // Positions
    private final int positionX;
    private final int positionY;
    private final int slotPositionY;
    private final int itemPositionY;

    // Control variables
    private int selectedSlotIndex;
    private BufferedImage slotImage;
    private final InventoryItem[] slotContents;

    private final boolean[] slotUsed = new boolean[9];
    public int speedBuff = 0;
    public int heartBuff = 0;

    public Inventory(GamePanel gp) {
        this.gp = gp;
        this.selectedSlotIndex = AppSettings.inventoryInitialSlot;

        // Calculate dimensions
        this.totalWidth = AppSettings.inventorySlots * AppSettings.inventorySlotSize + (AppSettings.inventorySlots + 1) * AppSettings.inventorySlotMargin;
        this.totalHeight = AppSettings.inventorySlotSize + 2 * AppSettings.inventorySlotMargin;
        this.itemSize = AppSettings.inventorySlotSize - 2 * AppSettings.inventorySlotPadding;

        // Calculate positions
        this.positionX = (gp.getScreenWidth() - totalWidth) / 2;
        this.positionY = gp.getScreenHeight() - AppSettings.inventoryMargin - AppSettings.inventorySlotSize;
        this.slotPositionY = this.positionY + AppSettings.inventorySlotMargin;
        this.itemPositionY = this.slotPositionY + AppSettings.inventorySlotPadding;

        try {
            this.slotImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/hud/inventory_slot.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.slotContents = new InventoryItem[AppSettings.inventorySlots];
    }

    /**
     * Select a specified inventory slot
     * Used when to select item when a number key is pressed
     */
    public void selectSlot(int index) {
        this.selectedSlotIndex = index;
    }

    /**
     * Increase the index of selected slot
     * Used with scroll wheel
     */
    public void increaseSlot() {
        this.selectedSlotIndex = Math.floorMod(this.selectedSlotIndex + 1, AppSettings.inventorySlots);
    }

    /**
     * Decrease the index of selected slot
     * Used with scroll wheel
     */
    public void decreaseSlot() {
        this.selectedSlotIndex = Math.floorMod(this.selectedSlotIndex - 1, AppSettings.inventorySlots);
    }

    /**
     * Insert item at the first free inventory slot or stack
     */
    public void addItem(Item item) {
        if(item.id == 4) { heartBuff += item.hearts; }
        for (int i = 0; i < AppSettings.inventorySlots; i++) {
            if(slotUsed[i]) {
                if (slotContents[i].itemID == item.id && !slotContents[i].isFull()) {
                    slotContents[i].quantity++;
                    break;
                }
            }
            else if (slotContents[i] == null) {
                slotContents[i] = new InventoryItem(item, (byte) 1);
                slotUsed[i] = true;
                if(item.id == 3) { speedBuff += item.speed; }
                break;
            }
        }
    }

    /**
     * Retrieve an item from stack
     */
    public void retrieveItem(){

        InventoryItem slotContent = slotContents[this.selectedSlotIndex];
        if(slotContent.itemID == 4) { heartBuff -= slotContent.type.hearts; }
        Item item;

        item = slotContent.type;
        if(item.id == 3) { speedBuff -= item.speed; }
        if(slotContent.quantity == 1){
            slotContents[this.selectedSlotIndex] = null;
            slotUsed[this.selectedSlotIndex] = false;
        } else {
            slotContent.quantity--;
        }

    }

    /**
     * Peeks for the type of Item selected
     */

    public Item peekItem(){
        InventoryItem slotContent = slotContents[this.selectedSlotIndex];
        Item item = null;
        if(slotContent!=null) {
            item = slotContents[this.selectedSlotIndex].type;
        }
        return item;

    }

    /**
     * Draw all parts of the inventory onto screen
     */
    public void draw(Graphics2D g2) {
        drawFrame(g2);
        drawCursor(g2);
        drawItems(g2);
    }

    /**
     * Draw inventory background and slot frames
     */
    private void drawFrame(Graphics2D g2) {
        // Draw inventory background
        g2.setColor(AppSettings.inventoryBackgroundColor);
        g2.fillRect(this.positionX, this.positionY, this.totalWidth, this.totalHeight);

        // Render all inventory boxes
        for (int i = 0; i < AppSettings.inventorySlots; i++) {
            final int offsetX = i * AppSettings.inventorySlotSize + (i + 1) * AppSettings.inventorySlotMargin;
            g2.drawImage(this.slotImage, this.positionX + offsetX, this.slotPositionY, AppSettings.inventorySlotSize, AppSettings.inventorySlotSize, null);
        }
    }

    /**
     * Draw cursor around the selected inventory slot
     */
    private void drawCursor(Graphics2D g2) {
        g2.setColor(AppSettings.inventoryCursorColor);
        g2.setStroke(new BasicStroke(4f));

        final int offsetX = selectedSlotIndex * AppSettings.inventorySlotSize + (selectedSlotIndex + 1) * AppSettings.inventorySlotMargin;
        g2.drawRect(positionX + offsetX, positionY + AppSettings.inventorySlotMargin, AppSettings.inventorySlotSize, AppSettings.inventorySlotSize);
    }

    /**
     * Draw inventory items
     */
    private void drawItems(Graphics2D g2) {
        // Draw icon images and quantity
        for (int i = 0; i < AppSettings.inventorySlots; i++) {
            final int offsetX = i * AppSettings.inventorySlotSize + (i + 1) * AppSettings.inventorySlotMargin + AppSettings.inventorySlotPadding;

            if (slotContents[i] != null) {
                g2.drawImage(slotContents[i].type.img, this.positionX + offsetX, this.itemPositionY, this.itemSize, this.itemSize, null);

                g2.setFont(new Font(null, Font.BOLD, AppSettings.numberFontSize));
                g2.drawString(String.valueOf(slotContents[i].quantity), this.positionX + offsetX, this.itemPositionY + itemSize);
            }
        }
    }
}