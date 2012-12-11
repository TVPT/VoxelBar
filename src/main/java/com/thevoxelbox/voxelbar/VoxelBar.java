package com.thevoxelbox.voxelbar;

import org.bukkit.plugin.java.JavaPlugin;

public class VoxelBar extends JavaPlugin {

    
    @Override
    public void onDisable() {  
        VoxelBarFunctions.savePlayers();
    }
    @Override
    public void onEnable() {
        
        getServer().getPluginManager().registerEvents(new VoxelBarListener(), this); // Register VoxelBarListener
        
        getCommand("vbar").setExecutor(new VoxelBarCommands()); // Register VoxelBarCommands

        

        saveDefaultConfig();
        
        VoxelBarFunctions.loadPlayers();
        
    }

    
}

