package com.thevoxelbox.voxelbar;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class VoxelBar extends JavaPlugin {
    
    private YamlConfiguration config;
    
    @Override
    public void onEnable() {
        
        getServer().getPluginManager().registerEvents(new VoxelBarListener(this), this); // Register VoxelBarListener
        
        getCommand("voxelbar").setExecutor(new VoxelBarCommands(this)); // Register VoxelBarCommands
        
        saveDefaultConfig(); // create config if not created already
        
        config = (YamlConfiguration) getConfig();
        
        
    }
    
    @Override
    public void onDisable() {
        reloadConfig();
    }
    
    public boolean isEnabled(String player) {
        if (config.contains("players." + player)) {
            return config.getBoolean(player);
        }
        return true;
        
    }
    
    public void setStatus(String player, boolean value) {
        getConfig().set("players." + player, value);
        saveConfig();
    }
    
}



