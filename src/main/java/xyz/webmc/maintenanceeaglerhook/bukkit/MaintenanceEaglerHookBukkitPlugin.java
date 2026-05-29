package xyz.webmc.maintenanceeaglerhook.bukkit;

import xyz.webmc.maintenanceeaglerhook.core.IMaintenanceEaglerHookPluginImpl;
import xyz.webmc.maintenanceeaglerhook.core.MaintenanceEaglerHook;

import dev.colbster937.reflect.MirrorSafe;
import eu.kennytv.maintenance.core.MaintenancePlugin;
import eu.kennytv.maintenance.spigot.MaintenanceSpigotPlugin;
import net.lax1dude.eaglercraft.backend.server.api.bukkit.event.EaglercraftMOTDEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.CachedServerIcon;

public final class MaintenanceEaglerHookBukkitPlugin extends JavaPlugin implements IMaintenanceEaglerHookPluginImpl, Listener {
  @Override
  public final void onEnable() {
    this.getServer().getPluginManager().registerEvents(this, this);
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public final void onEaglerMOTD(final EaglercraftMOTDEvent event) {
    MaintenanceEaglerHook.handleMOTD(this, event);
  }

  @Override
  public final byte[] getFavicon(final MaintenancePlugin plugin) {
    final MaintenanceSpigotPlugin sPlugin = (MaintenanceSpigotPlugin) plugin;
    final CachedServerIcon favicon = sPlugin.getFavicon();
    final String base64 = MirrorSafe.getFieldValue(favicon, "value");
    return MaintenanceEaglerHook.getDataURIBytes(base64);
  }
}
