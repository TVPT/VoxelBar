package com.thevoxelbox.voxelbar;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class VoxelBarToggleManager {
    private static HashMap<String, Boolean> playersEnabled = new HashMap();
    private static VoxelBar vb = VoxelBar.getInstance();
    
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
    

}
