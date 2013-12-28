package com.thevoxelbox.voxelbar;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class VoxelBarListener implements Listener
{
    private VoxelBar plugin;

    public VoxelBarListener(VoxelBar plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onItemHeldChange(PlayerItemHeldEvent event)
    {
        Player player = event.getPlayer();

        if (player.isSneaking())
        {
            if ((player.isOp() || player.hasPermission("voxelbar.use")) && plugin.getConfigurationManager().isScrollingEnabledFor(player))
            {
                int scrollDelta = VoxelBarFunctions.getDelta(event.getPreviousSlot(), event.getNewSlot(), 9);

                if (scrollDelta == 1 || scrollDelta == -1)
                {
                    VoxelBarFunctions.moveInventory(player, scrollDelta * 9);
                }

            }
        }
    }
}
