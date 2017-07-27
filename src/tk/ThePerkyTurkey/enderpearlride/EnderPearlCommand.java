package tk.ThePerkyTurkey.enderpearlride;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.ChatColor;

public class EnderPearlCommand implements CommandExecutor{
	
	private static List<Player> riding = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("This command is for Players only!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(!p.hasPermission("epr.ride")) {
			p.sendMessage(ChatColor.RED + "You don't have permission to do this!");
			return true;
		}
		
		if(isRiding(p)) {
			riding.remove(p);
			p.sendMessage(ChatColor.GREEN + "You are no longer able to ride enderpearls!");
			return true;
		} else {
			riding.add(p);
			p.sendMessage(ChatColor.GREEN + "You are now able to ride enderpearls!");
			return true;
		}
	}
	
	public static boolean isRiding(Player p) {
		return riding.contains(p);
	}

}
