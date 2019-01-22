package com.gmail.nossr50.invincibleworldchests;

import com.gmail.nossr50.invincibleworldchests.listeners.CustomListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Makes chests spawned in the world invincible
 */
public class InvincibleWorldChests extends JavaPlugin {

    public static InvincibleWorldChests p;

    @Override
    public void onEnable() {
        super.onEnable();

        getServer().getPluginManager().registerEvents(new CustomListener(this), this);
        getLogger().info("Invincible World Chests has loaded.");

        p = this;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("Invincible World Chests has been disabled.");
    }
}
