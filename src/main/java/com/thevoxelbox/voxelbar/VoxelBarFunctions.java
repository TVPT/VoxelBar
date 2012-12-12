package com.thevoxelbox.voxelbar;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class VoxelBarFunctions {
    
    public static void moveInventory(Player p, boolean down) {
        PlayerInventory i = p.getInventory();
        
        ItemStack[] inv = i.getContents();
        ItemStack[] temp = new ItemStack[inv.length];
        
        int direction = down ? 9 : -9;
        
        for (int x = 0; x < temp.length; x++) {
            temp[((x + direction < 0) ? x + direction + temp.length : (x + direction >= temp.length ? x + direction - temp.length : x + direction))] = inv[x];
        }
        
        i.setContents(temp);
    }
    
    public static void enableCommand(VoxelBar vb, Player player) {
        if (vb.isEnabled(player.getName())) {
            player.sendMessage(ChatColor.GREEN + "VoxelBar already enabled for you! Type " + ChatColor.DARK_AQUA + "/vbar off" + ChatColor.GREEN + " to disable VoxelBar!");
        } else {
            vb.setStatus(player.getName(), true);
            player.sendMessage(ChatColor.GREEN + "VoxelBar enabled for you - " + ChatColor.DARK_AQUA + "/vbar off" + ChatColor.GREEN + " to turn it off again!");
        }
    }
    
    public static void disableCommand(VoxelBar vb, Player player) {
        if (vb.isEnabled(player.getName())) {
            vb.setStatus(player.getName(), false);
            player.sendMessage(ChatColor.GREEN + "VoxelBar disabled for you - " + ChatColor.DARK_AQUA + "/vbar on" + ChatColor.GREEN + " to turn it on again!");
        } else {
            player.sendMessage(ChatColor.GREEN + "VoxelBar already disabled for you! Type " + ChatColor.DARK_AQUA + "/vbar on" + ChatColor.GREEN + " to enable VoxelBar!");
        }
    }
    
    public static void scrollCommand(Player player, String[] args) {
        if (args.length == 1) {
            moveInventory(player, false);
            player.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.RESET + ChatColor.UNDERLINE + ChatColor.DARK_AQUA +"upwards");
        } else if (args[1].equals("+")) {
            moveInventory(player, false);
            player.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.RESET + ChatColor.UNDERLINE + ChatColor.DARK_AQUA +"upwards");
        } else if (args[1].equals("-")) {
            moveInventory(player, true);
            player.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.RESET + ChatColor.UNDERLINE + ChatColor.GOLD +"downwards");
        } else if (args.length > 3) {
            moveInventory(player, true);
            player.sendMessage(ChatColor.RED + "No correct direction found! Please use \"+\" for scrolling forwards and \"-\" for scrolling downwards!");
        } else {
            moveInventory(player, false);
            player.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.RESET + ChatColor.UNDERLINE + ChatColor.DARK_AQUA +"upwards");
        }
        
    }
    
}
