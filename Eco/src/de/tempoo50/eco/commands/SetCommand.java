package de.tempoo50.eco.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tempoo50.eco.main.Eco;
import de.tempoo50.eco.utils.CoinAPI;

public class SetCommand implements CommandExecutor {
	
	private Eco plugin = Eco.getPlugin();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(args.length == 2) {
				
				Player target = Bukkit.getPlayer(args[0]);
				Integer setAmount = Integer.valueOf(args[1]);
				
				if(target != null) {
					
					double amount = plugin.econ.getBalance(target);
					plugin.econ.withdrawPlayer(target, amount);
					plugin.econ.depositPlayer(target, setAmount);
					
					player.sendMessage("Du hast " + target.getName() + " " + amount + " gegeben!");
					target.sendMessage("Du hast " + amount + " vom Server erhalten!");
					
				}
				
			}
			
		}
		
		return false;
	}

}
