package com.thevoxelbox.voxelbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VoxelBarFunctions
{
    public static final ItemStack[] EMPTY_ITEMSTACK_ARRAY = new ItemStack[] { };

    public static void moveInventory(Player player, int direction)
    {
        List<ItemStack> inventory = new ArrayList<ItemStack>(Arrays.asList(player.getInventory().getContents()));

        Collections.rotate(inventory, direction);

        player.getInventory().setContents(inventory.toArray(EMPTY_ITEMSTACK_ARRAY));
    }

    public static int getDelta(int previousIndex, int newIndex, int maxElements)
    {
        final int nonOverlapping = newIndex - previousIndex;
        final int overlapping = newIndex - maxElements - previousIndex;
        return Math.abs(nonOverlapping) <= Math.abs(overlapping) ? nonOverlapping : overlapping;
    }
}
