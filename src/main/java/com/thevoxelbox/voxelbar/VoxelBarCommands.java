package com.thevoxelbox.voxelbar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoxelBarCommands implements CommandExecutor {
    private VoxelBar plugin;
    public VoxelBarCommands(VoxelBar plugin) {
        this.plugin = plugin;
    }
    
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You cannot use VoxelBar from the console!");
            return true;
        }
        
        Player player = (Player) commandSender;
        String argument;
        
        if (args.length == 0) {
            player.sendMessage(helpMessage());
            return true;
        }
        
        argument = args[0];
        
        if (argument.equalsIgnoreCase("enable") || argument.equalsIgnoreCase("on") || argument.equalsIgnoreCase("e")) {
            VoxelBarFunctions.enableCommand(plugin, player);
            return true;
        } else if (argument.equalsIgnoreCase("disable") || argument.equalsIgnoreCase("off") || argument.equalsIgnoreCase("d")) {
            VoxelBarFunctions.disableCommand(plugin, player);
            return true;
        } else if (argument.equalsIgnoreCase("scroll") || argument.equalsIgnoreCase("s")) {
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

