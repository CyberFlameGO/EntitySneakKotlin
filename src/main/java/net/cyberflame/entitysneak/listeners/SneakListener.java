package net.cyberflame.entitysneak.listeners;

import java.util.Collection;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;


public class SneakListener implements Listener
{
    @EventHandler
    public void playerSneaks(PlayerToggleSneakEvent e)
    {
        Player p = e.getPlayer();
        if (p.isSneaking())
        {
            World w = p.getWorld();
            Collection<Entity> entities = w.getNearbyEntities(p.getLocation(), 4, 4, 4);
            double leastDistanceCurrently = Double.MAX_VALUE;
            Entity closestEntity = null;
            for (Entity entity : entities)
            {
                double distance = entity.getLocation().distance(p.getLocation());
                if (distance < leastDistanceCurrently && entity.getUniqueId() != p.getUniqueId())
                {
                    leastDistanceCurrently = distance;
                    closestEntity = entity;
                }
            }
            if (closestEntity != null)
            {
                p.setPassenger(closestEntity);
            }

        }
    }
}