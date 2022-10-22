package dev.syncfocus.potffa.events;

import dev.syncfocus.potffa.configuration.Config;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.util.Vector;

public class PotEvents implements Listener {

    @EventHandler
    public void onSplashPotion(PotionSplashEvent event){
        if (event.getEntityType() == EntityType.SPLASH_POTION && (event.getEntity()).getShooter() instanceof Player){
            Vector velocity = event.getPotion().getVelocity();

            velocity.setY(velocity.getY() - Double.parseDouble(Config.get().getString("throw-speed")));

            event.getPotion().setVelocity(velocity);

            }
        }
}
