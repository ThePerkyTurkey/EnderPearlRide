package tk.ThePerkyTurkey.enderpearlride;

import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.projectiles.ProjectileSource;

public class EnderPearlListener implements Listener {
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent ev) {
		Projectile proj = ev.getEntity();
		if(proj instanceof EnderPearl) {
			EnderPearl pearl = (EnderPearl) proj;
			ProjectileSource source = pearl.getShooter();
			if(source instanceof Player) {
				Player p = (Player) source;
				if(EnderPearlCommand.isRiding(p)) {
					pearl.setPassenger(p);
				}
			}
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			
			if(e.getCause().equals(DamageCause.FALL)) {
				if(EnderPearlCommand.isRiding(p)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		if(e.getCause().equals(TeleportCause.ENDER_PEARL)) {
			if(EnderPearlCommand.isRiding(e.getPlayer())) {
				e.setCancelled(true);
			}
		}
	}

}
