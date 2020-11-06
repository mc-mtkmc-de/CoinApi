package de.tempoo50.eco.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tempoo50.eco.utils.CoinAPI;

public class EcoCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(args.length == 0) {
				
				player.sendMessage("Dein Kontostand beträgt " + CoinAPI.getCoins(player.getName()));
				
			}
			
		}
		
		return false;
	}

}
