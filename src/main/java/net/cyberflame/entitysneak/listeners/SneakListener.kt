package net.cyberflame.entitysneak.listeners

import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.entity.Player
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class SneakListener : Listener {
    @EventHandler
    fun playerSneaks(e: PlayerToggleSneakEvent) {
        val p = e.player
        if (p.isSneaking) {
            val w = p.world
            val entities = w.getNearbyEntities(p.location, 4.0, 4.0, 4.0)
            var leastDistanceCurrently = Double.MAX_VALUE
            var closestEntity: Entity? = null
            for (ent in entities) {
                val distance = ent.location.distance(p.location)
                if (distance < leastDistanceCurrently && ent.uniqueId !== p.uniqueId) {
                    leastDistanceCurrently = distance
                    closestEntity = ent
                }
            }
            if (closestEntity != null) {
                p.passenger = closestEntity
            }
        }
    }
}