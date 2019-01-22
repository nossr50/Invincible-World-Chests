package com.gmail.nossr50.invincibleworldchests;

import org.bukkit.event.Cancellable;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.loot.Lootable;

public class ChestUtils {

    public static void preventBreakingLootableInventoryBlock(InventoryHolder inventoryHolder, Cancellable event) {
        if(inventoryHolder instanceof Lootable)
        {
            Lootable lootable = (Lootable) inventoryHolder;

            //Don't Allow this block to be broken
            if(lootable.getLootTable() != null)
                event.setCancelled(true);
        }
    }
}
