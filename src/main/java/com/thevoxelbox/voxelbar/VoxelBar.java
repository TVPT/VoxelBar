package com.thevoxelbox.voxelbar;

import org.bukkit.plugin.java.JavaPlugin;

public class VoxelBar extends JavaPlugin {
    
    public VoxelBarToggleManager tm = new VoxelBarToggleManager(this);
    
    @Override
    public void onDisable() {  
        tm.savePlayers();
    }
    @Override
    public void onEnable() {
        
        getServer().getPluginManager().registerEvents(new VoxelBarListener(), this); // Register VoxelBarListener
        
        getCommand("vbar").setExecutor(new VoxelBarCommands()); // Register VoxelBarCommands

        

        saveDefaultConfig();
        
        tm.loadPlayers();
        
    }

    
}

