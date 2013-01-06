package com.thevoxelbox.voxelbar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandVoxelBarExecutor implements CommandExecutor
{
    private static final String HELP_TEXT = ChatColor.GOLD + "[VoxelBar Help]\n" +
            ChatColor.GREEN + "/vbar\n" +
            ChatColor.WHITE + "    - Shows this help message\n\n" +
            ChatColor.GREEN + "/vbar [on|off]\n" +
            ChatColor.WHITE + "    - Enables/Disables scrolling by crouching\n\n" +
            ChatColor.GREEN + "/vbar scroll [+|-]\n" +
            ChatColor.WHITE + "    - Scroll your inventory up/down";
    private final VoxelBar plugin;

    public CommandVoxelBarExecutor(VoxelBar plugin)
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
    {
        if (!(commandSender instanceof Player))
        {
            commandSender.sendMessage("You cannot use VoxelBar from the console!");
            return true;
        }

        Player player = (Player) commandSender;

        if (args == null || args.length == 0)
        {
            player.sendMessage(HELP_TEXT);
            return true;
        }

        String argument = args[0];

        if (argument.equalsIgnoreCase("enable") || argument.equalsIgnoreCase("on") || argument.equalsIgnoreCase("e"))
        {
            plugin.getConfigurationManager().setScrollingEnabledFor(player, true);
            player.sendMessage(ChatColor.GREEN + "VoxelBar enabled for you - " + ChatColor.DARK_AQUA + "/" + label + " off" + ChatColor.GREEN + " to turn it off again!");
            return true;
        }
        else if (argument.equalsIgnoreCase("disable") || argument.equalsIgnoreCase("off") || argument.equalsIgnoreCase("d"))
        {
            plugin.getConfigurationManager().setScrollingEnabledFor(player, false);
            player.sendMessage(ChatColor.GREEN + "VoxelBar disabled for you - " + ChatColor.DARK_AQUA + "/" + label + " on" + ChatColor.GREEN + " to turn it on again!");
            return true;
        }
        else if (argument.equalsIgnoreCase("scroll") || argument.equalsIgnoreCase("s"))
        {
            if (args.length == 1 || args[1].equals("+"))
            {
                VoxelBarFunctions.moveInventory(player, 9);
                player.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.DARK_AQUA + "upwards");
            }
            else if (args[1].equals("-"))
            {
                VoxelBarFunctions.moveInventory(player, -9);
                player.sendMessage(ChatColor.GREEN + "You moved your inventory " + ChatColor.GOLD + "downwards");
            }
            else
            {
                player.sendMessage(ChatColor.GREEN + "Unknown scroll direction.");
            }
            return true;
        }

        player.sendMessage(HELP_TEXT);
        return true;
    }

}

