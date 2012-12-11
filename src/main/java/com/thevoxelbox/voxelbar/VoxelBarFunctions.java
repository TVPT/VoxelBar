package com.thevoxelbox.voxelbar;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class VoxelBarFunctions {
    private static VoxelBar vb = new VoxelBar();
    private static HashMap<String, Boolean> playersEnabled = new HashMap();
    
    public static void setStatus(String player, boolean val) {
        playersEnabled.put(player, val);
   
    }
    public static void savePlayers() {
        for (String p : playersEnabled.keySet()) {
            vb.getConfig().set("players." + p, playersEnabled.get(p));
        }
        vb.saveConfig();
    }
    public static void loadPlayers() {
        if (vb.getConfig().contains("players")) {
            for (String p : vb.getConfig().getStringList("players")) {
                playersEnabled.put(p, vb.getConfig().getBoolean("players." + p, false));
            }
        }
    }
    
    public static boolean isEnabled(String player) {
        if (playersEnabled.containsKey(player)) {
            return playersEnabled.get(player);
        }
        return true;
    }
    
    public static void moveInventory(Player player, int rows) {
        PlayerInventory inv = player.getInventory();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 9; j++) {
                ItemStack[] orginv = { inv.getItem(j), inv.getItem(j + 27), inv.getItem(j + 18), inv.getItem(j + 9) };
                int[] slots = {j + 27, j + 18, j + 9, j};
                
                //hotbar => first row
                if (orginv[0] != null) {
                    inv.setItem(slots[0], orginv[0]);
                } else {
                    inv.clear(slots[0]);
                }
                
                //first row => second row
                if (orginv[1] != null) {
                    inv.setItem(slots[1], orginv[1]);
                } else {
                    inv.clear(slots[1]);
                }
                
                
                //second row => third row
                if (orginv[2] != null) {
                    inv.setItem(slots[2], orginv[2]);
                } else {
                    inv.clear(slots[2]);
                }
                

                //third row => hotbar
                if (orginv[3] != null) {
                    inv.setItem(slots[3], orginv[3]);
                } else {
                    inv.clear(slots[3]);
                }
            }
        }
    }

}
