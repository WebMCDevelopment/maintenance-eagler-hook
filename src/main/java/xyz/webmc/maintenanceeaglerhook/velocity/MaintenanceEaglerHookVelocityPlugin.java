package xyz.webmc.maintenanceeaglerhook.velocity;

import xyz.webmc.maintenanceeaglerhook.core.IMaintenanceEaglerHookPluginImpl;
import xyz.webmc.maintenanceeaglerhook.core.MaintenanceEaglerHook;

import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import eu.kennytv.maintenance.core.MaintenancePlugin;
import eu.kennytv.maintenance.velocity.MaintenanceVelocityPlugin;
import net.lax1dude.eaglercraft.backend.server.api.velocity.event.EaglercraftMOTDEvent;

@SuppressWarnings({ "deprecation" })
public final class MaintenanceEaglerHookVelocityPlugin implements IMaintenanceEaglerHookPluginImpl {
  @Subscribe(priority = 99, order = PostOrder.LAST)
  public final void onEaglerMOTD(final EaglercraftMOTDEvent event) {
    MaintenanceEaglerHook.handleMOTD(this, event);
  }

  @Override
  public final byte[] getFavicon(final MaintenancePlugin plugin) {
    final MaintenanceVelocityPlugin vPlugin = (MaintenanceVelocityPlugin) plugin;
    return MaintenanceEaglerHook.getDataURIBytes(vPlugin.getFavicon().getBase64Url());
  }
}
