package dev.syncfocus.potffa.utilities;

import org.bukkit.ChatColor;

public class CC {

    public static String PREFIX = CC.format("&7[&c&lPOT&f&lFFA&7] ");

    public static String format(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
