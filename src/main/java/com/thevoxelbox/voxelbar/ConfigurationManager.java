package com.thevoxelbox.voxelbar;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * @author MikeMatrix
 */
public class ConfigurationManager
{
    private static final String PLAYER_CONFIG_BASE_PATH = "players.";
    private static boolean SCROLLING_ENABLED_DEFAULT = false;
    private final File configurationFile;
    private FileConfiguration configuration;

    public ConfigurationManager(final FileConfiguration configuration, File configurationFile)
    {
        this.configuration = configuration;
        this.configurationFile = configurationFile;
    }

    public final boolean isScrollingEnabledFor(Player player)
    {
        return configuration.getBoolean(PLAYER_CONFIG_BASE_PATH + player.getName(), SCROLLING_ENABLED_DEFAULT);
    }

    public final void setScrollingEnabledFor(Player player, boolean scrollingEnabled)
    {
        configuration.set(PLAYER_CONFIG_BASE_PATH + player.getName(), scrollingEnabled);
        this.saveConfiguration();
    }

    public final void saveConfiguration()
    {
        try
        {
            configuration.save(configurationFile);
        }
        catch (IOException e)
        {
        }
    }
}
