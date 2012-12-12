package com.thevoxelbox.voxelbar;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class VoxelBarListener implements Listener {
    private VoxelBar vb;
    public VoxelBarListener(VoxelBar vbp) {
        vb = vbp;
    }
    
    @EventHandler
    public void onItemHeldChange(PlayerItemHeldEvent event) {
        int difference = event.getPreviousSlot() - event.getNewSlot();
        Player p = event.getPlayer();
        if ((p.isSneaking())) {
            if ((difference == 1) || (difference == -8)) {
                if (p.isOp() || p.hasPermission("voxelbar.use")) {
                    if (vb.isEnabled(p.getName())) {
                        VoxelBarFunctions.moveInventory(p, false);
                        p.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.RESET + ChatColor.UNDERLINE + ChatColor.DARK_AQUA +"upwards");
                    }
                }
            } else if ((difference == -1) || (difference == 8)) {
                if (p.isOp() || p.hasPermission("voxelbar.use")) {
                    if (vb.isEnabled(p.getName())) {
                        VoxelBarFunctions.moveInventory(p, true);
                        p.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.RESET + ChatColor.UNDERLINE + ChatColor.GOLD +"downwards");
                    }
                }
            }
        }
    }
}
