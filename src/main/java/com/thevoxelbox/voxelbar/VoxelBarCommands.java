package com.thevoxelbox.voxelbar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoxelBarCommands implements CommandExecutor {
    private VoxelBar vb;
    public VoxelBarCommands(VoxelBar vbp) {
        vb = vbp;
    }
    
    public boolean onCommand(CommandSender cs, Command cmnd, String label, String[] args) {
        
        if (!(cs instanceof Player)) {
            cs.sendMessage("You cannot use VoxelBar from the console!");
            return true;
        }
        
        Player player = (Player) cs;
        String command;
        
        if (args.length == 0) {
            player.sendMessage(helpMessage());
            return true;
        }
        
        command = args[0];
        
        if (command.equalsIgnoreCase("enable") || command.equalsIgnoreCase("on") || command.equalsIgnoreCase("e")) {
            VoxelBarFunctions.enableCommand(vb, player);
            return true;
        } else if (command.equalsIgnoreCase("disable") || command.equalsIgnoreCase("off") || command.equalsIgnoreCase("d")) {
            VoxelBarFunctions.disableCommand(vb, player);
            return true;
        } else if (command.equalsIgnoreCase("scroll") || command.equalsIgnoreCase("s")) {
            VoxelBarFunctions.scrollCommand(player, args);
            return true;
        }
        player.sendMessage(helpMessage());
        return true;
    }
    
    public String helpMessage() {
        String help = "";
        help += ChatColor.GREEN +     "===================[VoxelBar]===================          ";
        help += ChatColor.GREEN +     "/vbar                                                         \n";
        help += ChatColor.GREEN +     "    - Shows this help message                                 \n\n";
        help += ChatColor.GREEN +     "/vbar on                                                      \n";
        help += ChatColor.GREEN +     "    - Enables scrolling through your inventory by crouching   \n\n";
        help += ChatColor.GREEN +     "/vbar off                                                     \n";
        help += ChatColor.GREEN +     "    - Disables scrolling through your inventory by crouching  \n\n";
        help += ChatColor.GREEN +     "/vbar scroll [+/-]                                            \n";
        help += ChatColor.GREEN +     "    - Scroll your inventory up/down                           \n";
        help += ChatColor.GREEN +     "===============================================          \n";
        return help;
        
    }
    
}

