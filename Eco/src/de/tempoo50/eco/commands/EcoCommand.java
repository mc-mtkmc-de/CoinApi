package de.tempoo50.eco.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tempoo50.eco.main.Eco;

public class EcoCommand implements CommandExecutor{
	
	private Eco plugin = Eco.getPlugin();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(sender instanceof Player) {			
			Player player = (Player) sender;
			
			if(args.length == 0) {
				if(!plugin.econ.hasAccount(player)) {
					player.sendMessage("Du hast kein Konto!");
				}else {
					player.sendMessage("Dein Kontostand beträgt " + plugin.econ.getBalance(player.getName()));
				}				
			}
		}
		
		return false;
	}

}
