package de.st_ddt.crazylogin.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.painting.PaintingBreakByEntityEvent;
import org.bukkit.event.painting.PaintingPlaceEvent;

import de.st_ddt.crazylogin.CrazyLogin;

@SuppressWarnings("deprecation")
public class CrazyLoginPlayerListener_132 extends CrazyLoginPlayerListener
{

	public CrazyLoginPlayerListener_132(final CrazyLogin plugin)
	{
		super(plugin);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
	public void PaintingPlace(final PaintingPlaceEvent event)
	{
		final Player player = event.getPlayer();
		if (plugin.isLoggedIn(player))
			return;
		event.setCancelled(true);
		plugin.requestLogin(player);
	}

	@EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
	public void PaintingBreak(final PaintingBreakByEntityEvent event)
	{
		if (!(event.getRemover() instanceof Player))
			return;
		final Player player = (Player) event.getRemover();
		if (plugin.isLoggedIn(player))
			return;
		event.setCancelled(true);
		plugin.requestLogin(player);
	}
}