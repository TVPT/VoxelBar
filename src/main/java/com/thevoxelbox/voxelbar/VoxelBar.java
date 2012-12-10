package com.thevoxelbox.voxelbar;

import java.util.*;
import org.bukkit.plugin.java.JavaPlugin;

public class VoxelBar extends JavaPlugin {
    private static VoxelBar instance;
    
    public static VoxelBar getInstance() {
        return instance;
    }
    
    @Override
    public void onDisable() {  
        VoxelBarToggleManager.savePlayers(); // save player settings to config
    }
    @Override
    public void onEnable() {
        
        getServer().getPluginManager().registerEvents(new VoxelBarListener(), this); // Register VoxelBarListener
        
        getCommand("vbar").setExecutor(new VoxelBarCommands()); // Register VoxelBarCommands
        
        getConfig().addDefault("players.test", true);
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        VoxelBarToggleManager.loadPlayers(); // Load players settings from the config
        
    }
    
}

