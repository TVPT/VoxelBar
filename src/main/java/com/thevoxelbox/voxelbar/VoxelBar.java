package com.thevoxelbox.voxelbar;

import org.bukkit.plugin.java.JavaPlugin;

public class VoxelBar extends JavaPlugin {

    private static final String PLAYERS_CONFIG_PATH = "players.";

    public boolean isEnabled(final String player) {
        if (this.getConfig().contains(PLAYERS_CONFIG_PATH + player)) {
            return this.getConfig().getBoolean(PLAYERS_CONFIG_PATH + player);
        }
        return false;
    }

    @Override
    public void onDisable() {
        this.saveConfig();
    }

    @Override
    public void onEnable() {
        // Register VoxelBarListener
        this.getServer().getPluginManager().registerEvents(new VoxelBarListener(this), this); 
        
        // Register VoxelBarCommands
        this.getCommand("voxelbar").setExecutor(new VoxelBarCommands(this));

        // create config if not created already
        this.saveDefaultConfig();
    }

    /**
     * Sets the Status of a player.
     * 
     * @param player
     * @param value
     */
    public void setStatus(final String player, final boolean value) {
        this.getConfig().set(PLAYERS_CONFIG_PATH + player, value);
        this.saveConfig();
    }

}
