package xyz.webmc.maintenanceeaglerhook.bungee;

import xyz.webmc.maintenanceeaglerhook.core.IMaintenanceEaglerHookPluginImpl;
import xyz.webmc.maintenanceeaglerhook.core.MaintenanceEaglerHook;

import eu.kennytv.maintenance.bungee.MaintenanceBungeePlugin;
import eu.kennytv.maintenance.core.MaintenancePlugin;
import net.lax1dude.eaglercraft.backend.server.api.bungee.event.EaglercraftMOTDEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public final class MaintenanceEaglerHookBungeePlugin extends Plugin implements IMaintenanceEaglerHookPluginImpl, Listener {
  @Override
  public final void onEnable() {
    this.getProxy().getPluginManager().registerListener(this, this);
  }

  @EventHandler(priority = 99)
  public final void onEaglerMOTD(final EaglercraftMOTDEvent event) {
    MaintenanceEaglerHook.handleMOTD(this, event);
  }

  @Override
  public final byte[] getFavicon(final MaintenancePlugin plugin) {
    final MaintenanceBungeePlugin bPlugin = (MaintenanceBungeePlugin) plugin;
    return MaintenanceEaglerHook.getDataURIBytes(bPlugin.getFavicon().getEncoded());
  }
}
