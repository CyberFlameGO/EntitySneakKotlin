package net.cyberflame.entitysneak

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.Bukkit
import net.cyberflame.entitysneak.listeners.SneakListener

class EntitySneakPlugin : JavaPlugin() {
    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(SneakListener(), this)
        println("EntitySneak was enabled successfully!")
    }
}