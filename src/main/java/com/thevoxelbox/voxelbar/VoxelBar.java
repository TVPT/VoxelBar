package com.thevoxelbox.voxelbar;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class VoxelBar extends JavaPlugin
{
    private ConfigurationManager configurationManager;

    @Override
    public void onDisable()
    {
        this.saveConfig();
    }

    @Override
    public void onEnable()
    {
        this.configurationManager = new ConfigurationManager(getConfig(), new File(getDataFolder(), "config.yml"));

        this.getServer().getPluginManager().registerEvents(new VoxelBarListener(this), this);

        this.getCommand("voxelbar").setExecutor(new CommandVoxelBarExecutor(this));
    }

    public ConfigurationManager getConfigurationManager()
    {
        return configurationManager;
    }
}
