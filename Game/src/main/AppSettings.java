package main;

import java.awt.Color;

/**
 *  Class contains all constant settings so those don't bloat the code
 */
public class AppSettings {
    public static final int inventoryMargin = 50;
    public static final int inventorySlots = 9;
    public static final int inventorySlotSize = 64;
    public static final int inventorySlotMargin = 5;
    public static final int inventorySlotPadding = inventorySlotSize / 8;
    public static final int inventoryInitialSlot = 0;
    public static final int numberFontSize = inventorySlotSize / 4;


    public static final Color inventoryBackgroundColor = new Color(0, 0, 0, 64);
    public static final Color inventoryCursorColor = Color.white;
}
