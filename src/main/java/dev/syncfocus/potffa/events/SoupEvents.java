package dev.syncfocus.potffa.events;

import dev.syncfocus.potffa.configuration.Config;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SoupEvents implements Listener {

    @EventHandler
    @Deprecated
    public void onSoupEat(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (p.getItemInHand() != null && p.getItemInHand().getType() == Material.MUSHROOM_STEW && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (p.getHealth() != 20.0 && p.getHealth() != 0.0) {
                p.setHealth(Math.min(p.getHealth() + 7.0, p.getMaxHealth()));
                p.getItemInHand().setType(Material.valueOf(Config.get().getString("replace-item")));
                final ItemStack replace = new ItemStack(Material.valueOf(Config.get().getString("replace-item")));
                p.setItemInHand(replace);
            }
            p.setSprinting(false);
        }
    }
}
