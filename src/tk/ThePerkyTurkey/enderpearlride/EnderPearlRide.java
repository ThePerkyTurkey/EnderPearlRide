package tk.ThePerkyTurkey.enderpearlride;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class EnderPearlRide extends JavaPlugin {
	
	private EnderPearlRide epr;
	private Logger logger;

	@Override
	public void onEnable() {
		this.epr = this;
		this.logger = this.getLogger();
		epr.logger.info("EnderPearlRide has started!");
		epr.getServer().getPluginManager().registerEvents(new EnderPearlListener(), epr);
		epr.getCommand("enderpearlride").setExecutor(new EnderPearlCommand());
	}
}
