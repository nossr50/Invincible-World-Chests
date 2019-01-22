package com.gmail.nossr50.invincibleworldchests.listeners;

import com.gmail.nossr50.invincibleworldchests.ChestUtils;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;

/**
 * Listen for custom events
 */
public class CustomListener implements Listener {
    private Plugin plugin;

    public CustomListener(Plugin plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreakEvent(BlockBreakEvent event)
    {
        if(event.getBlock().getState() instanceof InventoryHolder)
            ChestUtils.preventBreakingInventoryWithLootTable((InventoryHolder) event.getBlock().getState(), event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageEvent(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Block)
        {
            Block block = (Block) event.getEntity();
            if(block.getState() instanceof InventoryHolder)
                ChestUtils.preventBreakingInventoryWithLootTable((InventoryHolder) block.getState(), event);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void OnVehicleDestroy(VehicleDestroyEvent event)
    {
        if(event.getVehicle() instanceof InventoryHolder)
        {
            //Minecarts
            ChestUtils.preventBreakingInventoryWithLootTable((InventoryHolder) event.getVehicle(), event);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if(event.getClickedBlock() != null && event.getClickedBlock().getState() != null)
        {
            BlockState blockState = (BlockState) event.getClickedBlock().getState();
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockDamageEvent(BlockDamageEvent event)
    {
        if(event.getBlock().getState() instanceof InventoryHolder)
            ChestUtils.preventBreakingInventoryWithLootTable((InventoryHolder) event.getBlock().getState(), event);
    }
}
