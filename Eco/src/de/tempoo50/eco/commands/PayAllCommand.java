package de.tempoo50.eco.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tempoo50.eco.main.Eco;
import net.milkbowl.vault.economy.EconomyResponse.ResponseType;

public class PayAllCommand implements CommandExecutor {
	
	private Eco plugin = Eco.getPlugin();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(args.length == 1) {
			
			Integer amount = Integer.valueOf(args[0]);
			
			for(Player all : Bukkit.getOnlinePlayers()) {
				
				if(plugin.econ.depositPlayer(all.getName(), amount).type == ResponseType.SUCCESS) {
					all.sendMessage("Du hast " + amount + " erhalten");
				}							
			}			
		}		
		return false;
	}

}
