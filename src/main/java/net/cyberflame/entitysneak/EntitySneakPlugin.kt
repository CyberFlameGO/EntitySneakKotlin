package net.cyberflame.entitysneak;

import net.cyberflame.entitysneak.listeners.SneakListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EntitySneakPlugin extends JavaPlugin
{
    public void onEnable()
    {
        Bukkit.getPluginManager().registerEvents(new SneakListener(), this);
        System.out.println("EntitySneak was enabled successfully!");
    }
}
