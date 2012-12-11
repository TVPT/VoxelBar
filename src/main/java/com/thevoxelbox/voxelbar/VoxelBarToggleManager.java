package com.thevoxelbox.voxelbar;

import java.util.HashMap;

public class VoxelBarToggleManager {
    private HashMap<String, Boolean> playersEnabled = new HashMap();
    private VoxelBar vb;
    public VoxelBarToggleManager(VoxelBar vbar) {
        vb = vbar;
    }
    
    public void setStatus(String player, boolean val) {
        playersEnabled.put(player, val);
   
    }
    public void savePlayers() {
        for (String p : playersEnabled.keySet()) {
            vb.getConfig().set("players." + p, playersEnabled.get(p));
        }
        vb.saveConfig();
    }
    public void loadPlayers() {
        if (vb.getConfig().contains("players")) {
            for (String p : vb.getConfig().getStringList("players")) {
                playersEnabled.put(p, vb.getConfig().getBoolean("players." + p, false));
            }
        }
    }
    
    public boolean isEnabled(String player) {
        if (playersEnabled.containsKey(player)) {
            return playersEnabled.get(player);
        }
        return true;
    }
    

}
